package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

//    웹에서 /hello로 들어오면 이 함수를 호출함.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello~~^^");
        return "hello";
    }
}
