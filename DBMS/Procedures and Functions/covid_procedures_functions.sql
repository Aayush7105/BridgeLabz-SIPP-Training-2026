-- Use Cases 21-25: COVID reporting objects
-- Assumes covid_cases(country, date, confirmed, deaths, recovered).

-- Use Case 21: latest reported statistics for every country.
CREATE OR REPLACE VIEW vw_latest_covid_data AS
SELECT c.country,
       c.date AS report_date,
       c.confirmed,
       c.deaths,
       c.recovered
FROM covid_cases AS c
INNER JOIN (
    SELECT country, MAX(date) AS latest_date
    FROM covid_cases
    GROUP BY country
) AS latest
    ON latest.country = c.country
   AND latest.latest_date = c.date;

DELIMITER $$

-- Use Case 22: mortality percentage for one country's report date.
CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(10,2)
READS SQL DATA
BEGIN
    DECLARE v_rate DECIMAL(10,2);

    SELECT COALESCE(MAX(deaths / NULLIF(confirmed, 0) * 100), 0)
      INTO v_rate
      FROM covid_cases
     WHERE country = p_country
       AND date = p_date;

    RETURN v_rate;
END$$

-- Use Case 23: update all related statistics as one atomic operation.
CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed INT,
    IN p_deaths INT,
    IN p_recovered INT
)
BEGIN
    START TRANSACTION;

    UPDATE covid_cases
       SET confirmed = p_confirmed,
           deaths = p_deaths,
           recovered = p_recovered
     WHERE country = p_country
       AND date = p_date;

    IF ROW_COUNT() = 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No COVID record exists for the supplied country and date';
    ELSE
        COMMIT;
    END IF;
END$$

-- Use Case 24: latest recovery percentage for a country.
CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100)
)
RETURNS DECIMAL(10,2)
READS SQL DATA
BEGIN
    DECLARE v_rate DECIMAL(10,2);

    SELECT COALESCE(MAX(recovered / NULLIF(confirmed, 0) * 100), 0)
      INTO v_rate
      FROM covid_cases
     WHERE country = p_country
       AND date = (
           SELECT MAX(report_date)
           FROM (
               SELECT date AS report_date
               FROM covid_cases
               WHERE country = p_country
           ) AS country_dates
       );

    RETURN v_rate;
END$$

-- Use Case 25: change history table used by the update trigger.
CREATE TABLE IF NOT EXISTS covid_cases_audit (
    audit_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    old_confirmed INT,
    new_confirmed INT,
    old_deaths INT,
    new_deaths INT,
    old_recovered INT,
    new_recovered INT,
    changed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER trg_covid_cases_before_update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    IF NOT (OLD.confirmed <=> NEW.confirmed)
       OR NOT (OLD.deaths <=> NEW.deaths)
       OR NOT (OLD.recovered <=> NEW.recovered) THEN
        INSERT INTO covid_cases_audit (
            country, report_date,
            old_confirmed, new_confirmed,
            old_deaths, new_deaths,
            old_recovered, new_recovered
        ) VALUES (
            OLD.country, OLD.date,
            OLD.confirmed, NEW.confirmed,
            OLD.deaths, NEW.deaths,
            OLD.recovered, NEW.recovered
        );
    END IF;
END$$

DELIMITER ;
