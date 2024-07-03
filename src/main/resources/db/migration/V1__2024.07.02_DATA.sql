INSERT INTO board (id, nom)
SELECT 1, 'test board'
WHERE NOT EXISTS(SELECT 1
                 FROM board
                 WHERE id = 1);

INSERT INTO colonne(id, nom, id_board)
SELECT 1, 'backlog', 1
WHERE NOT EXISTS(SELECT 1
                 FROM colonne
                 WHERE id = 1);

INSERT INTO colonne(id, nom, id_board)
SELECT 2, 'en cours', 1
WHERE NOT EXISTS(SELECT 1
                 FROM colonne
                 WHERE id = 2);

INSERT INTO colonne(id, nom, id_board)
SELECT 3, 'fait', 1
WHERE NOT EXISTS(SELECT 1
                 FROM colonne
                 WHERE id = 3);

INSERT INTO ticket (id, titre, description, id_colonne)
SELECT 1, 'tache 1', 'tache du backlog', 1
WHERE NOT EXISTS(SELECT 1
                 FROM ticket
                 WHERE id = 1);

INSERT INTO ticket (id, titre, description, id_colonne)
SELECT 2, 'tache 1', 'tache en cours', 2
WHERE NOT EXISTS(SELECT 1
                 FROM ticket
                 WHERE id = 2);

INSERT INTO ticket (id, titre, description, id_colonne)
SELECT 3, 'tache 1', 'tache terminée', 3
WHERE NOT EXISTS(SELECT 1
                 FROM ticket
                 WHERE id = 3);
