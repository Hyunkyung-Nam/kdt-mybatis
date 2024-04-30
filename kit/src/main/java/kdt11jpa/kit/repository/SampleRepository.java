package kdt11jpa.kit.repository;

import kdt11jpa.kit.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
    //규칙
    //시작단어 : find, read, query, count, get, exists 단어로 시작
    //조건표현 : 엔티티의 속성 이름을 기반으로 하는 조건 표현 . 대문자로 시작
    //연결어 : And, Or, 연결어를 사용하여 여러 조건을 연결 할 수 있음
    //조건키워드 : Between, Like, In, LessThen 등 속성이름뒤에 필요에 따라 조건을 더 세밀하게 정의
    //정렬 : OrderBy를 사용하여 순서 정렬시 속성이름과 'ASC', 'DESC' 를 통해 정렬지정
    //리턴타입과 매개변수  : 리턴타입은 조회결과 형태, 메개변수는 쿼리의 사용 될 데이터
    //Optional : 배열로 리턴할때는 쓰는거아님, 단일객체를 반활할때 null일수도있는 상황에서 사용
    // List는 빈배열이 나와서 괜찮음 오류안나서

    //SampleEntity findByNameAndEmailLike(String name, String email);
   // SampleEntity findByNameOrderByIdDesc(int id);
    //단순조회
    //List<SampleEntity> findByName(String name);
   // SampleEntity findByEmail(String email);

    //조건적 조회
  // List<SampleEntity> findByNameAndEmail(String name, String email);
    //정렬
   // List<SampleEntity> findByNameOrderByIdDesc (String name);

    //시작명령어
    //long countByName(String name);

    long deleteByName(String name);

    //@Query 어노테이션
    //특정한
  //  @Query("SELECT * FOMR sampleEntity WHERE email LIKE @%?1%")  ?1은 첫번째 매개변수
 //   List<SampleEntity> finrdByEmailLike(String email);

     // @Query("SELECT * FOMR sampleEntity WHERE email = :username)
     //  List<SampleEntity> finrdByUserName(String username);
    //List<SampleEntity> finrdByUserName(@Parma("username")String username);

}
