package com.hespoz.suscriptionservice.services.impl;

import com.hespoz.suscriptionservice.entities.Suscription;
import com.hespoz.suscriptionservice.repositories.SuscriptionRepository;
import com.hespoz.suscriptionservice.services.SuscriptionService;
import org.springframework.stereotype.Service;

/**
 * Created by hespoz on 3/9/18.
 */
@Service
public class SuscriptionServiceImpl implements SuscriptionService {

    private final SuscriptionRepository suscriptionRepository;

    public SuscriptionServiceImpl(SuscriptionRepository suscriptionRepository) {
        this.suscriptionRepository = suscriptionRepository;
    }

    @Override
    public Suscription create(Suscription suscription) {
        return suscriptionRepository.save(suscription);
    }

}
