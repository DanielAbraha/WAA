package cs545.lab2.controller;

import cs545.lab2.domain.Post;
import cs545.lab2.domain.User;
import cs545.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> displayUsers(){
    return    userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User displayById(@PathVariable("id") long id){
        return userService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userService.saveUser(user);
    }
  @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable("id") long id){
        return userService.getUsersPosts(id);
  }

}
