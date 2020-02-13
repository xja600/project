package com.example.eureka_client.xdclass.jdk.jdk8.stream;

import com.example.eureka_client.xdclass.jdk.jdk8.lambda.FunctionObj;
import com.example.eureka_client.xdclass.jdk.jdk8.lambda.OperFunction;
import com.example.eureka_client.xdclass.jdk.jdk8.lambda.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description :
 * @author xinjunan
 * @date 2020/2/13 17:34
 */

public class Main {
    public static void main(String[] args) {
        try {
            List<String> list = Arrays.asList("springboot教程","微服务教程","并发教程","redis教程","消息队列教程");
            List<String> resultList = list.stream().map(obj->"在小滴课堂学习,"+obj)
            .collect(Collectors.toList());

            System.out.println(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

