package com.hespoz.suscriptionservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hespoz on 3/9/18.
 */
@FeignClient(name="email-service", fallback = com.hespoz.suscriptionservice.fallbacks.EmailServiceFallback.class)
public interface EmailService {

    @RequestMapping(method = RequestMethod.POST, value = "/email")
    Boolean sendEmail(@RequestHeader("token") String token, @RequestBody String email);

}
