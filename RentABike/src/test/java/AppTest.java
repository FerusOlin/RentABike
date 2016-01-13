/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karolina
 */

import de.fhwedel.delivery.model.Address;
//import de.fhwedel.delivery.model.Bla;
//import forms.Shtest;

import de.fhwedel.delivery.model.Customer;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;

//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//import form.Index;
//import form.Test;
//import form.shtest;

/**
 * Hello world!
 * 
 */
public class AppTest {
	private static SessionFactory sessionFactory = null;  
	private static ServiceRegistry serviceRegistry = null;  
	  
	private static SessionFactory configureSessionFactory() throws HibernateException {  
	    Configuration configuration = new Configuration();  
	    configuration.configure();  
	    
	    Properties properties = configuration.getProperties();
	    
		serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	    
	    return sessionFactory;  
	}
	
	public static void main(String[] args) {
		// Configure the session factory
		configureSessionFactory();
		
		Session session = null;
		Transaction tx=null;
		
		try {

                     //   Shtest fenster;
                      //  fenster = new Shtest();
                      //  fenster.pack();
                      //  fenster.setVisible(true);
                        
			//Display display = new Display ();
			//shtest shell = new shtest(display);
//			shell.pack();
//			shell.open ();
//			while (!shell.isDisposed ()) {
//				if (!display.readAndDispatch ()) display.sleep ();
//			}
//			
//			display.dispose ();
			
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
                        
                        
			// Creating Contact entity that will be save to the sqlite database
                        Address address = new Address();
			
			// Saving to the database
			session.saveOrUpdate(address);
			
			// Committing the change in the database.
			session.flush();
			tx.commit();
			
			// Fetching saved data
			List<Address> addressList = session.createQuery("from Address").list();
			
			for (Address add : addressList) {
				System.out.println("Id: " + add.getId() );//+ " | Name:"  + user.getName() + " | Email:" + user.getEmail());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
			// Rolling back the changes to make the data consistent in case of any failure 
			// in between multiple database write operations.
			tx.rollback();
		} finally{
			if(session != null) {
				session.close();
			}
		}
	}
}
