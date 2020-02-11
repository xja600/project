package com.slabs.pushdata.utils;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class HttpClient {

	private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

	public static String sendBiHttpPost(Object jsonObject,String url) throws Exception{
		//TODO
		RestTemplate restTemplate = new RestTemplate();

//		biIp = "10.0.22.192";
//		biPort = "20970";

//		StringBuffer urlBuf = new StringBuffer("http://").append(biIp).append(":").append(biPort).append(url);
		logger.info("url:","sendJsonObject{} " ,url , jsonObject);
		System.out.println("url="+url+",param="+JSON.toJSON(jsonObject));
		String resp = "";
		try {
			resp =restTemplate.postForObject(url,JSON.toJSON(jsonObject) , String.class);
			logger.info("result:",resp);
			System.out.println("返回值result="+resp);
		} catch (RestClientException e) {
			logger.info("----attentionError--- ABS调用BI接口出现异常！ {}", e);
			throw new Exception("ABS调用BI接口出现异常!");
		}
		return resp;
	}
}
