package com.gms.ticketsystem.controller;

import com.gms.ticketsystem.entity.Stop;
import com.gms.ticketsystem.service.UserService;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/issue/{routeId}/{stopNo}/{noOfTicket}")
    public String issueTicket(@PathVariable Long routeId, @PathVariable Long stopNo, @PathVariable Long noOfTicket){
        return userService.issueTicket(routeId,stopNo,noOfTicket);
    }
    @PostMapping("/deboard/{routeId}/{stopNo}")
    public void passengerDeboarded(@PathVariable Long routeId,@PathVariable Long stopNo){
        userService.passengerDeboarded(routeId,stopNo   );
    }
    @GetMapping("/get-all/{routeId}")
    public List<Stop> getAllStopsWithPassengers(@PathVariable Long routeId){
        return userService.getAllStopsWithPassengers(routeId);
    }

    @GetMapping("/passenger-no/{routeId}/{stopNo}")
    public Long passengersInStop(@PathVariable Long routeId,@PathVariable Long stopNo){
        return userService.passengersInStop(routeId,stopNo);
    }
    @GetMapping("/stop/{routeId}/{stopNo}")
    public String getCurrentStop(@PathVariable Long routeId, @PathVariable Long stopNo){
        return userService.getCurrentStop(routeId,stopNo);
    }
}
