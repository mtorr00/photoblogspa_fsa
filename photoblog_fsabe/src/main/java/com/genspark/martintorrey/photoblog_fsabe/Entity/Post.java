package com.genspark.martintorrey.photoblog_fsabe.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name="posts")
@NoArgsConstructor
public class Post {

    @Id
    @Column(name="post id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="photo url")
    private String photoUrl;

    @Column(name="blog story content")
    private String blogStory;

    @Column(name="createdDate")
    private Date createdDate;

    public Post(String name, String photoUrl, String blogStory, Date date) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.blogStory = blogStory;
        this.createdDate = date;
    }
}
