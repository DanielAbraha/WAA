package cs545.miu.edu.lab3.service;



import cs545.miu.edu.lab3.domain.Post;
import cs545.miu.edu.lab3.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getById(long id);
    void saveUser(User user);
    List<Post> getUsersPosts(long id);
    public List<User> getUserByPosts(int num);
}
