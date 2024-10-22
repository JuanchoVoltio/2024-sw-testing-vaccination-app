package edu.softwaretesting2.dummymavenapp.vaccination_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService service;

    // Constructor para la inyección de dependencias del servicio
    public HelloController(HelloService service) {
        this.service = service;
    }

    // Definir una ruta explícita para este controlador
    @GetMapping("/hello")
    public String sayHello() {
        return service.sayHello("ES") + "\n";
    }
}
