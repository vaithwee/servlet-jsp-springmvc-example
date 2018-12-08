package xyz.vaith.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RequesUnicodeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("enter filter");
        final HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletRequest marques = (HttpServletRequest)Proxy.newProxyInstance(RequesUnicodeFilter.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object object = null;
                if (method.getName().equalsIgnoreCase("getParameter")) {
                    if (request.getMethod().equalsIgnoreCase("get")) {
                        String param = (String) method.invoke(request,args);
                        return param;// new String(param.getBytes("iso-8859-1"), "utf-8");
                    } else {
                        request.setCharacterEncoding("utf-8");
                        object = method.invoke(request,args);
                    }
                } else  {
                    object = method.invoke(request,args);
                }
                return object;
            }
        });
        filterChain.doFilter(marques, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
