package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class PrimarySpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Servicio de Saludo Primario";
    }
}
