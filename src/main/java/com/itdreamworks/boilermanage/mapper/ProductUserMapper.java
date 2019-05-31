package com.itdreamworks.boilermanage.mapper;

import com.itdreamworks.boilermanage.entity.ProductUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductUserMapper {

    @Select("<script>" +
            "select DISTINCT pu.* from Product_User pu" +
            "<where>" +
            " 1=1 " +
            "<if test='productId != null'> " +
            " AND ProductId=#{productId} " +
            "</if>" +
            "</where>" +
            "</script>")
    List<ProductUser> getProductUserListByCondition(ProductUser productUser);

    @Insert("insert into Product_User (UserId,ProductId) values (#{userId},#{productId})")
    void inserProductUser(ProductUser productUser);

    @Insert("<script>" +
            "insert into Product_User(UserId,ProductId)"
            + "values "
            + "<foreach collection =\"productUserList\" item=\"productUser\" index=\"index\" separator =\",\"> "
            + "(#{productUser.userId},#{productUser.productId}) "
            + "</foreach > " +
            "</script>")
    void insertManyProductUser(@Param("productUserList") List<ProductUser> productUserList);

    @Delete("delete from Product_User where ProductId=#{productId}")
    void deleteByProductId(Integer productId);

    @Delete("delete from Product_User where UserId=#{userId}")
    void deleteByUserId(Integer userId);

    @Delete({
            "<script>"
                    + " delete from Product_User WHERE UserId in "
                    + "<foreach item='item' index='index' collection='deleteProductUserList' open='(' separator=',' close=')'>"
                    + " #{item.userId} "
                    + "</foreach>"
                    + "</script>"
    })
    void deleteManyUserByUserId(@Param("deleteProductUserList") List<ProductUser> deleteProductUserList);

    /**
     * 已产品为出发点，根据用户Id列表删除映射关系
     *
     * @param deleteProductUserList
     */
    @Delete({
            "<script>"
                    + " delete from Product_User WHERE ProductId=#{productId} and UserId in "
                    + "<foreach item='item' index='index' collection='deleteProductUserList' open='(' separator=',' close=')'>"
                    + " #{item.userId} "
                    + "</foreach>"
                    + "</script>"
    })
    void deleteByProductAndUserList(int productId, @Param("deleteProductUserList") List<ProductUser> deleteProductUserList);

    /**
     * 已用户为出发点，根据用户Id列表删除映射关系
     *
     * @param deleteProductUserList
     */
    @Delete({
            "<script>"
                    + " delete from Product_User WHERE UserId=#{userId} and ProductId in "
                    + "<foreach item='item' index='index' collection='deleteProductUserList' open='(' separator=',' close=')'>"
                    + " #{item.productId} "
                    + "</foreach>"
                    + "</script>"
    })
    void deleteByUserAndProductList(int userId, @Param("deleteProductUserList") List<ProductUser> deleteProductUserList);

}
