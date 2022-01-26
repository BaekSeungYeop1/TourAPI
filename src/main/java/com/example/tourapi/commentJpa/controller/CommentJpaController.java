package com.example.tourapi.commentJpa.controller;

import com.example.tourapi.comment.model.CommentDTO;
import com.example.tourapi.commentJpa.service.CommentJpaService;
import com.example.tourapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/commentjpa")
public class CommentJpaController {

    public final CommentJpaService commentJpaService;

    @PostMapping(value = "/")
    public ApiResponse<CommentDTO> postComment(@RequestBody CommentDTO commentDTO) {
        CommentDTO data = commentJpaService.postComment(commentDTO);
        return new ApiResponse(true, data);
    }
}
