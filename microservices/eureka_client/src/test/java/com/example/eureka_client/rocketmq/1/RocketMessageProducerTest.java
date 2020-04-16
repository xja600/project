//package com.example.eureka_client.rocketmq;
//
//import javax.annotation.Resource;
//
//import com.example.eureka_client.EurekaClientApplicationTests;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import cn.com.huijintech.jms.rocketmq.producer.RocketMessageProducer;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/spring-producer.xml" })
//public class RocketMessageProducerTest extends EurekaClientApplicationTests {
//
//	private static Logger logger = LoggerFactory.getLogger(RocketMessageProducerTest.class.getName());
//
//	@Resource
//	private RocketMessageProducer messageProducer;
//
//	@Test
//	public void testAddOpinion1() {
//		try {
//			long t = System.currentTimeMillis();
//			for (int i = 2001; i <= 3000; i++) {
//				messageProducer.sendText("ddddddddd====" + i);
//				System.out.println(i);
//			}
//			System.out.println(System.currentTimeMillis() - t);
//			logger.error("------------------");
//			System.in.read();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
