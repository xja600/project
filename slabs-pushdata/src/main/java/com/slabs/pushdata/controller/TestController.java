package com.slabs.pushdata.controller;

import com.slabs.pushdata.service.SLAssetInfoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MG01972
 * @date 2019-09-26 16:49
 */
@Controller
public class TestController {

    @Autowired
    SLAssetInfoService2 assetInfoService2;
    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping(value="getCodeNameByCodeNoAndItemNo", method = RequestMethod.GET)
    @ResponseBody
    public Object list(){
        System.out.println("-----CodeLibraryController.getCodeNameByCodeNoAndItemNo---------------");

        try {
            return "success";
//            return assetInfoService2.pushDataToBIByStatus("02");
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
//        return assetInfoService.pushDataToBIByStatus("02");
    }

}
