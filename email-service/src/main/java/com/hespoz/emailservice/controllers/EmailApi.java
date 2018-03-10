package com.hespoz.emailservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hespoz on 3/9/18.
 */
@RestController
public class EmailApi {

    @PostMapping("/email")
    public Boolean sendEmail(String email) {
        return true;
    }

}
