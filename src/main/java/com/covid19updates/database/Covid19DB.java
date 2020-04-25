package com.covid19updates.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.Ascii;

import com.covid19updates.response.CountryDetails;

public class Covid19DB {

	public Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Coronadb", "postgres", "newuser");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

	public List<CountryDetails> getAll() {
		List<CountryDetails> countries = new ArrayList<CountryDetails>();

		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from coronaupdates");

			while (rs.next()) {
				int country_id = Integer.parseInt(rs.getString(1));
				String country_name = rs.getString(2);
				int active_cases = Integer.parseInt(rs.getString(3));
				int recovered_cases = Integer.parseInt(rs.getString(4));

				CountryDetails country_details = new CountryDetails(country_id, country_name, active_cases,
						recovered_cases);
				countries.add(country_details);

				conn.close();
			}
		} catch (Exception e) {
			System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
		}

		return countries;
	}

	public List<CountryDetails> getByCountry(String name) {
		List<CountryDetails> countries = new ArrayList<CountryDetails>();

		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();
			String query = String.format("select * from coronaupdates where country_name='%s'", name.toLowerCase());
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int country_id = Integer.parseInt(rs.getString(1));
				String country_name = rs.getString(2);
				int active_cases = Integer.parseInt(rs.getString(3));
				int recovered_cases = Integer.parseInt(rs.getString(4));
				CountryDetails country_details = new CountryDetails(country_id, country_name, active_cases,
						recovered_cases);
				countries.add(country_details);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
		}

		return countries;
	}

}
