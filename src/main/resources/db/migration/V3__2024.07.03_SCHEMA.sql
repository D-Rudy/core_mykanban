ALTER TABLE colonne
    MODIFY nom VARCHAR (255) NULL;

ALTER TABLE ticket
DROP
COLUMN priorite;

ALTER TABLE ticket
    ADD priorite INT DEFAULT 1 NOT NULL;