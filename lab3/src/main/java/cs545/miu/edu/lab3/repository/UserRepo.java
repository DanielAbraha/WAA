package cs545.miu.edu.lab3.repository;


import cs545.miu.edu.lab3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    List<User>findUserByPostsGreaterThan(long n);

// @Query( "select p from Product p where p.reviews.size >= :num" )
//    public List<Product> findProductWithReviews(int num);

    @Query("select u from User u where u.posts>:num")
    public List<User> getUserByPosts(@Param("num") int num);

    @Query("select u from User u join u.posts where  = :title")
    public List<User>getUserByPostsWithinTitle(String title);

}
