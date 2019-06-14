package com.itdreamworks.boilermanage.mapper;

import com.itdreamworks.boilermanage.entity.Customer;
import com.itdreamworks.boilermanage.entity.DeviceMap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMapper {

    @Select("select count(DeviceSuffix) from bksrDB.Device where DeviceSuffix=#{deviceSuffix} and CustomerId=0")
    int getDeviceCount(String deviceSuffix);

    @Update("update bksrDB.Device set CustomerId=#{customerId} where DeviceSuffix=#{deviceSuffix} and CustomerId=0")
    int updateDeviceCustomerInfo(String deviceSuffix,String customerId);

    @Update("update bksrDB.Device set CustomerId=0 where DeviceSuffix=#{deviceSuffix}")
    int clearDeviceCustomerInfo(String deviceSuffix);

}
