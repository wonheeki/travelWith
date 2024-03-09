
-- 회원 테이블
create table tw_member(
   u_id varchar2(30 char) primary key,
   u_pw varchar2(30 char) not null,
   u_nickname varchar2(30 char) not null,
   u_email varchar2(30 char) not null,
   u_addr varchar2(100 char) not null
);


insert into tw_member values('1','1','1','1','1')

select * from TW_MEMBER
-- 게시판 테이블
create table tw_board(
	b_no number(5) primary key,
	b_title varchar2(200 char) not null,
	b_writer varchar2(20 char) not null,
	b_photo varchar2(200 char) not null,
	b_category varchar2(100 char) not null,
	b_txt varchar2(1000 char) not null,
	b_regDate date not null,
	b_readCounter number(5) default 0 not null,

	constraint fk_tw_b_writer foreign key(b_writer) references tw_member(u_id)
	on delete cascade
)
insert into TW_BOARD values(tw_b_no_seq.nextval,'asd','nah0912','asd','서울','ㅁㄴㅇ',sysdate,1 );
select * from tw_board
insert into TW_BOARD values(tw_b_no_seq.nextval,'asdsdasdsadsdsadsad','nah0912','asd','서울','ㅁㄴㅇ',sysdate,1 );
drop table tw_board cascade constraint

alter table tw_board modify b_category varchar2(100 char)

drop sequence tw_b_no_seq;

create sequence tw_b_no_seq;



-- 댓글 테이블
CREATE TABLE tw_comment (
   c_no INT PRIMARY KEY auto_increment, -- 댓글번호
   b_no INT NOT NULL, -- 소속된 글 번호
   c_writer VARCHAR(30) NOT NULL,
   c_regDate DATE NOT NULL,
   c_txt VARCHAR(1000) NOT NULL,
   CONSTRAINT fk_tw_board_replys
       FOREIGN KEY(b_no) REFERENCES tw_board(b_no) ON DELETE CASCADE,
   CONSTRAINT fk_tw_c_writer FOREIGN KEY(c_writer) REFERENCES tw_member(u_id) ON DELETE CASCADE
);
drop table tw_comment cascade constraint purge
create sequence tw_c_no_seq
