package com.ateam.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.service.BookService;

@RequestMapping("/library")
@RestController
public class AppController {
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model uiModel) {
        uiModel.addAttribute("books", bookService.findAll());
        return "index.jsp";
    }
}
