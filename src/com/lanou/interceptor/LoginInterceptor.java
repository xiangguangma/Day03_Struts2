package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/12.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 如果想指定拦截的动作方法, 则拦截器继承MethodFilterInterceptor,
        // 该类中有两个集合:
        // excludeMethod: 包含排除拦截的方法, 即哪些方法不拦截
        // includeMethod: 包含拦截的方法, 即指定哪些方法进行拦截

        String  username = (String)ServletActionContext.getServletContext().getAttribute("user");
        if (StringUtils.isBlank(username)){
            return "login"; // 如果没登录, 则跳转登录界面
        }
        // 放行
        return actionInvocation.invoke();
    }
}
