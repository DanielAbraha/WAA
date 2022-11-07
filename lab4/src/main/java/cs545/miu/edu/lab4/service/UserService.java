package cs545.miu.edu.lab4.service;




import cs545.miu.edu.lab4.domain.Post;
import cs545.miu.edu.lab4.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getById(long id);
    void saveUser(User user);
    List<Post> getUsersPosts(long id);
    public List<User> getUserByPosts(int num);
}
