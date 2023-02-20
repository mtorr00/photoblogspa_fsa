package com.genspark.martintorrey.photoblog_fsabe.Controller;

import com.genspark.martintorrey.photoblog_fsabe.Entity.Post;
import com.genspark.martintorrey.photoblog_fsabe.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/home")
    public List<Post> home() {return this.postService.getRecentPosts();}

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable String id) {return this.postService.getPostById(Long.parseLong(id));}

    @GetMapping("/post/all/{name}")
    public List<Post> named(@PathVariable String name) {return this.postService.getAllByName(name);}

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {return this.postService.addPost(post);}

    @PutMapping("/post")
    public Post updatePost(@RequestBody Post post) {return this.postService.updatePost(post);}

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable String id){return this.postService.deletePostById(Long.parseLong(id));}

}
