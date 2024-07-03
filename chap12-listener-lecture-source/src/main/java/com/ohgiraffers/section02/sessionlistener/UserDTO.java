package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class UserDTO implements HttpSessionBindingListener {

    private String name;
    private int ade;

    public UserDTO() {
    }

    public UserDTO(String name, int ade) {
        this.name = name;
        this.ade = ade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAde() {
        return ade;
    }

    public void setAde(int ade) {
        this.ade = ade;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", ade=" + ade +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 해당 클래스로 만든 인스턴스가 세션에 바인딩(값이 추가) 되는 경우 동작한다.
        System.out.println("value bound!");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 해당 클래스로 만든 인스턴스가 세션에 바인딩 해제
        // 값 제거 또는 세션이 만료되는 경우 동작한다.
        System.out.println("value unbound!");
    }
}
