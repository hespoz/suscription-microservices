package com.hespoz.suscriptionservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by hespoz on 3/9/18.
 */

@FeignClient(name="event-service", fallback = com.hespoz.suscriptionservice.fallbacks.EventServiceFallback.class)
public interface EventService {

    @PostMapping("/event")
    Boolean sendEventToSQS(Long suscriptionId);

}
