package com.itdreamworks.boilermanage.web;

import com.itdreamworks.boilermanage.entity.RepairInfo;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping(value = "/insertrepairinfo")
    public Result insertRepairInfo(@RequestBody RepairInfo repairInfo){
       RepairInfoMapper.insertRepairInfo(repairInfo);
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping(value = "/deleterepairinfo")
    public Result deleteRepairInfoByProductId(@RequestParam int id){
        RepairInfoMapper.deleteRepairInfoByProductId( id);
        return ResultGenerator.genSuccessResult();
    }
}
