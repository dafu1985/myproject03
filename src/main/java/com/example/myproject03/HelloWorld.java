package com.example.myproject03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // ①@ControllerをつけることでこのClassがユーザからのアクセスを受け取ることができる
public class HelloWorld {
    @GetMapping("/") // ②@GetMapping("/")とすると、httpメソッドがGETでURLが/のアクセスがあるとこのメソッドが呼ばれるようになる
    //()の中のパスは、http://localhost:8080に続く内容を表す
    	//例えば@GetMapping("/users")だとhttp://localhost:8080/usersにマッピングされる
    public String hello() {
        return "hello"; // ③src/main/resources/templates/配下のhello.htmlをユーザに返す
        //Stringを返しているだけなのになぜそんな動きをするかというと、このClassに@Controllerがついているから
        //hello.html
    }
}