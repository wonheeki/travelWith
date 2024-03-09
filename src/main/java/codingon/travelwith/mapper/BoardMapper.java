package codingon.travelwith.mapper;

import codingon.travelwith.domain.Board;
import codingon.travelwith.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public abstract int getAllBoardCount();

    public abstract int getSeoulCount();

    public abstract int getCapCount();

    public abstract int getGangCount();

    public abstract int getChungCount();

    public abstract int getGyeongCount();

    public abstract int getJeonCount();

    public abstract int getJejuCount();

    public abstract int getMyPostCount(Board b);

    public abstract int getMyPhotoCount(Board b);


    // 게시글 조회수 카운팅
    public abstract int readCounterBoard(Board b);

    // 최신순으로 정렬해서 게시글 전부 불러오기
    public abstract List<Board> getBoard(Board b);

	/*// 선택한 게시글 불러오기
	public abstract Board DetailBoard(Board b);*/

    // 서울 게시글 불러오기
    public abstract List<Board> getAllSeoul(Board b);

    // 수도권 게시글 불러오기
    public abstract List<Board> getAllCap(Board b);

    // 강원도 게시글 불러오기
    public abstract List<Board> getAllGang(Board b);

    // 충청도 게시글 불러오기
    public abstract List<Board> getAllChung(Board b);

    // 경상도 게시글 불러오기
    public abstract List<Board> getAllGyeong(Board b);

    // 전라도 게시글 불러오기
    public abstract List<Board> getAllJeon(Board b);

    // 제주도 게시글 불러오기
    public abstract List<Board> getAllJeju(Board b);

    // 사진첩 게시글 불러오기
    public abstract List<Board> getAllPhoto(Board b);

    // 선택한 게시글 상세보기
    public abstract List<Board> getAllBoard(Board b);

    // 게시글 작성
    public abstract int writeBoard(Board b);

    // 게시글 수정
    public abstract int updateBoard(Board b);

    // 게시글 삭제
    public abstract int deleteBoard(Board b);





    // 재잘재잘 게시글 불러오기
    public abstract List<Board> getAllTalk(Board b);

    // 재잘재잘 작성
    public abstract int writeTalk(Board b);

    // 재잘재잘 수정
    public abstract int updateTalk(Board b);





    // 댓글쓰기
    public abstract int writeComment(Comment c);

    // 댓글삭제
    public abstract int deleteComment(Comment c);

    // 댓글수정
    public abstract int updateComment(Comment c);

    // 댓글 불러오기
    public abstract List<Comment> getComment(Board boards);





    // 마이페이지 내가 쓴 글 보기
    public abstract List<Board> getMyBoard(Board b);

    // 마이페이지 사진첩 보기
    public abstract List<Board> getMyPhoto(Board b);
}
