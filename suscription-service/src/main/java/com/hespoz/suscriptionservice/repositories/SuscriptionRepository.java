package com.hespoz.suscriptionservice.repositories;

import com.hespoz.suscriptionservice.entities.Suscription;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hespoz on 3/9/18.
 */
public interface SuscriptionRepository extends CrudRepository<Suscription, Long> {

}
