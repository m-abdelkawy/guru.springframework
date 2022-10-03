package guru.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    public static final String Hello_Gurus = "Hello Gurus!!";

    @Override
    public String sayGreeting() {
        return Hello_Gurus;
    }
}
