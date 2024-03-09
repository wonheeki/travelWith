package codingon.travelwith.controller;

import codingon.travelwith.domain.Member;
import codingon.travelwith.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @GetMapping("/login.go")
    public String goLogin(){
        return "member/signin";
    }

    @GetMapping("/register.go")
    public String goRegister(){
        return "member/signup";
    }



    // 회원가입
    @PostMapping("/member.signup")
    public String joinMember(Member m, HttpServletRequest req) {
        ms.join(m, req);
        return "home";
    }

    // 아이디 중복체크
    @ResponseBody
    @GetMapping("/member.id.check")
    public Member memberIdCheck(Member m, HttpServletRequest req) {
        return ms.memberIdCheck(m);
    }

    // 닉네임 중복체크
    @ResponseBody
    @GetMapping("/member.nickname.check")
    public Member memberNicknameCheck(Member m, HttpServletRequest req) {
        return ms.memberNicknameCheck(m);
    }

    // 로그아웃
    @GetMapping("/member.logout")
    public String logoutMember(HttpServletRequest req) {
        ms.logout(req);
        return "home";
    }

    // 로그인
    @PostMapping("/member.login")
    public String loginMember(Member m, HttpServletRequest req) {
        ms.login(m, req);
        return "member/result";
    }

    // 아이디 찾기 페이지로 이동
    @GetMapping("/member.findID")
    public String findID(Member m, HttpServletRequest req) {
//        ms.join(m, req);
        return "member/findID";
    }

    // 비밀번호 찾기 페이지로 이동
    @GetMapping("/member.findPW")
    public String findPW(Member m, HttpServletRequest req) {
//        ms.join(m, req);
        return "member/findPW";
    }

    // 아이디 찾기 페이지에서 result페이지로 이동
    @GetMapping("/member.goResultID")
    public String goResultID(Member m, HttpServletRequest req) {
        ms.findMemberID(m, req);
        return "member/result";
    }

    // 비밀번호 찾기 페이지에서 result페이지로 이동
    @PostMapping("/member.goResultPW")
    public String goResultPW(Member m, HttpServletRequest req) {
        ms.findMemberPW(m, req);
        return "member/result";
    }

    //회원정보 수정페이지로 이동
    @GetMapping("/mypage.update.go")
    public String memberUpdateGo(Member m, HttpServletRequest req, Model model) {
        Member loginMember = (Member) req.getSession().getAttribute("loginMember");
        model.addAttribute("loginMember",loginMember);
        ms.dividAddr(m,req);
        return "member/myInfo";
    }


    // 회원 정보 수정
    @PostMapping("/member.update")
    public String memberUpdate(Member m, HttpServletRequest req) {
        ms.update(m, req);
        return "home";
    }

    // 회원 탈퇴
    @GetMapping("/member.resign")
    public String memberResign(HttpServletRequest req) {
        ms.delete(req);
        return "home";
    }

}
