-- KeyConstraintsAndDataIntegrity SQL Script
-- Covers Use Cases 1 to 5 for COVID Tracking Database

-- Drop tables if they exist for clean initialization
DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;

-- Use Case 2: Create Reference Table 'countries'
CREATE TABLE countries (
    country_code VARCHAR(10) PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL UNIQUE,
    continent VARCHAR(50)
);

-- Use Cases 1, 2, 3, 4, & 5: Create 'covid_cases' Table with All Constraints
CREATE TABLE covid_cases (
    Country VARCHAR(10) NOT NULL,
    Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL CHECK (Confirmed_Cases >= 0),
    Deaths INT NOT NULL DEFAULT 0 CHECK (Deaths >= 0),
    Recoveries INT NOT NULL DEFAULT 0 CHECK (Recoveries >= 0), -- Use Case 4: Default 0 for Recoveries
    Last_Updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Use Case 4: Default CURRENT_TIMESTAMP
    
    -- Use Case 1: Composite Primary Key on (Country, Date)
    PRIMARY KEY (Country, Date),

    -- Use Case 2: Foreign Key relationship referencing countries table
    CONSTRAINT fk_covid_country FOREIGN KEY (Country) 
        REFERENCES countries(country_code) 
        ON DELETE CASCADE ON UPDATE CASCADE,

    -- Use Case 3: CHECK constraint ensuring deaths do not exceed confirmed cases
    CONSTRAINT chk_deaths_cases CHECK (Deaths <= Confirmed_Cases),

    -- Use Case 5: UNIQUE constraint on (Country, Date)
    -- Note: Since (Country, Date) is already the Primary Key, entity uniqueness is implicitly guaranteed.
    -- Explicit UNIQUE constraint added below to satisfy explicit business constraint requirements:
    CONSTRAINT uq_country_date UNIQUE (Country, Date)
);

-- Initial Seed Data for Verification
INSERT INTO countries (country_code, country_name, continent) VALUES
('USA', 'United States of America', 'North America'),
('IND', 'India', 'Asia'),
('BRA', 'Brazil', 'South America');

-- Valid Insert
INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths, Recoveries) 
VALUES ('USA', '2026-07-01', 1000, 50, 800);

-- Insert demonstrating DEFAULT values (Recoveries = 0, Last_Updated = CURRENT_TIMESTAMP)
INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths) 
VALUES ('IND', '2026-07-01', 500, 10);

-- Demonstration Queries
SELECT * FROM countries;
SELECT * FROM covid_cases;
