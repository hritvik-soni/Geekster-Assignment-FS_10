package com.hritvik.InstagramBackendWeeklyTest.service;

import com.hritvik.InstagramBackendWeeklyTest.model.Post;
import com.hritvik.InstagramBackendWeeklyTest.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String createInstaPost(Post post) {
        post.setCreatedDate(LocalDateTime.now());
        postRepo.save(post);
        return "Post uploaded!!!!";
    }

    public Post getPostById(Long id) {
        return postRepo.findById(id).orElse(null);
    }


}
