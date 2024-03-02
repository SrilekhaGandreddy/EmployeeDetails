package com.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMP_INFO")
public class Employee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "EMP_ID")
	private Integer Id;
	@Column(name = "EMP_NAME")
	private String name;
	@Column(name = "JOIN_YEAR")
	private Integer year;
	@Column(name = "EMP_GENDER")
	private String gender;

}
