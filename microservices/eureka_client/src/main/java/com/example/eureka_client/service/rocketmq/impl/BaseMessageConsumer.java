package com.example.eureka_client.service.rocketmq.impl;

import java.util.List;
import java.util.Map;

import com.example.eureka_client.service.rocketmq.AbstractMessageConusmer;
import com.example.eureka_client.service.rocketmq.RocketMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lishangjiang
 * 
 */
public abstract class BaseMessageConsumer extends AbstractMessageConusmer<byte[]> {

	private final static Logger logger = LoggerFactory.getLogger(BaseMessageConsumer.class);

	@Autowired
	private RocketMQPushConsumer consumer;

	private String topic;

	private String tags;

	private Map<String, String> topicTagMap;

	public void setConsumer(RocketMQPushConsumer consumer) {
		this.consumer = consumer;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setTopicTagMap(Map<String, String> topicTagMap) {
		this.topicTagMap = topicTagMap;
	}

	protected void init() throws MQClientException {
		if (null != topic && null != tags) {
			consumer.subscribe(topic, tags);
		}
		if (null != topicTagMap && topicTagMap.size() > 0) {
			for (String topicc : topicTagMap.keySet()) {
				String tagss = topicTagMap.get(topicc);
				if (null != topicc && null != tagss) {
					consumer.subscribe(topicc, tagss);
				}
			}
		}

		consumer.registerMessageListener(new MessageListenerConcurrently() {
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
				Message msg = list.get(0);
				logger.info(msg.toString());
				byte[] message = msg.getBody();
				processMessage(message);
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.start();
	}
}