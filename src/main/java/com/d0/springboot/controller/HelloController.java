package com.d0.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //  Model을 이용해 넘겨받은 파라미터의 데이터를 View로 전달하는 방식
//  GetMapping은 View를 보여주기 위한 Mappin Annotaion (ViewResolver)
    @GetMapping("/hello")
    public String hello(Model model, @RequestParam String key) {
        model.addAttribute("data", key);
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //  ResponseBody Annotaion을 사용하면 넘겨받은 파라미터 데이터 자체를 브라우저 상에 띄운다.
//  ViewResolver의 간섭을 받지 않는다.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = false) String name) {
        return "hello" + name;
    }

    //  ResponseBody를 이용해 클래스 객체를 반환하면 JSON 형태의 데이터를 브라우저 상에 띄운다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //  Hello 클래서 선언
    static class Hello {
        private String name;

        // Getter / Setter 선언
        // Getter 메소드를 통해 객체에 존재하는 인스턴스 변수를 읽을 수 있게 한다.
        public String getName() { return name; }


        // Setter 메소드를 통ㅇ해 객체에 존재하는 인스턴스 변수를 쓸 수 있게 한다.
        public void setName(String name) {
            this.name = name;
        }
    }
}
