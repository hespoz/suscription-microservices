package com.hespoz.suscriptionservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hespoz on 3/9/18.
 */

@FeignClient(name="event-service", fallback = com.hespoz.suscriptionservice.fallbacks.EventServiceFallback.class)
public interface EventService {

    @RequestMapping(method = RequestMethod.POST, value = "/event")
    Boolean sendEventToSQS(@RequestHeader("token") String token, @RequestBody Long suscriptionId);

}
