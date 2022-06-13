package com.example.session.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @PostMapping("/login")
    public String login(HttpSession session) {

        // 세션 생성
//        session.setMaxInactiveInterval(30 * 60); // timeout 30분 설정
        session.setMaxInactiveInterval(-1);
        session.setAttribute("id", "userid");
        session.setAttribute("name", "username");
        return session.getId();
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {

        // 세션 삭제
        session.invalidate();
        return session.getId();
    }

    @PostMapping("/info")
    public String info(HttpSession session) {

        // 세션값 가져오기
        Object id = session.getAttribute("id");
        Object name = session.getAttribute("name");

        return id.toString() + ", " + name.toString();
    }
}
