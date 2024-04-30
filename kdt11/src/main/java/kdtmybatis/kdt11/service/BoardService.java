package kdtmybatis.kdt11.service;

import kdtmybatis.kdt11.domain.Board;
import kdtmybatis.kdt11.dto.BoardDTO;
import kdtmybatis.kdt11.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper){
        this.boardMapper = boardMapper;
    }

    public List<BoardDTO> getBoardList(){
        List<Board> boards = boardMapper.selectAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

//      반복되는 부분 메서드로 따로 뺴도 괜찮을 듯!
        for(Board board:boards){
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

    public List<BoardDTO> getWriterBoardList(String writer){
        List<Board> boards = boardMapper.selectWriter(writer);
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for(Board board:boards){
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

    // 매개변수도 보드 DTO로 받아서 바꿔서 넣는게 정석??? 무슨말일까잉 ㅇㅂㅇ
    public void addBoard(Board board){
        boardMapper.insertBoard(board);
    }

    public void updateBoard(Board board){
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(int id){
        boardMapper.deleteBoard(id);
    }
}
