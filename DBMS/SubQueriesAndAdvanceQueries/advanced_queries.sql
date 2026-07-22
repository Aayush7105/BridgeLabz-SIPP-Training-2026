-- SubQueries & Advanced Queries SQL Script
-- Use Cases 16 to 20

-- Schema Setup & Initial Data Insertion
DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS covid_deaths;
DROP TABLE IF EXISTS country_vaccinations;

CREATE TABLE covid_cases (
    country VARCHAR(100),
    state VARCHAR(100),
    date DATE,
    confirmed_cases INT,
    deaths INT
);

CREATE TABLE covid_deaths (
    country VARCHAR(100),
    deaths INT
);

CREATE TABLE country_vaccinations (
    country VARCHAR(100),
    vaccinated_population BIGINT,
    unvaccinated_population BIGINT
);

-- Seed Data
INSERT INTO covid_cases VALUES
('USA', 'California', '2026-07-01', 1200000, 15000),
('USA', 'New York', '2026-07-01', 950000, 12000),
('India', 'Mumbai', '2026-07-01', 300000, 4000),
('India', 'Mumbai', '2026-07-02', 450000, 5500),
('India', 'Mumbai', '2026-07-03', 400000, 5000),
('Brazil', 'Sao Paulo', '2026-07-01', 1100000, 18000),
('Italy', 'Lombardy', '2026-07-01', 400000, 8000);

INSERT INTO covid_deaths VALUES
('USA', 27000),
('India', 14500),
('Brazil', 18000),
('Italy', 8000),
('Spain', 6000); -- Spain is present in covid_deaths but not in covid_cases

INSERT INTO country_vaccinations VALUES
('USA', 250000000, 80000000),
('India', 950000000, 450000000),
('Brazil', 160000000, 50000000);

-- ==========================================================
-- Use Case 16: Find Countries with Above-Average Death Counts
-- Concept: Scalar Sub-queries, Comparing Aggregates
-- ==========================================================
SELECT country, SUM(deaths) AS total_deaths
FROM covid_cases
GROUP BY country
HAVING SUM(deaths) > (
    SELECT AVG(total_country_deaths)
    FROM (
        SELECT SUM(deaths) AS total_country_deaths
        FROM covid_cases
        GROUP BY country
    ) AS global_avg
);

-- ==========================================================
-- Use Case 17: Identify Countries Exceeding Case Threshold (> 1 Million)
-- Concept: Sub-query with IN Operator, Threshold Filtering
-- ==========================================================
SELECT DISTINCT country, confirmed_cases
FROM covid_cases
WHERE country IN (
    SELECT country
    FROM covid_cases
    GROUP BY country
    HAVING MAX(confirmed_cases) > 1000000
);

-- ==========================================================
-- Use Case 18: Track COVID Waves - State-wise Analysis ('Mumbai')
-- Concept: Correlated Sub-queries, Time-series Peak Analysis
-- ==========================================================
SELECT c1.date, c1.state, c1.confirmed_cases,
       CASE 
           WHEN c1.confirmed_cases >= (
               SELECT MAX(c2.confirmed_cases)
               FROM covid_cases c2
               WHERE c2.state = c1.state
           ) THEN 'Peak Day (Wave High)'
           ELSE 'Normal Day'
       END AS wave_status
FROM covid_cases c1
WHERE c1.state = 'Mumbai'
ORDER BY c1.date;

-- ==========================================================
-- Use Case 19: Compare Vaccination Coverage
-- Concept: UNION Set Operation, Data Aggregation
-- ==========================================================
SELECT country, 'Vaccinated' AS status_type, vaccinated_population AS count
FROM country_vaccinations
UNION ALL
SELECT country, 'Unvaccinated' AS status_type, unvaccinated_population AS count
FROM country_vaccinations
ORDER BY country, status_type;

-- ==========================================================
-- Use Case 20: Find Countries Present in Deaths but Not Cases
-- Concept: NOT IN Operator, Identifying Missing Data & Inconsistencies
-- ==========================================================
SELECT DISTINCT country
FROM covid_deaths
WHERE country NOT IN (
    SELECT DISTINCT country
    FROM covid_cases
    WHERE country IS NOT NULL
);
