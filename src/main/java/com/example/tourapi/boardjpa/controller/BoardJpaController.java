package com.example.tourapi.boardjpa.controller;

import com.example.tourapi.board.model.BoardDTO;
import com.example.tourapi.boardjpa.model.Board;
import com.example.tourapi.boardjpa.service.BoardJpaService;
import com.example.tourapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/boardjpa")
public class BoardJpaController {

    public final BoardJpaService boardJpaService;


    @GetMapping(value = "/")
    public ApiResponse<BoardDTO> getBoardList(){
        List<Board> list = boardJpaService.getBoardList();
        return new ApiResponse(true, list);
    }

    @GetMapping(value = "/{id}") // PathVariable
    public ApiResponse<BoardDTO> getBoardById(@PathVariable Integer id){
        Board data = boardJpaService.getBoardById(id);
        return new ApiResponse(true, data);
    }

    @PostMapping(value = "/")
    public ApiResponse<BoardDTO> postBoard(@RequestBody BoardDTO boardDTO){
        Board data = boardJpaService.postBoard(boardDTO);
        return new ApiResponse(true, data);
    }

    @PutMapping(value = "/{id}")
    public ApiResponse<BoardDTO> putBoard(@PathVariable int id,
                                          @RequestBody BoardDTO boardDTO){

        return boardJpaService.putBoard(id,boardDTO);
    }

    // DB에 데이터를 DELETE 시키지 말고, board 컬럼 중 isDel 을 "Y"로 업데이트.
    @DeleteMapping(value = "/{id}")
    public ApiResponse<BoardDTO> updateIsDelBoardById(@PathVariable int id,
                                                      @RequestBody BoardDTO boardDTO){
        return boardJpaService.updateIsDelBoardById(id,boardDTO);
    }

    /**
     조회수 중복 방지
     **/
    @GetMapping(value = "/views/{id}")
    private void viewCountUp(@PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) {

        Cookie oldCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("viewCount")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + id + "]")) {
                log.info("기존 쿠키가 있지만 해당 board 조회가 없을 때");
                boardJpaService.viewCountUp(id);
                oldCookie.setValue(oldCookie.getValue() + "_[" + id + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            log.info("기존 쿠키가 없을 때\"");
            boardJpaService.viewCountUp(id);
            Cookie newCookie = new Cookie("viewCount","[" + id + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }



    /*
    @GetMapping(value = "/")
    public ApiResponse<BoardDTO> getBoardList(@RequestParam int page, @RequestParam int size){
        Page<Board> list = boardJpaService.getBoardList(page, size);
        return new ApiResponse(true, list);
    }

    @GetMapping(value = "/{id}") // PathVariable
    public ApiResponse<BoardDTO> getBoardById(@PathVariable Integer id){
        Board data = boardJpaService.getBoardById(id);
        return new ApiResponse(true, data);
    }

    @PostMapping(value = "/")
    public ApiResponse<BoardDTO> postBoard(@RequestBody BoardDTO boardDTO){
        Board data = boardJpaService.postBoard(boardDTO);
        return new ApiResponse(true, data);
    }

    @PutMapping(value = "/{id}")
    public ApiResponse<BoardDTO> putBoard(@PathVariable int id,
                                          @RequestBody BoardDTO boardDTO){
        Board data = boardJpaService.putBoard(id, boardDTO);
        return new ApiResponse(true, data);
    }

    // DELETE /boardjpa/{id} 구현할것.
    // logic : board.controller.BoardController의 로직 따를것
    //         무슨말이냐면 DB에 데이터를 DELETE 시키지 말고, board 컬럼 중 isDel 을 "Y"로 업데이트.

    @DeleteMapping(value = "/{id}")
    public ApiResponse<BoardDTO> updateIsDelBoardById(@PathVariable int id,
                                                      @RequestBody BoardDTO boardDTO){
        String boardPassword = boardDTO.getPassword();
        // 패스워드가 없을 경우
        if (boardPassword == null){
            return new ApiResponse<>(false, "boardPassword is null, please check key name 'password'", null);
        }
        return boardJpaService.updateIsDelBoardById(id, boardPassword);
    }

    // mission 답글 쓰기를 담당하는 기능 구현.
    @PostMapping(value = "/reply")
    public ApiResponse<BoardDTO> postBoardReplyContent(@RequestBody BoardDTO boardDTO){
        return boardJpaService.postReply(boardDTO);
    }

     */
}

