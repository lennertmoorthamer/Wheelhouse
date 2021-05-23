package com.CookieBackEnd.CookieBackEnd;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CookieRepository extends JpaRepository<Cookie, Long> {
}
