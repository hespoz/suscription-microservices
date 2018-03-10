package com.hespoz.suscriptionservice.fallbacks;

import com.hespoz.suscriptionservice.services.EventService;
import org.springframework.stereotype.Component;

/**
 * Created by hespoz on 3/10/18.
 */

@Component
public class EventServiceFallback implements EventService {

    @Override
    public Boolean sendEventToSQS(Long suscriptionId) {
        return false;
    }

}
