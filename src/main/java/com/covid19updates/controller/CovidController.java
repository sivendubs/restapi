package com.covid19updates.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid19updates.database.Covid19DB;
import com.covid19updates.response.CountryDetails;

import java.util.List;

@RestController
@RequestMapping("countries") // http://localhost:8080/countries
public class CovidController {

	@GetMapping
	public List<CountryDetails> getAll() {
		Covid19DB db = new Covid19DB();
		return db.getAll();
	}
	
	@GetMapping(path="/{country_name}")
	public List<CountryDetails> getCountryDetails(@PathVariable String country_name) {
		Covid19DB db = new Covid19DB();
		return db.getByCountry(country_name);
	}

}