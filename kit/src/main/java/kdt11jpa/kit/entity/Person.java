package kdt11jpa.kit.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //mappedBy얘는 필수값은 아니지만 관계알려주려고하는거
    //역시서는 단방향연결이라 필수가아니다
    //mappedBy가 필수가 되어야할 때 : 양방향연결일때는 필수이다
    @OneToOne(mappedBy = "owner")
    private IdCard idCard;

    @OneToMany(mappedBy = "person")
    private List<Book> books = new ArrayList<>();
    /**
     * mappedBy
     * 비소유쪽에 선언되어야 함
     */
}
