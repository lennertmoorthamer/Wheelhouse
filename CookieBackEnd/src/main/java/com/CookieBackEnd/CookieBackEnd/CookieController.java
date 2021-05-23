package com.CookieBackEnd.CookieBackEnd;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@RestController
@RequestMapping(value = "/cookies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CookieController {
    private final CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping
    List<Cookie> getCookie() {
        return cookieService.getAllCookies();
    }
}
