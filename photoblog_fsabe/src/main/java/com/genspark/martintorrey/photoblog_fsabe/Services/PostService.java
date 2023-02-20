package com.genspark.martintorrey.photoblog_fsabe.Services;

import com.genspark.martintorrey.photoblog_fsabe.Entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getRecentPosts();

    Post getPostById(Long id);

    List<Post> getAllByName(String name);

    Post addPost(Post post);

    Post updatePost(Post post);

    String deletePostById(Long id);
}
