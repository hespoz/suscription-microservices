package com.hespoz.suscriptionservice.fallbacks;

import com.hespoz.suscriptionservice.services.EmailService;
import org.springframework.stereotype.Component;

/**
 * Created by hespoz on 3/10/18.
 */
@Component
public class EmailServiceFallback implements EmailService {

    @Override
    public Boolean sendEmail(String email) {
        return false;
    }

}
