package com.itdreamworks.boilermanage.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdreamworks.boilermanage.entity.Product;
import com.itdreamworks.boilermanage.entity.ProductAboutModel;
import com.itdreamworks.boilermanage.entity.ProductTypeAmountClass;
import com.itdreamworks.boilermanage.entity.ProductUser;
import com.itdreamworks.boilermanage.mapper.ProductAuxiliaryMachineInfoMapper;
import com.itdreamworks.boilermanage.mapper.ProductMapper;
import com.itdreamworks.boilermanage.mapper.ProductUserMapper;
import com.itdreamworks.boilermanage.service.ProductService;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品信息
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductUserMapper productUserMapper;

    @Autowired
    ProductService productService;

    @Autowired
    ProductAuxiliaryMachineInfoMapper productAuxiliaryMachineInfoMapper;
    /**
     * 获得产品列表数据
     * @param product
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/productlistbycondition")
    public Result getProductListByCondition(Product product,int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Product> list =productMapper.getProductListByCondition(product);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @GetMapping("/productTypeAmountByCondition")
    public String getProductTypeAmountByCondition(int userId){
        List<ProductTypeAmountClass> list = productMapper.getProductTypeAmountByUserId(userId);
        Result res =ResultGenerator.genSuccessResult(list);
        String str = res.toString();
        return str;
    }
    /**
     * 获得所分配的用户
     * @param productUser
     * @return
     */
    @GetMapping("/productuserListbycondition")
    public Result getProductUserListByProductCondition(ProductUser productUser){
        return ResultGenerator.genSuccessResult(productUserMapper.getProductUserListByCondition(productUser));
    }

    /**
     * 展示数据在地图上
     * @param product
     * @return
     */
    @GetMapping("/productdataonmap")
    public Result productDataOnMap(Product product){
        return ResultGenerator.genSuccessResult(productMapper.getProductListByCondition(product));
    }

    /**
     * 编辑产品
     * @param product
     * @return
     */
    @PostMapping("/editproduct")
    public Result editProduct(@RequestBody Product product){
        productService.insertProductAndProductUser(product);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 插入多条产品数据
     * @param productAboutModel
     * @return
     */
    @PostMapping("/insertmanyproduct")
    public Result insertManyProduct(@RequestBody ProductAboutModel<Product> productAboutModel) {
        return productService.insertManyProduct(productAboutModel);
    }

    @PostMapping("/insertmanyproductuser")
    public Result insertManyProductUser(@RequestBody Product product){
        List<ProductUser> list = product.getDeleteProductUserList();
        if(null!=product.getDeleteProductUserList()&&list.size()>0){
            //productUserMapper.deleteManyUserByUserId(product.getDeleteProductUserList());
            productUserMapper.deleteByProductAndUserList(list.get(0).getProductId(),product.getDeleteProductUserList());
        }
        if(null!=product.getSelectProductUserList()&&product.getSelectProductUserList().size()>0){
            productUserMapper.insertManyProductUser(product.getSelectProductUserList());
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 修改产品出售相关信息
     * @param product
     * @return
     */
    @PostMapping("/updateproductsellabout")
    public Result updateProductSellAbout(@RequestBody Product product){
        productMapper.updateProductSellAbout(product);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除产品信息
     * @param id
     * @return
     */
    @PostMapping( "/deleteproductbyid")
    public Result deleteProductById(@RequestParam int id,@RequestParam String controllerNo) {
        int code = productService.deleteProduct(id,controllerNo);
       if(0 == code)
            return ResultGenerator.genSuccessResult();
       else
           return ResultGenerator.genFailResult(code,"删除失败");
    }
}
