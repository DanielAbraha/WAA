package cs545.miu.edu.lab3.controller;

import cs545.miu.edu.lab3.domain.Post;
import cs545.miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin("*")  //if u want to over lapp
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAllPostes(){
        return postService.getAll();
    }
     @DeleteMapping("/delete/{id}")
    public void deletePostById(@PathVariable("id") long id){
        postService.deletePost(id);

     }

    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable long id){

     return   postService.getById(id);
    }

    @PostMapping
    public void savePost(Post post){
        postService.savePost(post);
    }

}
