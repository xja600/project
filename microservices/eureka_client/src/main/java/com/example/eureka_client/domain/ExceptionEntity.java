package com.example.eureka_client.domain;

import lombok.Data;

/**
 * @ClassName ExceptionEntity
 * @Description TODD
 * @Author MG01857
 * @Date 2019/4/29
 * @Version 1.0
 **/

@Data
public class ExceptionEntity {

    private String description;

    private String className;

    private String methodName;

    private String params;

}
