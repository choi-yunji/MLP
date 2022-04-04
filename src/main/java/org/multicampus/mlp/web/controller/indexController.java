package org.multicampus.mlp.web.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.User;
import org.multicampus.mlp.config.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class indexController {
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        SessionUser user = (SessionUser)httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getUserName());
        }
        return "index";
    }
}
