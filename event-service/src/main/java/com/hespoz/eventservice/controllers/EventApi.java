package com.hespoz.eventservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hespoz on 3/9/18.
 */

@RestController
public class EventApi {

    @PostMapping("/event")
    public Boolean sendEventToSQS(Long suscriptionId) {
        return true;
    }

}
