
package de.fhwedel.delivery.model;


import javax.persistence.*;

@Entity
@Table(name = "Trailer")
public class Trailer extends Accessoires {
    
   @Column(name="type")
    trailerUse type;
   
   @Column(name="rainproof")
    Boolean rainproof;
}
enum trailerUse
{
    GoodsTailer,
    ChildrenTailor,
    BikeConnector
}