package com.hespoz.emailservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hespoz on 3/9/18.
 */
@RestController
public class EmailApi {

    private final String tokenSession = "3lGknM49r2";

    @PostMapping("/email")
    @ResponseStatus(HttpStatus.OK)
    public Boolean sendEmail(@RequestHeader("token") String token, @RequestBody String email) throws Exception {
        //Check token against other service. For the example sake I am hardcoding it.
        if(!token.equals(tokenSession)){
            throw new Exception("The token is invalid, you can not access to this service");
        }

        return true;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<Object> handleControllerException(HttpServletRequest req, Throwable ex) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
