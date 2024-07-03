CREATE TABLE archive
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    date_creat datetime NULL,
    date_modif datetime NULL,
    id_ticket  BIGINT NULL,
    CONSTRAINT pk_archive PRIMARY KEY (id)
);

CREATE TABLE board
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    nom        VARCHAR(255) NULL,
    date_creat datetime NULL,
    date_modif datetime NULL,
    CONSTRAINT pk_board PRIMARY KEY (id)
);

CREATE TABLE colonne
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    nom        VARCHAR(255) NOT NULL,
    date_creat datetime NULL,
    date_modif datetime NULL,
    id_board   BIGINT NULL,
    CONSTRAINT pk_colonne PRIMARY KEY (id)
);

CREATE TABLE ticket
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    titre          VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    priorite      INT          NOT NULL,
    date_creat    datetime NULL,
    date_modif    datetime NULL,
    id_colonne    BIGINT NULL,
    CONSTRAINT pk_ticket PRIMARY KEY (id)
);

ALTER TABLE archive
    ADD CONSTRAINT FK_ARCHIVE_ON_ID_TICKET FOREIGN KEY (id_ticket) REFERENCES ticket (id);

ALTER TABLE colonne
    ADD CONSTRAINT FK_COLONNE_ON_ID_BOARD FOREIGN KEY (id_board) REFERENCES board (id);

ALTER TABLE ticket
    ADD CONSTRAINT FK_TICKET_ON_COLONNE FOREIGN KEY (id_colonne) REFERENCES colonne (id);