package org.imobiliaria.imobiliaria.resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OlaResource {
    @RequestMapping("/")
    @ResponseBody
    public String ola() {
        return "Aplicação Funcionando!";
    }
}
