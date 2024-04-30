package kdt11jpa.kit.service;

import kdt11jpa.kit.dto.BoardDTO;
import kdt11jpa.kit.entity.BoardEntity;
import kdt11jpa.kit.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<BoardDTO> getAllBoard(){
        List<BoardEntity> boards = boardRepository.findAll();
        return boardListToBoardDTOList(boards);
    }

    public List<BoardDTO> getBoardByWriter(String writer){
        List<BoardEntity> boards = boardRepository.findByWriter(writer);
        return boardListToBoardDTOList(boards);
    }

    public void addBoard(BoardEntity board){
        board.setId(null);
        boardRepository.save(board);
    }

    public void  updateBoard(BoardEntity board){
        boardRepository.save(board);
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
