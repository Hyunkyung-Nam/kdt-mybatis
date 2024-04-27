package kdtmybatis.kdt11.mapper;

import kdtmybatis.kdt11.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //xml안만들고 이렇게 써도된다.
    //@Select("SELECT from user")
    //List<User> selectAll();
    List<User> selectAll();

    //@Insert("INSERT INTO user(name, nickname) VALUES (#{name}, #{nickname})")
    //void insertUser(User user);
    //void insertUser(@Param("name") String name, @Param("nickname") String nickname);

    void insertUser(@Param("user") User user);

    //@Update("UPDATE user SET name = #{name}, nickname = #{nickname} WHERE id = #{id}")
    void updateUser(User user);

    void deleteUser(int id);
    //명시적으로 @Param넣어주는거임
    //void deleteUser(@Param("id")int id);
}
