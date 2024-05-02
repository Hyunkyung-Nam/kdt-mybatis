package kdt11jpa.kit.controller;

import kdt11jpa.kit.dto.BoardDTO;
import kdt11jpa.kit.entity.BoardEntity;
import kdt11jpa.kit.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    //모든 보드 조회
    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoard(){
        List<BoardDTO> boardDTOList = boardService.getAllBoard();
        return ResponseEntity.ok(boardDTOList);
    }
    //1개 상세조회
    @GetMapping("/id")
    public ResponseEntity<BoardDTO> getBoardById(@PathVariable Long id){
        return ResponseEntity.ok(boardService.findById(id));
    }
    //writer 조회
    @GetMapping("/search/{writer}")
    public ResponseEntity<List<BoardDTO>> getWriterBoardByName(@PathVariable String writer){
        List<BoardDTO> boardDTOList = boardService.getBoardByWriter(writer);
        return ResponseEntity.ok(boardDTOList);
    }
    //보드 작성
    @PostMapping
    public ResponseEntity<Void> addBoard(@RequestBody BoardEntity board){
        boardService.addBoard(board);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //리더님 보드 추가
    @PostMapping("/new")
    public ResponseEntity<BoardEntity> create(@RequestBody BoardDTO boardDTO){
        return ResponseEntity.ok(boardService.create(boardDTO));
    }

    //보드 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBoard(@PathVariable("id") long id,@RequestBody BoardEntity board){
        board.setId(id);
        boardService.updateBoard(board);
        return ResponseEntity.ok().build();
    }

    //리더님 보드 수정
    @PutMapping("/new/{id}")
    public ResponseEntity<BoardEntity> update(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
        return ResponseEntity.ok(boardService.update(id, boardDTO));
    }

    //보드 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id") long id){
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
