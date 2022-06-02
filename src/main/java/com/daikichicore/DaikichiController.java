package com.daikichicore;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
    @RequestMapping("")
    public String index() {
        return "Bienvenido a la App Principal!!";
    }

    @RequestMapping("/saludo")
    public String saludo(@RequestParam(value = "name", required = false) String nombre)   {
        if(nombre==null) {
            return "Hola: Anonimo";
        } else {
            return "Hola: "+nombre;
        }
    }

    @RequestMapping("/saludos/{nombre}/{frase}")
    public String saludoPersonalizado(@PathVariable("nombre") String nombres,
                                      @PathVariable("frase") String frase) {
        if(nombres=="Rolin") {
            return "Hola: " +nombres+" Y tu frase es: "+frase;
        } else {
            return "Hola: " +nombres+" voy a describirte tu frase en unos segundos.. : "+frase;
        }
    }

    @RequestMapping("/travel/{ciudad}")
    public String travel(@PathVariable("ciudad") String ciudad) {
        return "¡Felicitaciones! ¡Pronto viajarás a.. "+ciudad+"!!";
    }

    @RequestMapping("/lotto/{numero}")
    public String variado(@PathVariable("numero") int valor) {
        if(valor%2==0) {
            return "Harás un gran viaje en un futuro cercano, pero ten cuidado con las ofertas tentadoras";
        } else {
            return "Has disfrutado de los frutos de tu trabajo, pero ahora es un buen momento para pasar tiempo con familiares y amigos";
        }
    }
}
