/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhwedel.delivery.model;

import javax.persistence.*;


public class InStore extends RentingOrder{
    @ManyToOne
    Employee assistendEmployee;
}
