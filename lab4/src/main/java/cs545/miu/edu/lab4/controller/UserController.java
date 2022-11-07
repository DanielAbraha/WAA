package cs545.miu.edu.lab4.controller;


import cs545.miu.edu.lab4.aspect.annotation.ExecutionTIme;
import cs545.miu.edu.lab4.aspect.annotation.LogMe;
import cs545.miu.edu.lab4.domain.Post;
import cs545.miu.edu.lab4.domain.User;
import cs545.miu.edu.lab4.service.PostService;
import cs545.miu.edu.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @GetMapping
//    @LogMe
//    @ExecutionTIme
    public List<User> displayUsers(){
        System.out.println("getAll() is printed");
    return    userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @LogMe
    @ExecutionTIme
    public User displayById(@PathVariable("id") long id){
        System.out.println("getById() is printed");
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

  @GetMapping("/filter/posts/{n}")
    public List<User> getByNumOfPosts(@PathVariable("n") int n){
        return userService.getUserByPosts(n);
  }
 @GetMapping("/filter/{title}")
 public List<Post> getAllByTitle(@PathVariable("title") String title){
        return postService.getAllByTitle(title);
 }
}
