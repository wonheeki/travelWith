package codingon.travelwith.controller;

import codingon.travelwith.domain.Board;
import codingon.travelwith.domain.Member;
import codingon.travelwith.dto.BoardDTO;
import codingon.travelwith.service.BoardService;
import codingon.travelwith.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class BoardController {

    @Autowired
    MemberService ms;

    @Autowired
    BoardService bs;

    @GetMapping("/board.go")
    public String goBoard(Model model, HttpServletRequest req){
        Member loginMember = (Member) req.getSession().getAttribute("loginMember");
        model.addAttribute("loginMember",loginMember);
//        List<Board> boardList = bs.findAll();
//        model.addAttribute("list", boardList);
        return "board/board";
    }

    @GetMapping("/talk.go")
    public String goTalk(){
        return "board/board_talk";
    }

    @GetMapping("/photo.go")
    public String goPhoto(){
        return "board/board_photo";
    }

    // 게시글 작성페이지로 이동
    @GetMapping("/board.write.go")
    public String boardWriteGo(Model model, HttpServletRequest req) {
        Member loginMember = (Member) req.getSession().getAttribute("loginMember");
        model.addAttribute("loginMember",loginMember);
        return "board/board_write";
    }

    // 게시글 작성
//    @PostMapping("/board.write")
//    public String boardWrite(Model model, HttpServletRequest req,
//                             @ModelAttribute Board b, // Board 객체로 텍스트 데이터 바인딩
//                             @RequestParam("b_photo") MultipartFile file) { // 파일 데이터 처리
//        if (ms.loginCheck(req)) {
//            try {
//                // 파일 업로드 및 처리 로직
//                String uploadPath = req.getSession().getServletContext().getRealPath("resources/upload");
//                String originalFilename = file.getOriginalFilename();
//                String fileName = System.currentTimeMillis() + "_" + originalFilename;
//                File uploadFile = new File(uploadPath, fileName);
//                file.transferTo(uploadFile);
//
//                // 파일 경로를 Board 객체에 설정
//                String fileRelativePath = "resources/upload/" + fileName;
//                b.setB_photo(fileRelativePath);
//
//                // Board 객체 및 파일 경로 처리 로직 (예: 데이터베이스 저장)
//                bs.getBoard(b, req); // 수정된 메서드 호출
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return "board/board";
//    }
    @PostMapping("/board.write")
    public String boardWrite(Model model, HttpServletRequest req,
                             @RequestParam("b_title") String title,
                             @RequestParam("b_category") String category,
                             @RequestParam("b_txt") String text,
                             @RequestParam("b_photo") MultipartFile file) {
        try {
            Board b = new Board();
            b.setB_title(title);
            Member loginMember = (Member) req.getSession().getAttribute("loginMember");
            b.setB_writer(loginMember.getU_addr());
            b.setB_category(category);
            b.setB_txt(text);

            if (!file.isEmpty()) {
                // 파일 처리 로직
//                String uploadPath = req.getSession().getServletContext().getRealPath("/uploads");
                String uploadPath="/upload";
                String originalFilename = file.getOriginalFilename();
                String fileName = System.currentTimeMillis() + "_" + originalFilename;
                String fileRelativePath = "/uploads/" + fileName;

                File uploadFile = new File(uploadPath, fileName);
                file.transferTo(uploadFile);

                b.setB_photo(fileRelativePath); // 파일 경로 설정
            }

            if (ms.loginCheck(req)) {
                bs.getBoard(b); // 수정된 서비스 메서드 호출
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return "board/board";
    }



//    // 게시글 상세보기 페이지로 이동
//    @GetMapping(value = "/board.view.go")
//    public String boardView() {
//        return "board/board_view";
//    }
//
//    // 게시글 수정페이지로 이동
//    @GetMapping(value = "/board.update.go")
//    public String boardUpdate() {
//        return "board/board_edit";
//    }
//
//    // 게시판 글 수정
//    @PatchMapping(value = "/board.update")
//    public String boardEdit2() {
//        return "board/board_view";
//    }
//
//    // 게시판 글 삭제
//    @DeleteMapping(value = "/board.delete")
//    public String boardDelete() {
//        return "board/board_view";
//    }
//
//    // 최신순 페이징
////        @RequestMapping(value = "/board.page.change", method = RequestMethod.GET)
////        public String boardPageChange(HttpServletRequest req) {
////            mDAO.loginCheck(req);
////            int p = Integer.parseInt(req.getParameter("p"));
////            bDAO.getMsg(p, req);
////            TokenMaker.makeToken(req);
////            req.setAttribute("cp", "board/board.jsp");
////            return "index";
////        }
//
//
//
//    // 재잘재잘 작성
//    @PostMapping(value = "/board.talk.write")
//    public String talkWrite() {
//        return "board/board_view";
//    }
//
//    // 재잘재잘 글 수정
//    @PatchMapping(value = "/talk.update")
//    public String updateTalk() {
//        return "board/board_view";
//    }
//
//    // 재잘재잘 글 삭제
//    @DeleteMapping(value = "/talk.delete")
//    public String talkDelete() {
//        return "board/board_view";
//    }
//
//    // 재잘재잘 댓글쓰기
//    @PostMapping(value = "/talk.comment.write")
//    public String talkWriteComment() {
//        return "board/board_view";
//    }
//
//    // 재잘재잘 수정
//    @PatchMapping(value = "/talk.comment.update")
//    public String talkUpdateComment() {
//        return "board/board_view";
//    }
//
//    // 재잘재잘 삭제
//    @DeleteMapping(value = "/talk.comment.delete")
//    public String talkDeleteComment() {
//        return "board/board_view";
//    }
//
//
//
//
//    // 댓글쓰기
//    @PostMapping(value = "/board.comment.write")
//    public String writeComment() {
//        return "board/board_view";
//    }
//
//    // 댓글 수정
//    @PatchMapping(value = "/board.comment.update")
//    public String updateComment() {
//        return "board/board_view";
//    }
//
//    // 댓글 삭제
//    @DeleteMapping(value = "/board.comment.delete")
//    public String deleteComment() {
//        return "board/board_view";
//    }
//
//
//
//
//    // 게시글 관리 페이지로 이동
//    @GetMapping(value = "/mypage.post.go")
//    public String mypost() {
//        return "board/board_view";
//    }
//
//    // 사진첩 관리 페이지로 이동
//    @GetMapping(value = "/mypage.photo.go")
//    public String myphoto() {
//        return "board/board_view";
//    }
//
//
}
