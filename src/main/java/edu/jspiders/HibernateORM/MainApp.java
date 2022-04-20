package edu.jspiders.HibernateORM;

import java.util.Scanner;

import edu.jspiders.HibernateORM.dao.VehicleDataBaseOperations;
import edu.jspiders.HibernateORM.dto.Vehicle;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VehicleDataBaseOperations operations = new VehicleDataBaseOperations();
		while (true) {
			System.out.println("1.Insert Vehicle\n2.Search Vehicle\n3.Update Vehicle\n4.Delete Vehicle\n5.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			Vehicle searchedVehicle;
			switch (choice) {
			case 1:
//				System.out.println("Enter Chasis Number/ VIN Number");
//				String chasisNum = sc.next();

				System.out.println("Enter model");
				String model = sc.next();

				System.out.println("Enter Colour");
				String color = sc.next();

				System.out.println("Enter Price");
				double price = sc.nextDouble();

				System.out.println("Enter Year of Manufacture");
				int yom = sc.nextInt();

				System.out.println("Enter Type");
				String type = sc.next();

//				Vehicle newVehicle = new Vehicle(chasisNum, model, color, price, yom, type);
				Vehicle newVehicle = new Vehicle( model, color, price, yom, type);
				boolean isInserted = operations.insertVehicle(newVehicle);
				if (isInserted) {
					System.out.println("Inserted...!!!");
				} else {
					System.out.println("Not Inserted...!!!");
				}
				break;
			case 2:
				System.out.println("Enter Chasis Number/ VIN Number");
				String vin = sc.next();
				Vehicle vehicelData = operations.searchVehicle(vin);
				System.out.println(vehicelData);
				break;

			case 3:
				System.out.println("Enter the chassis number");
				vin = sc.next();

				searchedVehicle = operations.searchVehicle(vin);

				if (searchedVehicle != null) {
					System.out.println("Enter the new price");
					double newPrice = sc.nextDouble();

					if (operations.editVehicle(searchedVehicle, newPrice))
						System.out.println("Data edited successfully");
					else
						System.out.println("Data not Edited");
				} else
					System.out.println("Vehicle not present");
				break;
			case 4:
				System.out.println("Enter the chassis number");
				vin = sc.next();

				searchedVehicle = operations.searchVehicle(vin);

				if (searchedVehicle != null) {
					if (operations.deleteVehicle(searchedVehicle))
						System.out.println("Vehicle Deleted");
					else
						System.out.println("Vehicle not Deleted");
				} else
					System.out.println("Vehicle not present");
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Please enter a correct choice...!!!");

				break;
			}
		}
	}
}
