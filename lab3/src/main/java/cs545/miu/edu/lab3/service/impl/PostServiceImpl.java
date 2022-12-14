package cs545.miu.edu.lab3.service.impl;

import cs545.miu.edu.lab3.domain.Comment;
import cs545.miu.edu.lab3.domain.Post;
import cs545.miu.edu.lab3.repository.PostRepo;
import cs545.miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Override
    public List<Comment> getPostWithComments(long id) {
        return postRepo.findById(id).get().getComments() ;
    }

    @Override
    public List<Post> getAllByTitle(String title) {
        var posts = postRepo.findAll();
        return posts.stream().filter(p->p.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post getById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public void savePost(Post post) {
        postRepo.save(post);
    }
}
