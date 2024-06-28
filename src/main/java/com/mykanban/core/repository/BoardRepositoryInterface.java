package com.mykanban.core.repository;

import com.mykanban.core.model.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositoryInterface extends CrudRepository<Board, Long> {
}
