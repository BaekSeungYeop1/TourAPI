DROP table IF EXISTS Comment
DROP table IF EXISTS Board

-- 게시글
CREATE TABLE `board` (
                         `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '게시글id',
                         `author`       varchar(200) NOT NULL COMMENT '작성자',
                         `subject`      varchar(300) NOT NULL COMMENT '제목',
                         `content`      varchar(2000) NOT NULL COMMENT '내용',
                         `writeDate`    date NOT NULL COMMENT '작성일',
                         `writeTime`    time NOT NULL COMMENT '작성시각',
                         `readCount`    int(11) NOT NULL COMMENT '조회수',
                         `commentCount` int(11) NOT NULL COMMENT '댓글수',
                         `replyRootId`  int(11) NOT NULL DEFAULT 0,
                         `depth`        int(11) NOT NULL DEFAULT 0,
                         `orderNum`     int(11) NOT NULL DEFAULT 0,
                         `isDel` enum('Y','N') not null default 'N',
                         PRIMARY KEY (`id`)
)

-- 댓글
CREATE TABLE `comment` (
                           `cid` int(11) NOT NULL AUTO_INCREMENT,
                           `id` int(11) NOT NULL COMMENT '게시글id',
                           `author` varchar(200) NOT NULL COMMENT '작성자',
                           `content` varchar(2000) NOT NULL COMMENT '댓글내용',
                           `writeDate` date NOT NULL COMMENT '작성일',
                           `writeTime` time NOT NULL COMMENT '작성시각',
                           PRIMARY KEY (`cid`),
                           KEY `FK_Board_TO_Comment` (`id`),
                           CONSTRAINT `FK_Board_TO_Comment` FOREIGN KEY (`id`) REFERENCES `board` (`id`)
)


    COMMENT '댓글';

-- 댓글 - 관계설정 (1:N)
ALTER TABLE Comment
    ADD CONSTRAINT FK_Board_TO_Comment -- 게시글 -> 댓글
        FOREIGN KEY (
                     id -- 게시글id
            )
            REFERENCES Board ( -- 게시글
                              id -- 게시글id
                );

create table member(
                       id bigint primary key AUTO_INCREMENT,
                       email varchar(300)		NOT NULL,
                       password varchar(3000)	NOT NULL,
                       nickname VARCHAR(300)		NOT NULL
)

