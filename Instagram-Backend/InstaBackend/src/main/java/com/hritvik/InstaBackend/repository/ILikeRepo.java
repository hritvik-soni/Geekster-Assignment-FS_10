package com.hritvik.InstaBackend.repository;

import com.hritvik.InstaBackend.model.Like;
import com.hritvik.InstaBackend.model.Post;
import com.hritvik.InstaBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepo extends JpaRepository<Like,Integer> {

    List<Like> findByInstaPostAndLiker(Post instaPost, User liker);

    List<Like> findByInstaPost(Post validPost);
}
