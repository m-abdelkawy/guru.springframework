package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "English - Hello from the primary greeting service";
    }
}

