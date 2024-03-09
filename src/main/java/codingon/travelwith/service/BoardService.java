package codingon.travelwith.service;

import codingon.travelwith.domain.Board;
import codingon.travelwith.domain.Member;
import codingon.travelwith.dto.BoardDTO;
import codingon.travelwith.mapper.BoardMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URLEncoder;

@Service
public class BoardService {

    @Autowired
    private SqlSession ss; // 이 부분은 세션 또는 빈으로 사용할 수 있도록 설정해야 합니다.

    // 전체 글 개수 카운팅
    private int allBoardCount;

    // 서울  글 개수 카운팅
    private int allSeoulCount;

    // 수도권 글 개수 카운팅
    private int allCapCount;

    // 강원도 글 개수 카운팅
    private int allGangCount;

    // 충청도 글 개수 카운팅
    private int allChungCount;

    // 경상도 글 개수 카운팅
    private int allGyeongCount;

    //전라도 글 개수 카운팅
    private int allJeonCount;

    // 제주도 글 개수 카운팅
    private int allJejuCount;

    // 마이페이지 내가 쓴 글 개수 카운팅
    private int allMyPostCount;

    // 마이페이지 내 사진첩 개수 카운팅
    private int allMyPhotoCount;


    public void getBoard(Board board) {
        try {
            BoardMapper mapper = ss.getMapper(BoardMapper.class);
            int result = mapper.writeBoard(board);
            if (result == 1) {
                // 성공적으로 데이터베이스에 저장됨
                System.out.println("게시글 저장 성공");
            } else {
                // 데이터베이스 저장 실패
                System.out.println("게시글 저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void uploadFileToS3Bucket(String bucketName, File file, String fileKey) {
//        amazonS3Client().putObject(new PutObjectRequest(bucketName, fileKey, file));
//    }


}
