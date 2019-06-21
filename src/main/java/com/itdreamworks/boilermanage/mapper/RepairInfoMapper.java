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

    @Select("select repair.*,product.ControllerNo from repair left join product on repair.productId=product.Id where productId = #{productId}")
    List<RepairInfo> getRepairInfoListByProductId(Integer productId);

    @Select("select repair.*,product.ControllerNo from repair left join product on repair.productId=product.Id where RepairUserId = #{userId}")
    List<RepairInfo> getRepairInfoListByUserId(Integer userId);

    @Select("select repair.*,product.ControllerNo from repair left join product on repair.productId=product.Id where RepairUserId = #{userId} " +
            "and RepairDatetime between #{startTime} and #{endTime}")
    List<RepairInfo> getRepairInfoListBydate(@Param("userId") Integer userId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select repair.*,product.ControllerNo from repair left join product on repair.productId=product.Id where productId = #{productId} and RepairDatetime between #{startTime} and #{endTime}")
    List<RepairInfo> getRepairInfoListByDate(@Param("productId") Integer productId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /*  方法重复  需删除*/
   @Insert(
            "insert into repair(RepairDatetime,RepairUserName,RepairContent,productId,RepairUserId,inputName,inputDatetime)"
            + "values "
            + "(#{repairDatetime},#{repairUserName},#{repairContent},#{productId},#{repairUserId},#{inputName},#{inputDatetime}) ")
    int insertRepairInfo(RepairInfo RepairInfo);

    @Delete("delete from repair where Id=#{id}")
    void deleteRepairInfoByProductId(int id);
}
