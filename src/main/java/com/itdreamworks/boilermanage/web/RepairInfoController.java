package com.itdreamworks.boilermanage.web;

import com.itdreamworks.boilermanage.entity.RepairInfo;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping(value = "/repairinfo")
public class RepairInfoController {

    @Autowired
    com.itdreamworks.boilermanage.mapper.RepairInfoMapper RepairInfoMapper;

    @GetMapping(value = "/repairinfolistbyproductid")
    public Result getRepairInfoListByProductId(Integer productId){
        return  ResultGenerator.genSuccessResult(RepairInfoMapper.getRepairInfoListByProductId(productId));
    }
    @GetMapping(value = "/repairinfolistbyuserid")
    public Result getRepairInfoListByUserId(Integer userId){
        return  ResultGenerator.genSuccessResult(RepairInfoMapper.getRepairInfoListByUserId(userId));
    }
    @GetMapping(value = "/repairinfolistbydate")
    public Result getRepairInfoListByDate(Integer productId, String startTime, String endTime){
        return  ResultGenerator.genSuccessResult(RepairInfoMapper.getRepairInfoListByDate( productId, startTime, endTime));
    }
    @GetMapping(value = "/repairinfolistbyuserdate")
    public Result getRepairInfoListBydate(Integer userId, String startTime, String endTime){
        return  ResultGenerator.genSuccessResult(RepairInfoMapper.getRepairInfoListBydate( userId, startTime, endTime));
    }

    /*  使用此方法方法  删除下个方法*/
   @PostMapping(value = "/insertrepairinfo")
    public Result insertRepairInfo(@RequestBody RepairInfo repairInfo){
       RepairInfoMapper.insertRepairInfo(repairInfo);
        return ResultGenerator.genSuccessResult();
    }

    /*  方法重复  需删除*/
    @PostMapping(value = "/insertrepairuserinfo")
    public Result insertRepairUserInfo(@RequestBody Map<String,Object> RepairInfoList){
        RepairInfo repairInfo = new RepairInfo();
        repairInfo.setRepairDatetime(RepairInfoList.get("repairDatetime").toString());
        repairInfo.setInputName(RepairInfoList.get("inputName").toString());
        repairInfo.setRepairContent(RepairInfoList.get("repairContent").toString());
        repairInfo.setProductId(Integer.parseInt(RepairInfoList.get("productId").toString()));
        repairInfo.setRepairUserId(Integer.parseInt(RepairInfoList.get("repairUserId").toString()));
        repairInfo.setRepairUserName(RepairInfoList.get("repairUserName").toString());
        repairInfo.setInputDatetime(RepairInfoList.get("inputDatetime").toString());
        RepairInfoMapper.insertRepairUserInfo(repairInfo);
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping(value = "/deleterepairinfo")
    public Result deleteRepairInfoByProductId(@RequestParam int id){
        RepairInfoMapper.deleteRepairInfoByProductId( id);
        return ResultGenerator.genSuccessResult();
    }
}
