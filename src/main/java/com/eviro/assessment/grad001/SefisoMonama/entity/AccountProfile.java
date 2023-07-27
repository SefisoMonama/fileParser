package com.eviro.assessment.grad001.SefisoMonama.entity;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="account_profile")
public class AccountProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "surname")
	private String surname;
	@CsvBindByName(column = "imageFormat")
	private String imageFormat;
	@CsvBindByName(column = "imageData")
	private String imageData;
}
