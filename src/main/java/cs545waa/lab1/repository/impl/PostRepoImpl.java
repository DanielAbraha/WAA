package cs545waa.lab1.repository.impl;

import cs545waa.lab1.domain.Post;
import cs545waa.lab1.repository.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;
    private static long postId = 1;

    static{
        posts = new ArrayList<>();
        Post post1 = new Post(1," Rozan selen","love story","Henok");
        Post post2 = new Post(2," fikrin kinatin","true story","Daniel");
        Post post3 = new Post(3," how to cook","tutorial","Frena");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(long id) {
        return posts.stream().filter(p->p.getId() ==id).findFirst().orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postId);
        postId++;
        posts.add(post);
    }

    @Override
    public void delete(int id) {
        var post = posts.stream().
                filter(p->p.getId()==id).findFirst().get();
        posts.remove(post);

    }

    @Override
    public void update(int id, Post p) {
        Post updatedPost = getById(id);
        updatedPost.setTitle(p.getTitle());
        updatedPost.setContent(p.getContent());
        updatedPost.setAuthor(p.getAuthor());


    }
}
