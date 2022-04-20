package edu.jspiders.HibernateORM.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity //to make class as Entity class
@Table(name = "vehicle") // used to map the DB table
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	===================== Configurations to map with the table ============================-
	
	//@GenericGenerator(name ="myGen", strategy = "increment") /// work only on the Integer primary keys
	@GenericGenerator(name ="myGen", strategy = "edu.jspiders.HibernateORM.dao.MyOwnGenerator") // we can have our own logic for generating
	
	@GeneratedValue (generator = "myGen")
	
	@Id // to specify the primary key
	@Column(name = "VIN") //mapping to each column with the same name as in the DB Table
	private String VIN;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "YOM")
	private Integer YOM;
	
	@Column(name = "type")
	private String type;

	public Vehicle() {
	}

	public Vehicle(String vIN, String model, String color, Double price, Integer yOM, String type) {
		super();
		this.VIN = vIN;
		this.model = model;
		this.color = color;
		this.price = price;
		this.YOM = yOM;
		this.type = type;
	}
	public Vehicle( String model, String color, Double price, Integer yOM, String type) {
		super();
		this.model = model;
		this.color = color;
		this.price = price;
		this.YOM = yOM;
		this.type = type;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getYOM() {
		return YOM;
	}

	public void setYOM(Integer yOM) {
		YOM = yOM;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [VIN=" + VIN + ", model=" + model + ", color=" + color + ", price=" + price + ", YOM=" + YOM
				+ ", type=" + type + "]";
	}

}
