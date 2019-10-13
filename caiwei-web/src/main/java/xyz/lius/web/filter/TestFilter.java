package xyz.lius.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TestFilter before");
        chain.doFilter(request, response);
        System.out.println("TestFilter after");
    }

    @Override
    public void destroy() {

    }
}
