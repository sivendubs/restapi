package com.covid19updates.response;

public class CountryDetails {
	private int country_id;
	private String country_name;
	private int active_cases;
	private int recovered_cases;
	public CountryDetails(int country_id, String country_name, int active_cases, int recovered_cases) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.active_cases = active_cases;
		this.recovered_cases = recovered_cases;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public int getActive_cases() {
		return active_cases;
	}
	public void setActive_cases(int active_cases) {
		this.active_cases = active_cases;
	}
	public int getRecovered_cases() {
		return recovered_cases;
	}
	public void setRecovered_cases(int recovered_cases) {
		this.recovered_cases = recovered_cases;
	}
	

}
