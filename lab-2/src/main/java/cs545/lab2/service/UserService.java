package cs545.lab2.service;

import cs545.lab2.domain.Post;
import cs545.lab2.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getById(long id);
    void saveUser(User user);
    List<Post> getUsersPosts(long id);
}
