package cs545.miu.edu.lab4.service.impl;

import cs545.miu.edu.lab4.domain.Comment;
import cs545.miu.edu.lab4.domain.Post;
import cs545.miu.edu.lab4.repository.PostRepo;
import cs545.miu.edu.lab4.service.PostService;
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
}
