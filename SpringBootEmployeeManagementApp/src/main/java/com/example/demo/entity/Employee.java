package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data   //for ToString + getter + setter method
@NoArgsConstructor    //Default Constructor
@AllArgsConstructor   //Parameterized Constructor
@Entity
@Table(name="employees_info")
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String empDesg;
	private Date empDOJ;
	
	
}
