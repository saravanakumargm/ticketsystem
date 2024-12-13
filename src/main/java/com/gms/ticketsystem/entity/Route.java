package com.gms.ticketsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String routeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public List<Stop> getStopList() {
        return stopList;
    }

    public void setStopList(List<Stop> stopList) {
        this.stopList = stopList;
    }

    @ElementCollection
    @CollectionTable(name = "route_stop_list", joinColumns = @JoinColumn(name = "route_id"))
    private List<Stop> stopList = new ArrayList<>();
}
