package com.gms.ticketsystem.service;

import com.gms.ticketsystem.entity.Route;
import com.gms.ticketsystem.entity.Stop;
import com.gms.ticketsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.RoundEnvironment;
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

    public void passengerDeboarded(Long routeId,Long stopNo) {
        Route route = routeRepository.findById(routeId).get();
        List<Stop> stops = route.getStopList();
        Stop s = stops.get(Integer.parseInt(String.valueOf(stopNo-1)));
        s.setNoOfPassengers(0L);
        stops.set(Integer.parseInt(String.valueOf(stopNo-1)),s);
        routeRepository.save(route);
    }

    public List<Stop> getAllStopsWithPassengers(Long routeId) {
        Route route = routeRepository.findById(routeId).get();
        return route.getStopList();
    }

    public Long passengersInStop(Long routeId,Long stopNo) {
        Route route = routeRepository.findById(routeId).get();
        return route.getStopList().get(Integer.parseInt(String.valueOf(stopNo-1))).getNoOfPassengers();
    }

    public String getCurrentStop(Long routeId, Long stopNo) {
        Route route = routeRepository.findById(routeId).get();
        return route.getStopList().get(Integer.parseInt(String.valueOf(stopNo-1))).getStopName();
    }
}
