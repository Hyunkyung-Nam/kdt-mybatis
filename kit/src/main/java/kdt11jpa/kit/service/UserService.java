package kdt11jpa.kit.service;

import kdt11jpa.kit.dto.UserDTO;
import kdt11jpa.kit.entity.UserEntity;
import kdt11jpa.kit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 애를 쓰면 final붙은 변수들에 대한 생성자 자동생성
public class UserService {
    private final UserRepository userRepository;

    //@RequiredArgsConstructor가 아래 생성자 대신 사용
    //코드가 줄어들 것이다 final이나 not null 설정해놓은게 있어야 사용가능하다.
//    @Autowired
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    public List<UserDTO> findAll() {
        return userListTouserDTOList(userRepository.findAll());
    }

    public UserEntity create(UserDTO userDTO){
        UserEntity user =  UserEntity.builder()
                .name(userDTO.getName())
                .nickname(userDTO.getNickname())
                .build(); //롬복에서 사용하는거 , 빌더와 빌드 사이에 넣고싶은 값들 다넣으면된다.
        return userRepository.save(user);
    }

    public UserEntity create2(UserDTO userDTO){
        UserEntity user = new UserEntity();
        user.setName(userDTO.getName());
        user.setNickname(userDTO.getNickname());
        return userRepository.save(user);
    }
    public void createUser(UserEntity user){
        userRepository.save(user);
    }

    public List<UserDTO> findByName(String name){
        return userListTouserDTOList(userRepository.findByName(name));
    }
    public List<UserDTO> findAll2(String name){
        List<UserEntity> users = userRepository.findByName(name);
        return users.stream().map(user -> UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .build()).collect(Collectors.toList());
    }

    public List<UserDTO> findByNameOrNickname(String name){
        return userListTouserDTOList(userRepository.findByNameOrNickname(name, name));
    }
    public Boolean existsByName(String name){
        return userRepository.existsByName(name);
    }
    private List<UserDTO> userListTouserDTOList(List<UserEntity> userEntities){
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(userEntity.getId());
            userDTO.setName(userEntity.getName());
            userDTO.setNickname(userEntity.getNickname());
            userDTO.setCreateAt(userEntity.getCreateAt());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
