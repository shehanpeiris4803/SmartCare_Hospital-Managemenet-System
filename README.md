## SmartCare Hospital Management System

A full-stack hospital management solution built around a relational MySQL database, 
with a Spring Boot + Java REST API layered on top using Object Oriented design principles.

## Overview
SmartCare Hospital Management System digitizes core hospital operations — patient records, 
doctor and department management, appointment scheduling, ward admissions, treatments, 
laboratory tests, and billing/payments — replacing manual, spreadsheet-based record keeping.

## Features
- Patient, doctor, and department management with role-based user accounts
- Appointment booking with clash prevention
- Admission and room/ward allocation tracking
- Treatment and medical history records
- Laboratory test tracking (request → result → status)
- Automated billing and multi-method payment handling
- REST API built with Spring Boot, Spring Data JPA/Hibernate, and MySQL

## Tech Stack
- **Database:** - MySQL
- **Backend:**  - Java, Spring Boot, Spring Data JPA
- **Build Tool:** -  Maven
- **API Testing:**  - Postman
- **Architecture:**  - Layered (Entity → Repository → Service → Controller)

## Project Structure
- `/database` — MySQL schema, sample data, ER diagram
- `/docs` — UML class diagram, ER diagram (draw.io), technical report
- `/src` — Spring Boot application source code
