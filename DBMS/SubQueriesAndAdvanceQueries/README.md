# SubQueries & Advanced Queries

This directory contains the SQL implementations for **Subqueries and Advanced Data Analytics** under `DBMS/SubQuerieAndAdvanceQueries`.

---

## 📌 Implementation Summary

### **Use Case 16: Find Countries with Above-Average Death Counts**
- **Objective:** Identify countries whose total death count exceeds the global average across all countries.
- **Concepts:** Scalar sub-queries, aggregate sub-queries in `HAVING` clause.

### **Use Case 17: Identify Countries Exceeding Case Threshold (> 1 Million)**
- **Objective:** Retrieve records for countries where maximum confirmed cases exceed 1,000,000 using an `IN` sub-query filter.
- **Concepts:** Sub-queries with `IN` operator, threshold filtering.

### **Use Case 18: Track COVID Waves - State-wise Analysis ('Mumbai')**
- **Objective:** Evaluate if a specific day represents a peak in confirmed cases for a state like `'Mumbai'` using a correlated subquery comparing daily cases to the maximum cases for that state.
- **Concepts:** Correlated sub-queries, conditional `CASE` statements, time-series peak detection.

### **Use Case 19: Compare Vaccination Coverage**
- **Objective:** Perform unified coverage analysis combining vaccinated and unvaccinated counts.
- **Concepts:** `UNION ALL` set operations, combining result sets into a standardized schema.

### **Use Case 20: Find Countries Present in Deaths but Not Cases**
- **Objective:** Identify data inconsistencies where countries exist in `covid_deaths` table but are missing from `covid_cases`.
- **Concepts:** `NOT IN` operator, identifying data gaps and referential anomalies.

---

## 📁 File Reference
- SQL File: [advanced_queries.sql](file:///d:/BridgeLabz-SIPP-Training-2026/DBMS/SubQuerieAndAdvanceQueries/advanced_queries.sql)
