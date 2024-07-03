ALTER TABLE db_mykanban.ticket
DROP
COLUMN priorite;

ALTER TABLE db_mykanban.ticket
    ADD priorite INT DEFAULT 1 NOT NULL;

ALTER TABLE db_mykanban.ticket
    ALTER priorite SET DEFAULT 1;