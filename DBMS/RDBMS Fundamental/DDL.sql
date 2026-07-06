CREATE DATABASE covid_db;

USE covid_db;

CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    state VARCHAR(100),
    report_date DATE,
    report_time VARCHAR(20),
    recoveries INT,
    deaths INT,
    confirmed_cases INT
);

INSERT INTO covid_cases (
    state,
    report_date,
    report_time,
    recoveries,
    deaths,
    confirmed_cases
)
VALUES (
    'India',
    '2020-03-15',
    '10 AM',
    50,
    2,
    100
);

UPDATE covid_cases
SET confirmed_cases = 120
WHERE state = 'India'
  AND report_date = '2020-03-15';

DELETE FROM covid_cases
WHERE state = 'IN';

ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);