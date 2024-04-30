package kdt11jpa.kit.repository;

import kdt11jpa.kit.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByWriter(String writer);

}
