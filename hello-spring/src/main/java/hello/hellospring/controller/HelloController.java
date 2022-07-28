package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{


    @GetMapping("hello")
    public String hello(Model model){

        //model은 html을 열 수 있게 해준다
        model.addAttribute("data","hello!!"); //data는 키값 hello!!는 values 값
        return "hello";
    }

    //mvc와 템플릿 엔진 controller
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";

        //http://localhost:8080/hello-mvc?name=spring!!
    }

    /*
        helloString은 화면을 불러올 때 리턴 값을 그대로 받아 보여준다
        mvc의 경우 화면 소스를 보면 html으로 이루어져 있지만 해당 화면의 소스를 출력하면 "hello " + name 값이 나온다
     */
    @GetMapping("hello-string")
    @ResponseBody //http Body 부분에 return 값으로 직접 넣어주는 것
    public String helloString(@RequestParam("name") String name){

        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){

        Hello hello = new Hello();
        hello.setName(name);
        return hello;               //리턴 값은 객체
    }


    static class Hello{
        // json 방식 key 값은 name values 값은 입력 값

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
//api 강의에서 따로 클래스를 만들어 name을 private로 정의해서 getName setName을 만드는 이유가 뭔가요?