SELECT ct.continent_name, SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN continents ct
ON cc.continent_id = ct.continent_id
GROUP BY ct.continent_name;
