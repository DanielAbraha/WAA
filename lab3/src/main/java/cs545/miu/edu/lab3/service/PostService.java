package cs545.miu.edu.lab3.service;

import cs545.miu.edu.lab3.domain.Comment;
import cs545.miu.edu.lab3.domain.Post;


import java.util.List;

public interface PostService {
    List<Comment> getPostWithComments(long id);

    public List<Post> getAllByTitle(String title);
}
