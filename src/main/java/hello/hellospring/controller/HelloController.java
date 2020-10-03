package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    웹에서 /hello로 들어오면 이 함수를 호출함.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello~~^^");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name", required = false) String name, Model model) {
        model.addAttribute("name",name) ;
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 바디부에 직접 이 데이터를 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    //객체이면 JsonConverter가 동작함.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("number") int number){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNumber(number);
        return hello;
    }

    static class Hello{
        private String name;
        private int number;

        public void setNumber(int number) {
            this.number = number;
        }

        public int getNumber(){
            return number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
