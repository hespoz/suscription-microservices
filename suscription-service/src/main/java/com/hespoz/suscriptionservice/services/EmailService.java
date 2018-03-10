package com.hespoz.suscriptionservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by hespoz on 3/9/18.
 */
@FeignClient(name="email-service", fallback = com.hespoz.suscriptionservice.fallbacks.EmailServiceFallback.class)
public interface EmailService {

    @PostMapping("/email")
    Boolean sendEmail(String email);

}
