
package de.fhwedel.delivery.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Defects")
public class Defect implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
  int id; 
 
@Column(name="Description")    
 String Description;  

@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id")
 Employee assighnedEngeneer;

@Column(name="State")
 Condition DefectState; 

@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESS_ID")
 Order likedOrder ;  
 
}
enum Condition
{
CosmeticDefects,
SmallIssues,
BigDamage,
CompleteDamege
}