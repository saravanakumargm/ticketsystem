package com.gms.ticketsystem.controller;

import com.gms.ticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/issue/{routeId}/stopNo/{noOfTicket}")
    public String issueTicket(@PathVariable Long routeId, @RequestParam Long stopNo, @PathVariable Long noOfTicket){
        return userService.issueTicket(routeId,stopNo,noOfTicket);
    }
    @PostMapping("/deboard/{routeId}/{stopName}")
    public void passengerDeboarded(@PathVariable Long routeId,@PathVariable String stopName){
        userService.passengerDeboarded(routeId,stopName);
    }

}
