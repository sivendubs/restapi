package com.covid19updates.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@RestController
@RequestMapping("users") //http://localhost:8080/users	
public class CovidController {
	
		@GetMapping
		public String getUser()
		{ 
			try {
	            Connection conn = null;
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection(
	                "jdbc:postgresql://127.0.0.1:5432/Coronadb", "postgres", "newuser");
	            System.out.println("Connected");
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("Select * from coronaupdates");
	            
	            while(rs.next()){
	                System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
	        }
			return "connected";
		}

}