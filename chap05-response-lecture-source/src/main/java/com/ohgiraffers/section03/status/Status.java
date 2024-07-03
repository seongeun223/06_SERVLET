package com.ohgiraffers.section03.status;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/status")
public class Status extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 200, 400, 401, 404, 500

        response.sendError(404, "없는 페이지입니다. 경로를 확인해주세요");

        response.sendError(500, "서버 내부 오류입니다. 서버 오류는 개발자의 잘못");

        response.sendError(200, "");

        response.sendError(400, "잘못된 문법입니다. 서버가 요청을 이해할 수 없습니다.");

        response.sendError(401, "요청한 응답을 받기 위해서는 인증이 필요합니다.");

    }

}
