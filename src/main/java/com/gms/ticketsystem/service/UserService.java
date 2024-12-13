package com.gms.ticketsystem.service;

import com.gms.ticketsystem.entity.Route;
import com.gms.ticketsystem.entity.Stop;
import com.gms.ticketsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private RouteRepository routeRepository;

    public String issueTicket(Long routeId, Long stopNo, Long noOfTicket) {
        Route route = routeRepository.findById(routeId).get();
        List<Stop> stops = route.getStopList();
        for(Stop s : stops){
            if(s.getStopNo() == stopNo){
                s.setNoOfPassengers(s.getNoOfPassengers() + noOfTicket);
                routeRepository.save(route);
                return "Added";
            }
        }
        return "Error!";
    }

    public void passengerDeboarded(Long routeId,String stopName) {
        Route route = routeRepository.findById(routeId).get();
        List<Stop> stops = route.getStopList();
        for(Stop s : stops){
            if(Objects.equals(s.getStopName(), stopName)){
                s.setNoOfPassengers(0L);
            }
        }
    }
}
