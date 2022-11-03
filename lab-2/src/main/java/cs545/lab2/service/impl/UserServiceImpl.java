package cs545.lab2.service.impl;

import cs545.lab2.domain.Post;
import cs545.lab2.domain.User;
import cs545.lab2.repository.UserRepo;
import cs545.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);

    }

    @Override
    public List<Post> getUsersPosts(long id) {
        return userRepo.findById(id).get().getPosts();
    }
}
