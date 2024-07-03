package com.mykanban.core.repository;

import com.mykanban.core.repository.entity.Colonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColonneRepository extends JpaRepository<Colonne, Long> {
    @Query("SELECT c FROM Colonne c WHERE c.board.id = :id")
    List<Colonne> getColonneByBoard(@Param("id") long id);
}
