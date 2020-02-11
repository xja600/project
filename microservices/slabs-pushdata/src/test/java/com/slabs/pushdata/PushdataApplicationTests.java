package com.slabs.pushdata;

import com.slabs.pushdata.service.SLAssetInfoService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushdataApplicationTests {

    @Autowired
    SLAssetInfoService2 assetInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() throws Exception{
        assetInfoService.pushDataToBIByStatus("01");
    }
    public void test3(){
//        PushData pushData = new PushData();
//        pushData.configure(SpringApplicationBuilder);
    }
}
