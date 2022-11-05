package cs545.miu.edu.lab3.service.impl;

import cs545.miu.edu.lab3.domain.Comment;
import cs545.miu.edu.lab3.domain.Post;
import cs545.miu.edu.lab3.repository.CommentRepo;
import cs545.miu.edu.lab3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Override
    public void addComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }


}
