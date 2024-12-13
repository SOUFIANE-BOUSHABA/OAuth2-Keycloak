package com.example.oauth2keycloack.Controller;

import com.example.oauth2keycloack.Entity.Board;
import com.example.oauth2keycloack.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping
    @PreAuthorize("hasRole('user')")
    public List<Board> getAllBoards() {
        return boardService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Optional<Board> board = boardService.findById(id);
        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public Board createBoard(@RequestBody Board board) {
        return boardService.save(board);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board boardDetails) {
        Optional<Board> board = boardService.findById(id);
        if (board.isPresent()) {
            Board updatedBoard = board.get();
            updatedBoard.setTitle(boardDetails.getTitle());
            updatedBoard.setContent(boardDetails.getContent());
            return ResponseEntity.ok(boardService.save(updatedBoard));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        if (boardService.findById(id).isPresent()) {
            boardService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}