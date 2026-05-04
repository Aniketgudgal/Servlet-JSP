package com.MVCProject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	private int age;
}
