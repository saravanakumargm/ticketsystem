package com.gms.ticketsystem.service;

import com.gms.ticketsystem.entity.Route;
import com.gms.ticketsystem.entity.Stop;
import com.gms.ticketsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StopService {
    @Autowired
    private RouteRepository routeRepository;
    public Stop addStop(long routeId, Stop stop) {
        Route route = routeRepository.findById(routeId).get();
        List<Stop> stops = route.getStopList();
        stops.add(stop);
        routeRepository.save(route);
        return stop;
    }

    public String deleteStop(long routeId, String routeName) {
        Route route = routeRepository.findById(routeId).get();
        List<Stop> stops = route.getStopList();
        for(Stop s : stops){
            if(Objects.equals(s.getStopName(), routeName)){
                stops.remove(s);
                routeRepository.save(route);
                return "deleted";
            }
        }
        return "Not Found";
    }

    public String updateStop(Long routeId, String oldStopName, String newStopName) {
        Route route = routeRepository.findById(routeId).get();
        List<Stop> stops = route.getStopList();

        for(Stop s : stops){
            if(Objects.equals(s.getStopName(), oldStopName)){
                s.setStopName(newStopName);
                routeRepository.save(route);
                return "Updated";
            }
        }
        return "Not Found";

    }
}
