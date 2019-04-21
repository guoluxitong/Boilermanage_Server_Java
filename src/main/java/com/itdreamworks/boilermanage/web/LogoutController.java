package com.itdreamworks.boilermanage.web;

import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@EnableCasClient
@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping("/logoutDefault")
    public String logout1(HttpSession session) {
        session.invalidate();

        // 直接退出，走默认退出方式
        return "redirect:http://server.cas.com:8080/cas/logout";
    }

    @GetMapping("/out")
    public String logout2(HttpSession session) {
        session.invalidate();
        // 退出登录后，跳转到退出成功的页面，不走默认页面
        return "redirect:http://server.cas.com:8080/cas/logout?service=http://localhost:8091/logout/success";
    }

    @GetMapping("/success")
    public String logout2() {
        return "/index";
    }
}
