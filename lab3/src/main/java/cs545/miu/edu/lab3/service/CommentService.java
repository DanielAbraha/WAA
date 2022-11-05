package cs545.miu.edu.lab3.service;

import cs545.miu.edu.lab3.domain.Comment;
import cs545.miu.edu.lab3.domain.Post;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);
     List<Comment> getAll();


}
