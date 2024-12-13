package com.gms.ticketsystem.controller;

import com.gms.ticketsystem.entity.Route;
import com.gms.ticketsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;
    @PostMapping("/add")
    public Route addRoute(@RequestBody Route route){
        System.out.println(route.getRouteName() + " " + route.getId() + " " + route.getStopList());
        return routeService.addRoute(route);
    }
    @PostMapping("/delete")
    public Route deleteRoute(@RequestParam Long id){
        return routeService.deleteRoute(id);
    }

    @PostMapping("/update")
    public Route updateRoute(@RequestParam Long id, @RequestBody Route route){
        return routeService.updateRoute(id,route);
    }

    @GetMapping("/find-all")
    public List<Route> getAllRoutes(){
        return routeService.getAllRoutes();
    }
}
