package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class RequestWrapper extends HttpServletRequestWrapper {

    // HttpServletRequestWrapper는 기본생성자가 없기 때문에, request를 전달해주는 생성자가 필요하다.
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {

        String value = "";
        if("password".equals(key)) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            // 암호화를 해준다.
            value = passwordEncoder.encode(super.getParameter(key));

            System.out.println("value ================>" + value);
        } else if("name".equals(key)){
//            Scanner sc = new Scanner(System.in);
//            value = sc.nextLine();
//            System.out.println("value = " + value);

            System.out.println("이름 변경 필터 적용");
            value = "홍길동";
            System.out.println("value : " + value);
        } else{
            value = super.getParameter(key);
        }
        return value;
    }
}
