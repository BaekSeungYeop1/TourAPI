package com.example.tourapi.comment.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO {


    List<CommentDTO> getCommentList(int id);


    int insertComment(CommentDTO commentDTO);

    List<CommentDTO> getCommentsById(int id);
}
