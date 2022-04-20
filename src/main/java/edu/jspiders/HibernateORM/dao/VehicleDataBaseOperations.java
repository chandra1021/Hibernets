package edu.jspiders.HibernateORM.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.jspiders.HibernateORM.dto.Vehicle;

public class VehicleDataBaseOperations {

	static Configuration config = new Configuration();
	static SessionFactory factory;
	static Session session;
	static {
		config = new Configuration();
		config.configure();
		config.addAnnotatedClass(Vehicle.class);
		factory = config.buildSessionFactory();
//		session = factory.openSession();
	}
	
	public boolean insertVehicle(Vehicle newVehicle) {
		// specify the Configurations
		Configuration config = new Configuration();
		config.configure();

		// specify the Configurations
//		config.addAnnotatedClass(Vehicle.class);

		// specify the SessionFactory
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		// specify the Transaction object
		Transaction tx = session.beginTransaction();

		// to save into DB
		session.save(newVehicle);

		try {
			// to commit into DB
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Vehicle searchVehicle(String VIN) {
		Configuration config = new Configuration();
		config.configure();
//		config.addAnnotatedClass(Vehicle.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Vehicle vin = session.get(Vehicle.class, VIN);
		return vin;
	}

	public boolean editVehicle(Vehicle editVehicle, double newPrice) {
		editVehicle.setPrice(newPrice);
		Configuration config = new Configuration();
		config.configure();
//		config.addAnnotatedClass(Vehicle.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.update(editVehicle);

		Transaction tx = session.beginTransaction();

		try {
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteVehicle(Vehicle searchedVehicle) {

		Configuration config = new Configuration();
		config.configure();
//		config.addAnnotatedClass(Vehicle.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.delete(searchedVehicle);

		Transaction tx = session.beginTransaction();

		try {
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
