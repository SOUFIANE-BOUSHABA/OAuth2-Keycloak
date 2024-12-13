package com.example.oauth2keycloack.Mapper;

import com.example.oauth2keycloack.DTOs.BoardDTO;
import com.example.oauth2keycloack.Entity.Board;
import org.springframework.web.bind.annotation.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    BoardDTO toDTO(Board board);
    Board toEntity(BoardDTO boardDTO);
}
