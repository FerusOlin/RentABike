/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhwedel.delivery.model;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Item implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.TABLE)
    int ItemID;
    
   
    double Price;
            

}
