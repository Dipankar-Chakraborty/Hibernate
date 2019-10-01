package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Dipankar Chakraborty
 * @creation_date 27 Sep 2019 11:50 AM
 * @modification_date 27 Sep 2019 02:21 PM
 * @version 2.0
 * @copyright Zensar Technologies. All rights reserved.
 * @description persistant class
 */
@Entity
@Table(name = "wageemp_1")
public class WageEmp extends Employee {
	private int hours;
	private float rate;

	public WageEmp() {
		// TODO Auto-generated constructor stub
	}

	public WageEmp(int empId, String name, LocalDate joinDate, double salary, int hours, float rate) {
		super(empId, name, joinDate, salary);
		this.hours = hours;
		this.rate = rate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "WageEmp [hours=" + hours + ", rate=" + rate + "]";
	}
}
