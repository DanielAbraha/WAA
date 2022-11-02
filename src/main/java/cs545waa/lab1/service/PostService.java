package cs545waa.lab1.service;

import cs545waa.lab1.domain.Post;
import cs545waa.lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> getAllPosts();

    public PostDto getById(long id);

    public void save(PostDto p);

    public void delete(int id);

    public void update(int id, PostDto p);


}
