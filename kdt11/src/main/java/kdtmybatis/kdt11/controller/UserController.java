package kdtmybatis.kdt11.controller;

import kdtmybatis.kdt11.domain.User;
import kdtmybatis.kdt11.dto.UserDTO;
import kdtmybatis.kdt11.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //가져다 쓰기위해 주입함
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUserList(){
        List<UserDTO> users = userService.getUserList();
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable int id,@RequestBody User user){
        user.setId(id); //식별자 지정
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
