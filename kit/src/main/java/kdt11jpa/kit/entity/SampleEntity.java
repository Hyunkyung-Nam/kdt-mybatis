package kdt11jpa.kit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // DB테이블에 대응되는 하나의 클래스
@Getter
@Setter
@Table(name = "sample")
//롬복에서 가져오는거
//Entity만들때 기본생성자 필요하다
@NoArgsConstructor  //기본생성자
@AllArgsConstructor //모든 필드값이 포함된 생성자
//@RequiredArgsConstructor final이나 @NotNull이라도 설정해놓은 필드값만 포함된 생성자
public class SampleEntity {
    //primary key를 뜻함, 필수
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment 설정
    private long id; //int , long 많이쓴다 소문자로써도 되고 Wrapperclass사용해서 써도 된다

    @Column
    private String name;

    @Column(name="emailAddr", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name="price", scale = 2, precision = 10 ) //scale BigDecimal에서 사용하는거/ precision은 총 자리수
    private BigDecimal price;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") // 한번 세팅되면 업데이트안되게하기
    private LocalDateTime createAt;

    //columnDefinition을 이용해서 타입 지정가능
    @Column(name = "description", columnDefinition = "TEXT" )
    private String description;


}
