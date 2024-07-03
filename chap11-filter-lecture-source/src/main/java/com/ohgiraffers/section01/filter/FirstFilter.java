package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/*
* 특정 주소에만 필터를 걸고 싶다면
* @WebFilter("/first/filter")
* */

// /first로 시작하는 모든 url 요청에 필터를 걸겠다.
@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        // 기본생성자
        // 필터는 톰캣을 start 하는 시점부터 인스턴스를 미리 생성한다.
        System.out.println("FirstFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 인스턴스가 최초 생성될 때 호출되는 메소드
        System.out.println("Filter init 호출");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // Servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드
        System.out.println("Filter doFilter 호출"); // 갈 때

        // 필터에서 처리할 코드가 작성되는 공간

        // 처리 이후 다음 필터 혹은 서블릿이 doGet/doPost를 호출한다.
        filterChain.doFilter(servletRequest,servletResponse);

        // 서블릿에서 처리 이후에 다시 수행할 내용이 있으면 작성
        System.out.println("Servlet 요청 수행 완료"); // 올 때

    }

    @Override
    public void destroy() {
        // 필터 인스턴스가 소멸될 때 호출되는 메소드 (=톰캣 종료 시)
        System.out.println("Filter destroy 호출");
    }
}
