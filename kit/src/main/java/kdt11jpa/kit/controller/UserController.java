package kdt11jpa.kit.controller;

import kdt11jpa.kit.dto.UserDTO;
import kdt11jpa.kit.entity.UserEntity;
import kdt11jpa.kit.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    //유저 전체조회
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> userDTOList = userService.findAll();
        return ResponseEntity.ok(userDTOList);
    }
    //name이름 가진 유저 모두 조회
    @GetMapping("/{name}")
    public ResponseEntity<List<UserDTO>> findByName(@PathVariable String name){
        List<UserDTO> users = userService.findByName(name);
        return ResponseEntity.ok(users);
    }
    //name or nickname을 가진 유저 모두 조회
    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> findByNameOrNickname(@Param("name") String name, @Param("nickname") String nickname) {
        System.out.print(name + nickname);
        List<UserDTO> users = userService.findByNameOrNickname(name, nickname);
        return ResponseEntity.ok(users);
    }
    //name을 가진 유저 존재여부 확인
    @GetMapping("/search/{name}")
    public ResponseEntity<Boolean> existsByName(@PathVariable String name){
        boolean existed = userService.existsByName(name);
        return ResponseEntity.ok(existed);
    }

    //user등록
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserEntity user){
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
