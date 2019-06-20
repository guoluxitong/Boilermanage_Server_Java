package com.itdreamworks.boilermanage.mapper;

import com.itdreamworks.boilermanage.entity.TerminalProduct;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TerminalProductMapper {
@Select("select end_sdcsoft_db.terminal_product.* from end_sdcsoft_db.terminal_product where UserId=#{userId}")
    List<TerminalProduct> getTerminalProductListByUserId(Integer userId);

    @Insert("insert into end_sdcsoft_db.terminal_product(BoilerName,ControllerNo,UserId) " +
            " values(#{boilerName},#{controllerNo},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTerminalProduct(TerminalProduct terminalProduct);

    @Update("update end_sdcsoft_db.terminal_product set" +
            " BoilerName=#{boilerName},ControllerNo=#{controllerNo}, UserId=#{userId} where Id=#{id}")
    void updateTerminalProduct(TerminalProduct terminalProduct);

    @Delete("delete from end_sdcsoft_db.terminal_product where Id=#{id}")
    void deleteTerminalProductById(Integer id);

}
