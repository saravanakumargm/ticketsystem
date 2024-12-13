package com.gms.ticketsystem.service;

import com.gms.ticketsystem.entity.Route;
import com.gms.ticketsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    public Route addRoute(Route route) {
        routeRepository.save(route);
        return route;
    }

    public Route deleteRoute(Long id) {
        Route route = routeRepository.findById(id).get();
        routeRepository.delete(route);
        return route;
    }

    public Route updateRoute(Long id, Route route) {
        Route oldRoute = routeRepository.findById(id).get();
        oldRoute.setRouteName(route.getRouteName());
        oldRoute.setStopList(route.getStopList());
        return routeRepository.save(oldRoute);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
