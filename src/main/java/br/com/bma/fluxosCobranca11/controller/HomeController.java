package br.com.bma.fluxosCobranca11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    public HomeController() {
    }

    @GetMapping
    public String getString() {
        return "fluxos Cobrança versão 2.0 - Java 11";
    }
}
