-- Use Case 29: atomic multi-step vaccine distribution insertion.
-- InnoDB is required because it supports transactions and rollback.

CREATE TABLE IF NOT EXISTS vaccine_distribution (
    distribution_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    distribution_date DATE NOT NULL,
    vaccine_name VARCHAR(100) NOT NULL,
    doses_distributed BIGINT NOT NULL,
    CONSTRAINT chk_doses_distributed CHECK (doses_distributed >= 0),
    UNIQUE KEY uq_distribution (country, distribution_date, vaccine_name)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS vaccine_distribution_audit (
    audit_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    distribution_id BIGINT NOT NULL,
    action_name VARCHAR(30) NOT NULL,
    recorded_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_audit_distribution
        FOREIGN KEY (distribution_id) REFERENCES vaccine_distribution(distribution_id)
) ENGINE=InnoDB;

DELIMITER $$
CREATE PROCEDURE add_vaccine_distribution(
    IN p_country VARCHAR(100),
    IN p_distribution_date DATE,
    IN p_vaccine_name VARCHAR(100),
    IN p_doses_distributed BIGINT
)
BEGIN
    -- Any SQL error in either insert rolls back the complete unit of work.
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    INSERT INTO vaccine_distribution
        (country, distribution_date, vaccine_name, doses_distributed)
    VALUES
        (p_country, p_distribution_date, p_vaccine_name, p_doses_distributed);

    INSERT INTO vaccine_distribution_audit (distribution_id, action_name)
    VALUES (LAST_INSERT_ID(), 'DISTRIBUTED');

    COMMIT;
END$$
DELIMITER ;

-- Successful call:
CALL add_vaccine_distribution('India', '2026-07-22', 'Covishield', 500000);

-- This fails its CHECK constraint; neither table receives a partial change:
-- CALL add_vaccine_distribution('India', '2026-07-23', 'Covishield', -1);
