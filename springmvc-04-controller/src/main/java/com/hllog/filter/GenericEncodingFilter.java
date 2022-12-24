package com.hllog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class GenericEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletRequest myRequest = new MyRequest(httpServletRequest);
        filterChain.doFilter(myRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}

class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private boolean hasEncode;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public Map getParameterMap() {
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (method.equalsIgnoreCase("get")) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (!hasEncode) {
                for (String paramterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(paramterName);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            try {
                                values[i] = new String(values[i].getBytes(StandardCharsets.ISO_8859_1),
                                        StandardCharsets.UTF_8);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }
}