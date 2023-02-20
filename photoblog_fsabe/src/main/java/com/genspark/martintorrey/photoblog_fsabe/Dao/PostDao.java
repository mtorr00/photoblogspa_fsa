package com.genspark.martintorrey.photoblog_fsabe.Dao;

import com.genspark.martintorrey.photoblog_fsabe.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post,Long> {

}
