package com.itdreamworks.boilermanage.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdreamworks.boilermanage.entity.ProductUser;
import com.itdreamworks.boilermanage.entity.UserProduct;
import com.itdreamworks.boilermanage.mapper.ProductUserMapper;
import com.itdreamworks.boilermanage.mapper.UserProductMapper;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品信息
 */
@RestController
@RequestMapping("/userproduct")
public class UserProductController {

    @Autowired
    UserProductMapper userProductMapper;
    @Autowired
    ProductUserMapper productUserMapper;

    @GetMapping("/userproductlistbyuserid")
    public Result getUserProductListByCondition(Integer userId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<UserProduct> list = userProductMapper.getUserProductListByUserId(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/edituserproduct")
    public Result editUserProduct(@RequestBody UserProduct userProduct){
       if(userProduct.getId()!=null){
           userProductMapper.updateUserProduct(userProduct);
       }else{
           userProductMapper.insertUserProduct(userProduct);
       }
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping( "/deleteuserproductbyid")
    public Result deleteProductById(@RequestParam int id) {
        userProductMapper.deleteUserProductById(id);
        return ResultGenerator.genSuccessResult();
    }
}
