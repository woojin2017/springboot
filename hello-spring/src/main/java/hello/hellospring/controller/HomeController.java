package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // /는 도메인 첫번째 화면(http://localhost:8080/ 첫 화면)
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
