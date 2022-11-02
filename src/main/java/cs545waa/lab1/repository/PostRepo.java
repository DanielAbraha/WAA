package cs545waa.lab1.repository;

import cs545waa.lab1.domain.Post;

import java.util.List;

public interface PostRepo {


    public List<Post> findAll();

    public Post getById(long id);

    public void save(Post p);

    public void delete(int id);

    public void update(int id, Post p);

}
