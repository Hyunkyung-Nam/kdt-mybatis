package kdtmybatis.kdt11.mapper;

import kdtmybatis.kdt11.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectAll();
    List<Board> selectWriter(String writer);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id);
}
