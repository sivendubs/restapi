##### Installation Steps
1. Download Java Development Kit jdk version 12.0.1
2. Download Spring Tool Suite 4 for development environment
3. Download POSTMAN to test REST API
3. Download Postgres to setup Database
4. Create Database - Coronadb 
	1. Create coronaupdtaes table 
		> create table coronaupdates (country_id serial primary key,country_name text,active_cases int,recovered_cases int);
	2. Insert data into table
		> insert into coronaupdates(country_name,active_cases,recovered_cases) values('USA',700000,80000);
	
5. Download JDBC Driver to retrive details from Postgres Database with java code
	
##### RESTAPIs
1. To retrieve all records from Postgres Database
  	> url:http://localhost:8080/countries/
  	output
  	[
	    {
	        "country_id": 1,
	        "country_name": "usa",
	        "active_cases": 700000,
	        "recovered_cases": 80000
	    },
	    {
	        "country_id": 2,
	        "country_name": "spain",
	        "active_cases": 150000,
	        "recovered_cases": 85000
	    }
    ]	
    
2. To retrieve a single record from table  
	> url :http://localhost:8080/countries/usa
	output
	[
	    {
	        "country_id": 1,
	        "country_name": "usa",
	        "active_cases": 700000,
	        "recovered_cases": 80000
	    }
	]  
	
##### To retrieve data without RESTAPI
1. go to Task3 folder	
2. Copy JDBC driver to same folder
3. To run java program execute the below commands
	> javac Covid19.java
	> java -cp "/Users/vishnuprasad/desktop/java program/postgresql-42.2.12.jar" Covid19.java
	
4. Output
	Connected to database successfully
	Latest Covid19 Updates

	Country Id Country Name Active Cases Recovered Cases
	1,usa,700000,80000
	2,spain,150000,85000
	3,italy,100000,50000
	4,france,96000,47000
	5,germany,49600,91500
	6,china,77081,1030
	7,india,14220,2500
	8,australia,2220,4258
	9,singapore,7540,740
	10,iran,20050,60200	
