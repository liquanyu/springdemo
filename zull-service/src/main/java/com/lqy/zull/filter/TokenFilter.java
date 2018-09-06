package com.lqy.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018-09-06.
 */
public class TokenFilter extends ZuulFilter{

    //定义filter的类型，有pre、route、post、error四种
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;//定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true;//表示是否需要执行该filter，true表示执行，false表示不执行
    }

    //filter需要执行的具体操作
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("--->>> TokenFilter"+request.getMethod()+";"+request.getRequestURL().toString());

        String token = request.getParameter("token");// 获取请求的参数
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        System.out.println("contextPath="+contextPath);
        System.out.println("servletPath="+servletPath);

        if (StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }

    }
}
