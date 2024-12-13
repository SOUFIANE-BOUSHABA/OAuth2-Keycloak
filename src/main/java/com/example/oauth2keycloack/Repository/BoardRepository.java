package com.example.oauth2keycloack.Repository;

import com.example.oauth2keycloack.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}