package edu.tust.springsecuritydemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 18:57
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("")
    public String hello(Model model) {
        model.addAttribute("name", "Linht");
        return "hello";
    }
}

