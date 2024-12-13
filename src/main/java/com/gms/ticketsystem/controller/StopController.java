package com.gms.ticketsystem.controller;

import com.gms.ticketsystem.entity.Stop;
import com.gms.ticketsystem.service.StopService;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stops")
public class StopController {
    @Autowired
    private StopService stopService;
    @PostMapping("/add/{routeId}")
    public Stop addStop(@PathVariable long routeId, @RequestBody Stop stop){
        return stopService.addStop(routeId,stop);
    }
    @PostMapping("/delete/{routeId}/{stopName}")
    public String deleteStop(@PathVariable long routeId, @PathVariable String stopName){
        return stopService.deleteStop(routeId,stopName);
    }

    @PostMapping("update/{routeId}/{oldStopName}/{newStopName}")
    public String updateStop(@PathVariable Long routeId, @PathVariable String oldStopName, @PathVariable String newStopName){

        return stopService.updateStop(routeId,oldStopName,newStopName);
    }

}
