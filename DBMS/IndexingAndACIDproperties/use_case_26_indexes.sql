-- Use Case 26: indexes for country- and date-based filtering
-- MySQL 8.0+

-- Supports predicates such as:
-- WHERE country = 'India' AND case_date BETWEEN '2026-01-01' AND '2026-01-31'
CREATE INDEX idx_covid_cases_country_date
    ON covid_cases (country, case_date);

-- Supports date-only predicates such as:
-- WHERE case_date = '2026-01-01'
CREATE INDEX idx_covid_cases_date
    ON covid_cases (case_date);
