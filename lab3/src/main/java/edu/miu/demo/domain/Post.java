package edu.miu.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")

    private List<Comment> comments;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
