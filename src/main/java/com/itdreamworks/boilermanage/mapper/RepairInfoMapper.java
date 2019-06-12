package com.itdreamworks.boilermanage.mapper;

import com.itdreamworks.boilermanage.entity.RepairInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RepairInfoMapper {

    @Select("select * from repair where productId = #{productId}")
    List<RepairInfo> getRepairInfoListByProductId(Integer productId);

    @Select("select repair.*,product.boilerNo from repair inner join product on repair.productId=product.Id where userId = #{userId}")
    List<RepairInfo> getRepairInfoListByUserId(Integer userId);

    @Select("select repair.*,product.boilerNo from repair inner join product on repair.productId=product.Id where userId = #{userId} " +
            "and repairDate between #{startTime} and #{endTime}")
    List<RepairInfo> getRepairInfoListBydate(@Param("userId") Integer userId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select * from repair where productId = #{productId} and repairDate between #{startTime} and #{endTime}")
    List<RepairInfo> getRepairInfoListByDate(@Param("productId") Integer productId, @Param("startTime") String startTime, @Param("endTime") String endTime);

   @Insert(
            "insert into repair(repairDate,repairName,repairContent,productId,userId,inputName,inputDate)"
            + "values "
            + "(#{repairDate},#{repairName},#{repairContent},#{productId},#{userId},#{inputName},#{inputDate}) ")
    int insertRepairInfo(RepairInfo RepairInfo);

    @Insert(
            "insert into repair(repairDate,repairName,repairContent,productId,userId,inputName,inputDate)"
                    + "values "
                    + "(#{repairDate},#{repairName},#{repairContent},#{productId},#{userId},#{inputName},#{inputDate}) ")
    int insertRepairUserInfo(RepairInfo RepairInfo);

    @Delete("delete from repair where repairId=#{id}")
    void deleteRepairInfoByProductId(int id);
}
