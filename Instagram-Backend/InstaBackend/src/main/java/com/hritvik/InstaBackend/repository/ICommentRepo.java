package com.hritvik.InstaBackend.repository;

import com.hritvik.InstaBackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {
}
