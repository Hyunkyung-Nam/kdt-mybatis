package kdt11jpa.kit.service;

import kdt11jpa.kit.dto.BoardDTO;
import kdt11jpa.kit.entity.BoardEntity;
import kdt11jpa.kit.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<BoardDTO> findByAll(){
        return boardRepository.findAll().stream().map(board -> BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build()).collect(Collectors.toList());
    }

    public List<BoardDTO> getAllBoard(){
        List<BoardEntity> boards = boardRepository.findAll();
        return boardListToBoardDTOList(boards);
    }

    public BoardDTO findById(Long id){
        return boardRepository.findById(id).map(board -> BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build())
                .orElse(null); // optional 없으면 null
    }

    public List<BoardDTO> getBoardByWriter(String writer){
        List<BoardEntity> boards = boardRepository.findByWriter(writer);
        return boardListToBoardDTOList(boards);
    }
    public List<BoardDTO> findByWriter(String writer){
        return boardRepository.findAll().stream().map(board -> BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build()).collect(Collectors.toList());
    }

    public void addBoard(BoardEntity board){
        board.setId(null);
        boardRepository.save(board);
    }

    public BoardEntity create(BoardDTO boardDTO){
        BoardEntity board = BoardEntity.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .registered(boardDTO.getRegistered())
                .build();
        return boardRepository.save(board);
    }

    public void  updateBoard(BoardEntity board){
        boardRepository.save(board);
    }

    public BoardEntity update(Long id, BoardDTO boardDTO){
        BoardEntity board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디값입니다.")); //있는지 먼저 찾기
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setWriter(boardDTO.getWriter());
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }

    List<BoardDTO> boardListToBoardDTOList(List<BoardEntity> boards){
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity board:boards){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(board.getId());
            boardDTO.setTitle(board.getTitle());
            boardDTO.setContent(board.getContent());
            boardDTO.setWriter(board.getWriter());
            boardDTO.setRegistered(board.getRegistered());
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }
}
