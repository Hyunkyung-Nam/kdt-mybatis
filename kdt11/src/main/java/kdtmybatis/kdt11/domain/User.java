package kdtmybatis.kdt11.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//domain이라고도 하고 entity라고도 함
//SQL문이랑 똑같이 쓰면된다.

public class User {
    private int id;
    private String name;
    private String nickname;
}
