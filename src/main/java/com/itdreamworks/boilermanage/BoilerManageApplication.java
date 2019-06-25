package com.itdreamworks.boilermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;




@EnableCaching
@SpringBootApplication
@MapperScan("com.itdreamworks.boilermanage.mapper")
public class BoilerManageApplication {

//    private static final String CAS_SERVER_URL_PREFIX = "http://server.cas.com:8080/";
//    private static final String CAS_SERVER_URL_LOGIN = "http://server.cas.com:8080/cas/login";
//
//    //本机的名称
//    private static final String SERVER_NAME = "http://localhost:8091/";
//
//    /**
//     * description: 登录过滤器
//     * @param: []
//     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
//     */
//    @Bean
//    public FilterRegistrationBean filterSingleRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new SingleSignOutFilter());
//        // 设定匹配的路径
//        registration.addUrlPatterns("/*");
//        Map<String,String> initParameters = new HashMap<String, String>();
//        initParameters.put("casServerUrlPrefix", CAS_SERVER_URL_PREFIX);
//        registration.setInitParameters(initParameters);
//        // 设定加载的顺序
//        registration.setOrder(1);
//        return registration;
//    }
//
//
//    /**
//     * description:过滤验证器
//     *     * @param: []
//     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
//     */
//    @Bean
//    public FilterRegistrationBean filterValidationRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
//        // 设定匹配的路径
//        registration.addUrlPatterns("/*");
//        Map<String,String>  initParameters = new HashMap<String, String>();
//        initParameters.put("casServerUrlPrefix", CAS_SERVER_URL_PREFIX);
//        initParameters.put("serverName", SERVER_NAME);
//        initParameters.put("useSession", "true");
//        registration.setInitParameters(initParameters);
//        // 设定加载的顺序
//        registration.setOrder(1);
//        return registration;
//    }
//
//
//    /**
//     * description:授权过滤器
//     * @param: []
//     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
//     */
//    /*@Bean
//    public FilterRegistrationBean filterAuthenticationRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new AuthenticationFilter());
//        // 设定匹配的路径
//        registration.addUrlPatterns("/*");
//        Map<String,String> initParameters = new HashMap<String, String>();
//        initParameters.put("casServerLoginUrl", CAS_SERVER_URL_LOGIN);
//        initParameters.put("serverName", SERVER_NAME);
//        //忽略/logout的路径
//        initParameters.put("ignorePattern", "/logout/*");
//        initParameters.put("ignoreUrlPatternType", "com.itdreamworks.boilermanage.config.SimpleUrlPatternMatcherStrategy");
//
//        registration.setInitParameters(initParameters);
//        // 设定加载的顺序
//        registration.setOrder(1);
//        return registration;
//    }*/
//    @Bean
//    public FilterRegistrationBean filterProductRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new AuthenticationFilter());
//        // 设定匹配的路径
//        registration.addUrlPatterns("/*");
//
//        Map<String,Map<String,String>> parametersMap = new HashMap<String, Map<String, String>>(){};
//        parametersMap.put("logout",initParameters("logout"));
//        parametersMap.put("product",initParameters("product"));
//        parametersMap.put("user",initParameters("user"));
//        parametersMap.put("productauxiliarymachineinfo",initParameters("productauxiliarymachineinfo"));
//        parametersMap.put("auxiliarymachinelargeclass",initParameters("auxiliarymachinelargeclass"));
//        parametersMap.put("auxiliarymachinesmallclass",initParameters("auxiliarymachinesmallclass"));
//        parametersMap.put("boilercustomer",initParameters("boilercustomer"));
//        parametersMap.put("boilermodel",initParameters("boilermodel"));
//        parametersMap.put("customer",initParameters("customer"));
//        parametersMap.put("customerresource",initParameters("customerresource"));
//        parametersMap.put("customeruser",initParameters("customeruser"));
//        parametersMap.put("dictionary",initParameters("dictionary"));
//        parametersMap.put("dictionaryvalue",initParameters("dictionaryvalue"));
//        parametersMap.put("deviceMap",initParameters("deviceMap"));
//        parametersMap.put("resource",initParameters("resource"));
//        parametersMap.put("enterprise",initParameters("enterprise"));
//        parametersMap.put("role",initParameters("role"));
//        parametersMap.put("uploadFile",initParameters("uploadFile"));
//        parametersMap.put("role",initParameters("role"));
//
//        for (String key : parametersMap.keySet()){
//            registration.setInitParameters(parametersMap.get(key));
//        }
//        // 设定加载的顺序
//        registration.setOrder(1);
//        return registration;
//    }
//    private Map<String,String> initParameters(String parameterName){
//        Map<String,String> parameters = new HashMap<String, String>();
//        parameters.put("casServerLoginUrl", CAS_SERVER_URL_LOGIN);
//        parameters.put("serverName", SERVER_NAME);
//        //忽略/logout的路径
//        parameters.put("ignorePattern", "/"+parameterName+"/*");
//        parameters.put("ignoreUrlPatternType", "com.itdreamworks.boilermanage.config.SimpleUrlPatternMatcherStrategy");
//        return parameters;
//    }
//
//    /**
//     * wraper过滤器
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean filterWrapperRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new HttpServletRequestWrapperFilter());
//        // 设定匹配的路径
//        registration.addUrlPatterns("/*");
//        // 设定加载的顺序
//        registration.setOrder(1);
//        return registration;
//    }
//
//    /**
//     * 添加监听器
//     * @return
//     */
//    @Bean
//    public ServletListenerRegistrationBean<EventListener> singleSignOutListenerRegistration(){
//        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<EventListener>();
//        registrationBean.setListener(new SingleSignOutHttpSessionListener());
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

    public static void main(String[] args) {
        SpringApplication.run(BoilerManageApplication.class, args);
    }
}
