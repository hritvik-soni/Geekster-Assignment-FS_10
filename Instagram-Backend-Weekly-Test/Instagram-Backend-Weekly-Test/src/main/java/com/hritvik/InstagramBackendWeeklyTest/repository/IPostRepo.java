package com.hritvik.InstagramBackendWeeklyTest.repository;

import com.hritvik.InstagramBackendWeeklyTest.model.Post;
import com.hritvik.InstagramBackendWeeklyTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Long> {

    Post findFirstByUser(User user);
}
