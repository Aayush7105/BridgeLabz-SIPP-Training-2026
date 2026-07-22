-- Use Case 27: covering index for the top 10 countries by infection rate
-- MySQL can satisfy the projection and ORDER BY from this index alone.

CREATE INDEX idx_covid_cases_infection_rate_country
    ON covid_cases (infection_rate DESC, country);

-- Example query
SELECT country, infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10;
