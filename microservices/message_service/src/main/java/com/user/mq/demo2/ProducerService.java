//package com.user.mq.demo2;
//
//
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.websocket.SendResult;
//
//*
// * @author MG01972
// * @date 2019-12-31 15:45
//
//
//public class ProducerService {
//    @Value("${apache.rocketmq.producer.producerGroup}")
//    private String producerGroup;
//
//    @Value("${apache.rocketmq.namesrvAddr}")
//    private String namesrvAddr;
//
//    private DefaultMQProducer producer;
//
//    @PostConstruct
//    public void initProducer() {
//        producer = new DefaultMQProducer(producerGroup);
//        producer.setNamesrvAddr(namesrvAddr);
//        producer.setRetryTimesWhenSendFailed(3);
//        try {
//            producer.start();
//            System.out.println("[Producer 已启动]");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String send(String topic, String tags, String msg) {
//        SendResult result = null;
//        try {
//            Message message = new Message(topic, tags, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
//            result = producer.send(message);
//            System.out.println("[Producer] msgID(" + result.getMsgId() + ") " + result.getSendStatus());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "{\"MsgId\":\"" + result.getMsgId() + "\"}";
//    }
//
//    @PreDestroy
//    public void shutDownProducer() {
//        if (producer != null) {
//            producer.shutdown();
//        }
//    }
//}
