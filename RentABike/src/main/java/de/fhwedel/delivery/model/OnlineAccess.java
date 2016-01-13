
package de.fhwedel.delivery.model;

import javax.persistence.*;

@Entity
@Table(name = "OnlineAccess")
public class OnlineAccess {
    @Id
    String username;
    char[] Password;
    
    @OneToOne
      Customer user;  
}
