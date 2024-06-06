package com.example.shop.home;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        // 필요한 데이터를 모델에 추가할 수 있습니다.
        model.addAttribute("home", "Welcome to the Shop!");
        return "home";  // templates 디렉토리에 있는 home.html 파일을 렌더링합니다.
    }
}
