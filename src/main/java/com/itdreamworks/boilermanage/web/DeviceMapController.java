package com.itdreamworks.boilermanage.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdreamworks.boilermanage.entity.DeviceMap;
import com.itdreamworks.boilermanage.mapper.DeviceMapMapper;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备地图
 */
@RestController
@RequestMapping(value = "/deviceMap")
public class DeviceMapController {

    @Autowired
    private DeviceMapMapper deviceMapMapper;

    /**
     * 查询展示设备列表-分页
     * @param deviceMap
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/devicemaplistbyconditionandpage")
    public Result getDeviceMapListByConditionAndPage(DeviceMap deviceMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult( new PageInfo(deviceMapMapper.getDeviceMapListByCondition(deviceMap)));
    }
    /**
     * 查询展示设备列表-不分页
     * @param deviceMap
     * @return
     */
    @GetMapping(value = "/devicemaplistbycondition")
    public Result getdevicemapListByCondition(DeviceMap deviceMap) {
        return ResultGenerator.genSuccessResult(deviceMapMapper.getDeviceMapListByCondition(deviceMap));
    }
    /**
     * 编辑展示设备
     * @param deviceMap
     * @return
     */
    @PostMapping("/editdevicemap")
    public Result editDeviceMap(@RequestBody DeviceMap deviceMap){
        if(deviceMap.getId()!=null){
            deviceMapMapper.updateDeviceMap(deviceMap);
        }else{
            deviceMapMapper.insertDeviceMap(deviceMap);
        }
        return ResultGenerator.genSuccessResult();
    }
    /**
     * 删除展示设备
     * @param id
     * @return
     */
    @PostMapping(value = "/deletedevicemapbyid")
    public Result deleteDeviceMapById(@RequestParam int id){
        deviceMapMapper.deleteDeviceMapById(id);
        return ResultGenerator.genSuccessResult();
    }
}
