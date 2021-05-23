package com.CookieBackEnd.CookieBackEnd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CookieService {

    private CookieRepository cookieRepository;

    @Bean
    CommandLineRunner generateTestData() {
        return args -> {
            cookieRepository.save(new Cookie("New-yorker", 98, "/newYorker.jpg"));
            cookieRepository.save(new Cookie("Brownie", 120, "/brownie.jpg"));
            cookieRepository.save(new Cookie("Macaron", 20 , "/macaron.webp"));
            cookieRepository.save(new Cookie("Boudoir", 61, "/boudoirs.webp"));
            cookieRepository.save(new Cookie("Waffle", 100, "/waffle.jpg"));
        };
    }

    public CookieService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    List<Cookie> getAllCookies() {
        return cookieRepository.findAll();
    }
}
