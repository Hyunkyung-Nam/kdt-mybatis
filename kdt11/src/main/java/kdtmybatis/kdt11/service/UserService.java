package kdtmybatis.kdt11.service;

import kdtmybatis.kdt11.domain.User;
import kdtmybatis.kdt11.dto.UserDTO;
import kdtmybatis.kdt11.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    //생성자 주입
    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public List<UserDTO> getUserList(){
        // 디비에서 가져온 User
        List<User> result = userMapper.selectAll();
        //반환할 전체 userDTOList
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user:result){
            //디비에서 가져온값을 하나씩 userDTO에 넣어서 userDTOList에 넣어준다
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setNickname(user.getNickname());
            userDTO.setNo(userDTOList.size()+1);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
    public void addUser(User user){
        userMapper.insertUser(user);
    }
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
    public void deleteUser(int id){
        userMapper.deleteUser(id);
    }
}
