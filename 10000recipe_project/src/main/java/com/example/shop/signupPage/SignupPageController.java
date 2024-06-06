package com.example.shop.signupPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class SignupPageController {

    @Autowired
    private SignupPageRepository signupPageRepository;

    @GetMapping("/signUpPage")
    public String showSignUpForm(Model model) {
        model.addAttribute("signUpPage", "Welcome to the signUp!");
        return "signUpPage";
    }

    @PostMapping("/signup")
    public String signupUser(@RequestParam String id,
                             @RequestParam String username,
                             @RequestParam String password,
                             @RequestParam Date age,
                             @RequestParam String phoneNumber,
                             @RequestParam String email,
                             Model model) {
        SignupPage user = new SignupPage(id, username, password, age, phoneNumber, email);
        signupPageRepository.save(user);
        model.addAttribute("message", "회원가입이 완료되었습니다.");
        return "redirect:/login"; // 리다이렉션 경로 수정
    }
}
