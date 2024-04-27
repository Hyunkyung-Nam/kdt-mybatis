package kdtmybatis.kdt11.controller;

import kdtmybatis.kdt11.domain.Board;
import kdtmybatis.kdt11.dto.BoardDTO;
import kdtmybatis.kdt11.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    public final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getBoardList(){
       List<BoardDTO> boardList = boardService.getBoardList();
       return ResponseEntity.ok(boardList);
    }

    @GetMapping("/{writer}")
    public ResponseEntity<List<BoardDTO>> getWriterBoardList(@PathVariable String writer){
        List<BoardDTO> boardList = boardService.getWriterBoardList(writer);
        return ResponseEntity.ok(boardList);
    }

    @PostMapping
    public String addBoard(@RequestBody  Board board){
        boardService.addBoard(board);
        return "OK";
    }



    @PutMapping("/{id}")
    public String updateBoard(@PathVariable() int id,@RequestBody  Board board){
        board.setId(id);
        boardService.updateBoard(board);
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable  int id){
        boardService.deleteBoard(id);
        return "Ok";
    }
}
