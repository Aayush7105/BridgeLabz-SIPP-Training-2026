-- Use Case 28: inspect a complex join and add the required join indexes.
-- Adjust table/column names to match the existing schema if necessary.

-- Foreign-key/join columns should be indexed on the referencing tables.
CREATE INDEX idx_vaccine_distribution_country_date
    ON vaccine_distribution (country, distribution_date);

-- Analyze the plan before and after adding indexes. Look for:
-- * type = ALL: a full table scan (often a missing/selectivity-poor index)
-- * possible_keys = NULL: no usable index
-- * Using filesort / Using temporary: sorting or temporary-table overhead
EXPLAIN ANALYZE
SELECT
    c.country,
    c.case_date,
    c.infection_rate,
    v.doses_distributed
FROM covid_cases AS c
JOIN vaccine_distribution AS v
    ON v.country = c.country
   AND v.distribution_date = c.case_date
WHERE c.country = 'India'
  AND c.case_date BETWEEN '2026-01-01' AND '2026-01-31'
ORDER BY c.case_date;

-- Expected useful indexes for the query:
-- covid_cases(country, case_date)                 -- Use Case 26
-- vaccine_distribution(country, distribution_date) -- created above
