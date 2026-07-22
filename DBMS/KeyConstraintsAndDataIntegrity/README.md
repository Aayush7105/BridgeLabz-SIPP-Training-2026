# Session 2: Keys, Constraints & Data Integrity

This directory contains the SQL implementation for **COVID Tracking Data Integrity & Constraints** under `DBMS/KeyCOnstraintsAndDataintegrity`.

---

## 📌 Implementation Summary

### **Use Case 1: Composite Primary Key**
- **Objective:** Ensure unique COVID records per country for each reporting date.
- **Task:** Created composite primary key `PRIMARY KEY (Country, Date)` on `covid_cases`.

### **Use Case 2: Foreign Key Relationships**
- **Objective:** Establish referential integrity between `covid_cases` and reference table `countries`.
- **Task:** Created `countries` lookup table with primary key `country_code` and defined foreign key `CONSTRAINT fk_covid_country FOREIGN KEY (Country) REFERENCES countries(country_code)`.

### **Use Case 3: Data Quality Constraints**
- **Objective:** Ensure data accuracy and valid business logic.
- **Task:** 
  - Applied `NOT NULL` constraints on `Country`, `Date`, and `Confirmed_Cases`.
  - Added `CHECK (Deaths <= Confirmed_Cases)` to enforce that recorded deaths never exceed total confirmed cases.

### **Use Case 4: Default Values**
- **Objective:** Automatically assign defaults during data entry.
- **Task:** 
  - `Recoveries INT NOT NULL DEFAULT 0`
  - `Last_Updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP`

### **Use Case 5: Unique Country-Date Entries**
- **Objective:** Enforce explicit uniqueness on `(Country, Date)`.
- **Task:** Created `CONSTRAINT uq_country_date UNIQUE (Country, Date)` preventing duplicate reporting for the same country on the same day.

---

## 📁 File Reference
- SQL File: [covid_constraints.sql](file:///d:/BridgeLabz-SIPP-Training-2026/DBMS/KeyCOnstraintsAndDataintegrity/covid_constraints.sql)
