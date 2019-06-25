package com.itdreamworks.boilermanage.web;

import com.itdreamworks.boilermanage.entity.User;
import com.itdreamworks.boilermanage.mapper.UserMapper;
import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
//import net.unicon.cas.client.configuration.EnableCasClient;
//import org.jasig.cas.client.authentication.AttributePrincipal;
//import org.jasig.cas.client.util.AbstractCasFilter;
//import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;
//@EnableCasClient
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/cs")
    public String get(HttpServletRequest request) {
        System.out.println(request.getUserPrincipal());
        return "test success";
    }

    @Autowired
    private UserMapper mapper;

//    @GetMapping("/signIn")
//    public Result signIn(HttpServletRequest request) {
//        //获取cas给我们传递回来的对象，这个对象在Session中
//        //session的 key是 CONST_CAS_ASSERTION
//        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
//
//        Principal principal = assertion.getPrincipal();
//
//        String loginName = principal.getName();
//        System.out.printf("登录用户名:%s\r\n", loginName);
//        User user = mapper.findOneByLoginId(loginName);
//        System.out.printf("ValidFromDate:%s\r\n", assertion.getValidFromDate());
//        System.out.printf("ValidUntilDate:%s\r\n", assertion.getValidUntilDate());
//        System.out.printf("AuthenticationDate:%s\r\n", assertion.getAuthenticationDate());
//
//        //获取自定义返回值的数据
//        if (principal instanceof AttributePrincipal) {
//            //cas传递过来的数据
//            Map<String, Object> result = ((AttributePrincipal) principal).getAttributes();
//            for (Map.Entry<String, Object> entry : result.entrySet()) {
//                String key = entry.getKey();
//                Object val = entry.getValue();
//                System.out.printf("%s:%s\r\n", key, val);
//            }
//        }
//        return ResultGenerator.genSuccessResult(1, "success", user);
//
//
//    }

//    @GetMapping("/li")
//    public RedirectView li(HttpServletRequest request) {
//        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
//
//        Principal principal = assertion.getPrincipal();
//
//        String loginName = principal.getName();
//
//        User user = mapper.findOneByLoginId(loginName);
//
//        //model.addAttribute(user);
//        RedirectView redirectView = new RedirectView("http://localhost:8081/");
//        //redirectView.addStaticAttribute("user",user);
//        System.out.println(redirectView);
//        return redirectView;
//        //return "redirect:http://localhost:8081/index.html";
//    }
}


    /*public Result signIn(@RequestParam(name = "loginid") String loginId, @RequestParam(name = "password") String password) {
        User user = mapper.findOneByLoginId(loginId);
        if (null == user)
            return ResultGenerator.genFailResult(0,"用户名或者密码输入错误");
        if (user.getPassword().equals(password)) {
            if (User.STATUS_ENABLE == user.getStatus()) {
                return ResultGenerator.genSuccessResult(1,"success",user);
            } else {
                return ResultGenerator.genFailResult(0,"您的用户账号未审核，请联系系统管理人员！");
            }
        } else {
            return ResultGenerator.genFailResult(0,"用户名或者密码输入错误");
        }
    }*/
