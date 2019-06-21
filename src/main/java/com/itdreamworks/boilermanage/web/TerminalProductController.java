package com.itdreamworks.boilermanage.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdreamworks.boilermanage.entity.TerminalProduct;
import com.itdreamworks.boilermanage.mapper.ProductUserMapper;
import com.itdreamworks.boilermanage.mapper.TerminalProductMapper;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品信息
 */
@RestController
@RequestMapping("/terminalproduct")
public class TerminalProductController {

    @Autowired
    TerminalProductMapper userProductMapper;
    @Autowired
    ProductUserMapper productUserMapper;

    @GetMapping("/terminalproductlistbyuserid")
    public Result getTerminalProductListByCondition(Integer userId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<TerminalProduct> list = userProductMapper.getTerminalProductListByUserId(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/editterminalproduct")
    public Result editTerminalProduct(@RequestBody TerminalProduct terminalProduct){
       if(terminalProduct.getId()!=null){
           userProductMapper.updateTerminalProduct(terminalProduct);
       }else{
           userProductMapper.insertTerminalProduct(terminalProduct);
       }
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping( "/deleteterminalproductbyid")
    public Result deleteTerminalProductById(@RequestParam int id) {
        userProductMapper.deleteTerminalProductById(id);
        return ResultGenerator.genSuccessResult();
    }
}
