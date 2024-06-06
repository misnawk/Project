package com.example.shop.loginPage;

import com.example.shop.signupPage.SignupPage;
import com.example.shop.signupPage.SignupPageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private SignupPageRepository signupPageRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "Welcome to the Shop!");
        return "loginPage";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        SignupPage user = signupPageRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("message", "로그인 성공");
            return "home";
        } else {
            model.addAttribute("message", "로그인 실패: 아이디나 비밀번호를 확인하세요.");
            return "loginPage";
        }
    }
}
