package cs545.miu.edu.lab3.controller;

import cs545.miu.edu.lab3.domain.Comment;
import cs545.miu.edu.lab3.service.CommentService;
import cs545.miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;


    @GetMapping
    public List<Comment> getComments(){
        return commentService.getAll();
    }

    @GetMapping("/{id}/posts")
    public List<Comment> getComments(@PathVariable("id") long id){
        return postService.getPostWithComments(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Comment comment){
        commentService.addComment(comment);
    }

}
