package com.itdreamworks.boilermanage.mapper;

import com.itdreamworks.boilermanage.entity.DeviceMap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMapMapper {

    @Select("<script>" +
            "select * from DeviceMap "+
            "<where>"+
            " 1=1 "+
            "<if test='deviceNo != null and deviceNo.length>0 '> "+
            " AND DeviceNo LIKE CONCAT(CONCAT('%',#{deviceNo}),'%')"+
            "</if>"+
            "<if test='enterpriseId != null'> "+
            " AND EnterpriseId = #{enterpriseId} "+
            "</if>"+
            "</where>"+
            "</script>")
    List<DeviceMap> getDeviceMapListByCondition(DeviceMap deviceMap);

   /* @Select("select cus.CustomerNo from deviceMap cus where cus.Id=#{id}")
    String getCustomerNoById(Integer id);*/

    @Update("update DeviceMap set DeviceNo=#{deviceNo},Longitude=#{longitude},Latitude=#{latitude},EnterpriseId=#{enterpriseId},DeviceType=#{deviceType},Address=#{address} where Id = #{id}")
    void updateDeviceMap(DeviceMap deviceMap);

    @Insert("insert into DeviceMap (DeviceNo,Longitude,Latitude,EnterpriseId,CreateDateTime,DeviceType,Address) values (#{deviceNo},#{longitude},#{latitude},#{enterpriseId},#{createDateTime},#{deviceType},#{address})")
    void insertDeviceMap(DeviceMap deviceMap);

    @Delete("delete from DeviceMap where Id=#{id}")
    void deleteDeviceMapById(Integer id);
}
