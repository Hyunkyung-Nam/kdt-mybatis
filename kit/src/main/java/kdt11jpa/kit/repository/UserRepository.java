package kdt11jpa.kit.repository;

import kdt11jpa.kit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    //사용자 이름으로 조회
    List<UserEntity> findByName(String name);

    //검색어를 보냈을 때 사용자 이름과 일치하거나 닉네임과 일치할 경우 조회
    List<UserEntity> findByNameOrNickname(String name, String nickname);

    //이름이 존재하는지 조회
    Boolean existsByName(String name);
}
