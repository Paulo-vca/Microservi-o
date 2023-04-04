package br.com.ifms.lp2.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MeuController {
    @GetMapping("/")
    public String index() {
        return "Olá, mundo!";
    }

}
