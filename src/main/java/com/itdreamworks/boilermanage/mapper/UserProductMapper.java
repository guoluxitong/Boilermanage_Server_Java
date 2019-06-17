package com.itdreamworks.boilermanage.mapper;

import com.itdreamworks.boilermanage.entity.UserProduct;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserProductMapper {
@Select("select user_product.user_product.* from user_product.user_product left join bksrDB.Employee on user_product.user_product.UserId=bksrDB.Employee.Id where UserId=#{userId}")
    List<UserProduct> getUserProductListByUserId(Integer userId);



    @Insert("INSERT into user_product.user_product(BoilerName,ControllerNo,UserId) " +
            " VALUES(#{boilerName},#{controllerNo},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUserProduct(UserProduct userProduct);
    @Update("update user_product.user_product set" +
            " BoilerName=#{boilerName},ControllerNo=#{controllerNo}, UserId=#{userId} where Id=#{id}")
    void updateUserProduct(UserProduct userProduct);

    @Delete("delete from user_product.user_product where Id=#{id}")
    void deleteUserProductById(Integer id);

}
