SELECT d.country_id, d.death_count, v.vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.country_id = v.country_id;
