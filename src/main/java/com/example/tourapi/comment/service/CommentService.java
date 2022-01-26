package com.example.tourapi.comment.service;


import com.example.tourapi.board.model.BoardDAO;
import com.example.tourapi.board.model.BoardDTO;
import com.example.tourapi.comment.model.CommentDAO;
import com.example.tourapi.comment.model.CommentDTO;
import com.example.tourapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    public final BoardDAO boardDAO;
    public final CommentDAO commentDAO;

    public List<CommentDTO> getCommentList(int id) {
        return commentDAO.getCommentList(id);
    }

    public ApiResponse<CommentDTO> insertComment(CommentDTO commentDTO) throws Exception {
        // 요청받은 id값에 해당하는 Board컨텐츠가 있는지 없는지?
        BoardDTO selectedBoard = boardDAO.getBoardById(commentDTO.getId());
        if(selectedBoard == null){
            String failedMessage = "id value " + commentDTO.getId() + " is not exists in board";
            return new ApiResponse<>(false, failedMessage);
        } else {
            commentDTO.setWriteDate(LocalDate.now());
            commentDTO.setWriteTime(LocalTime.now());
            commentDAO.insertComment(commentDTO);

            String successMessage = "success to insert comment data id " + commentDTO.getId();
            return new ApiResponse<>(true, successMessage, commentDTO);
        }
    }

}
