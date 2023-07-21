package com.hritvik.InstaBackend.repository;

import com.hritvik.InstaBackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
