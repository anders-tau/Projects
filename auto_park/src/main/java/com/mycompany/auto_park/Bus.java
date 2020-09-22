/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.auto_park;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Anders
 */
public class Bus {
    private Long id;
    private String number;
    private Set drivers = new HashSet();
    private Long route_id;

    public Bus() {
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setDrivers(Set drivers) {
        this.drivers = drivers;
    }
    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }
    public Long getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public Set getDrivers() {
        return drivers;
    }
    public Long getRoute_id() {
        return route_id;
    }    
}
