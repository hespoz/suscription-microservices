package com.hespoz.suscriptionservice.controllers.mappers;

import com.hespoz.suscriptionservice.dto.SuscriptionDTO;
import com.hespoz.suscriptionservice.entities.Suscription;

/**
 * Created by hespoz on 3/10/18.
 */
public class SuscriptionMapper {

    public static Suscription toSuscription(SuscriptionDTO suscriptionDTO){
        return new Suscription(suscriptionDTO.getFirstName(), suscriptionDTO.getGender(), suscriptionDTO.getEmail(), suscriptionDTO.getDateOfBirth(), suscriptionDTO.getFlag());
    }

}
