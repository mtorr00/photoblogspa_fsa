package com.genspark.martintorrey.photoblog_fsabe.Services;

import com.genspark.martintorrey.photoblog_fsabe.Dao.PostDao;
import com.genspark.martintorrey.photoblog_fsabe.Entity.Post;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDao postDao;


    @Override
    public List<Post> getRecentPosts() {
        ArrayList<Post> recentPosts = new ArrayList<>();
        int counter = 0;
        for (Post x: postDao.findAll(Sort.by(Sort.Direction.DESC,"createdDate"))){
            if (counter > 9){
                break;
            }
            recentPosts.add(x);
            counter++;
        }
        return recentPosts;
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> c = this.postDao.findById(id);
        Post post = null;
        if(c.isPresent()) {
            post = c.get();
        } else {
            throw new RuntimeException("Post not found for id :: " + id);
        }
        return post;
    }

    @Override
    public List<Post> getAllByName(String name) {
        ArrayList<Post> sameName = new ArrayList<>();
        for (Post x: postDao.findAll()) {
            if (x.getName().equals(name)){
                sameName.add(x);
            }
        }
        return sameName;
    }

    @Override
    public Post addPost(Post post) {
        return this.postDao.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return this.postDao.save(post);
    }

    @Override
    public String deletePostById(Long id) {
        this.postDao.deleteById(id);
        return "post deleted successfully";
    }
}
