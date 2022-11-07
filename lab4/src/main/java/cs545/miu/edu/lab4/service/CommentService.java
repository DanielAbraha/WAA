package cs545.miu.edu.lab4.service;



import cs545.miu.edu.lab4.domain.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);
     List<Comment> getAll();


}
