package com.misson.mission3;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{:id}")
    public void throwException(@PathVariable int id){
       switch (id) {
           default:
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    @ExceptionHandler()
    public void handleException() {
        
    }
}
