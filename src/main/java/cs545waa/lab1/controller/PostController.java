package cs545waa.lab1.controller;

import cs545waa.lab1.domain.dto.PostDto;
import cs545waa.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @GetMapping
    public List<PostDto> displayPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable("id") int id){
        return postService.getById(id);
    }

    @PostMapping
    public void savePost(@RequestBody  PostDto postDto){
        postService.save( postDto);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable ("id") int  postId, @RequestBody PostDto postDto){
        postService.update(postId,postDto);

    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int postId){
        postService.delete(postId);
    }







}

