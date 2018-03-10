package com.hespoz.suscriptionservice.controllers;

import com.hespoz.suscriptionservice.controllers.mappers.SuscriptionMapper;
import com.hespoz.suscriptionservice.dto.SuscriptionDTO;
import com.hespoz.suscriptionservice.entities.Suscription;
import com.hespoz.suscriptionservice.enums.Gender;
import com.hespoz.suscriptionservice.services.EmailService;
import com.hespoz.suscriptionservice.services.EventService;
import com.hespoz.suscriptionservice.services.SuscriptionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by hespoz on 3/9/18.
 */

@RestController
public class SuscriptionApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SuscriptionApi.class);

    private final EventService eventService;
    private final EmailService emailService;
    private final SuscriptionService suscriptionService;

    public SuscriptionApi(EventService eventService, EmailService emailService, SuscriptionService suscriptionService) {
        this.eventService = eventService;
        this.emailService = emailService;
        this.suscriptionService = suscriptionService;
    }


    @PostMapping("/suscribe")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "*")
    public Long suscribe(@Valid @RequestBody SuscriptionDTO suscriptionDTO) {

        Suscription res = suscriptionService.create(SuscriptionMapper.toSuscription(suscriptionDTO));

        //Report suscription event to SQS with the suscription id (Mock)
        Boolean eventSended = eventService.sendEventToSQS(res.getId());
        Boolean emailSended = emailService.sendEmail(res.getEmail());

        if (!eventSended) {
            /*
            * If event service is down, we continue the execution flow and  save the event locally in our database,
            * the idea is to have other service that will read the lost events and call event-service when this is up again.
            * WE CAN´T LOOSE SUSCRIBERS!!!
            * For simplicity I will just log.
            */
            LOGGER.error("Event service is down");
            LOGGER.info("Saving event information in the table PENDING_EVENTS");
        }

        if (!emailSended) {
            //The same thing for the email service. In this case email will take some time to arrive.
            LOGGER.error("Email service is down");
            LOGGER.info("Saving email event in the table PENDING_EMAILS");
        }

        //Send confirmation email to the user.
        emailService.sendEmail(res.getEmail());

        return res.getId();
    }


    @ExceptionHandler({ConstraintViolationException.class, DataIntegrityViolationException.class})
    public String emailConstrainViolation() {
        //We will send a code that will be processed in the frontend. This can be internatilized.
        return "ALREADY_REGISTERED";
    }

}
