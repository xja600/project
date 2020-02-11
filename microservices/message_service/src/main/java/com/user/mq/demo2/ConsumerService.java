//package com.user.mq.demo2;
//
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.annotation.PostConstruct;
//
///**
// * @author MG01972
// * @date 2019-12-31 15:44
// */
//public class ConsumerService {
//    @Value("${apache.rocketmq.consumer.PushConsumer}")
//    private String consumerGroup;
//    @Value("${apache.rocketmq.namesrvAddr}")
//    private String namesrvAddr;
//
//    @PostConstruct
//    public void defaultMQPushConsumer() {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
//        consumer.setNamesrvAddr(namesrvAddr);
//        try {
//            consumer.subscribe("test1", "push");
//
//            // 如果是第一次启动，从队列头部开始消费
//            // 如果不是第一次启动，从上次消费的位置继续消费
//            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//
//            consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {
//                try {
//                    for (MessageExt messageExt : list) {
//                        String messageBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
//                        System.out.println("[Consumer] msgID(" + messageExt.getMsgId() + ") msgBody : " + messageBody);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            });
//            consumer.start();
//            System.out.println("[Consumer 已启动]");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
