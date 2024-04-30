package kdt11jpa.kit.service;

import kdt11jpa.kit.dto.UserDTO;
import kdt11jpa.kit.entity.UserEntity;
import kdt11jpa.kit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll(){
        return userListTouserDTOList(userRepository.findAll());
    }
    public void createUser(UserEntity user){
        userRepository.save(user);
    }
    public List<UserDTO> findByName(String name){
        return userListTouserDTOList(userRepository.findByName(name));
    }
    public List<UserDTO> findByNameOrNickname(String name, String nickname){
        return userListTouserDTOList(userRepository.findByNameOrNickname(name, nickname));
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
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
