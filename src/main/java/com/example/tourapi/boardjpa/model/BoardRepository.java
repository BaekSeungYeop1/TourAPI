package com.example.tourapi.boardjpa.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findBoardsByIsDel(String isDel);

    Board findBoardByIdAndIsDel(int Id, String isDel);

    // 최고 Id값을 가진 Board 엔터티를 가져옴
    Board findTopByOrderByIdDesc();

    Optional<Board> findBoardById(int id);

    @Query("Select b.author From Board b Where b.id = ?1")
    String getAuthorById(int id);




    /*List<Board> findAll();

    Board findBoardById(Integer id);
    Optional<Board> findBoardById(int id);

    // Page<Board> findBoardsByIsDel(String isDel, Pageable pageable);

    // JPQL != SQL
    @Query("Select b FROM Board b where b.id = ?1") // JPA를 이용하여 JPQL만든 후 쿼리를 날린다.
    Board selectBoard(int id);


    @Query("SELECT MIN(b.orderNum) FROM Board b" +
            "                WHERE  b.replyRootId = ?1" +
            "                AND b.orderNum > ?3" +
            "                AND b.depth <= ?2")
    Integer getMinOrderNum(int replyRootId, int depth, int orderNum);

    @Query("SELECT MAX(orderNum) + 1 FROM Board" +
            " WHERE replyRootId = ?1")
    Integer getReplyOrderNum(int replyRootId);

    @Modifying
    @Query("UPDATE Board SET orderNum = orderNum + 1" +
            "                WHERE replyRootId = ?1  AND orderNum >= ?2")
    void updateOrderNum(int replyRootId, int minOrderNum);

    // 최고 Id값을 가진 Board 엔터티를 가져옴
    Board findTopByOrderByIdDesc();

    Page<Board> findBoardsByIsDelOrderByReplyRootIdDescOrderNumAsc(String isDel, Pageable pageable);*/


}
