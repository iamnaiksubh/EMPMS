package com.dnb.empms.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	public Long id;
	public String name;
	public String dept;
	public int salary;
}
