package codingon.travelwith.controller;

import codingon.travelwith.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main(Model model , HttpServletRequest req){
        Member loginMember = (Member) req.getSession().getAttribute("loginMember");
//        System.out.println("로그인된 사용자 ID: " + loginMember);
        model.addAttribute("loginMember",loginMember);
        return "home";
    }
    @GetMapping("/home.go")
    public String goHome(Model model , HttpServletRequest req){
        Member loginMember = (Member) req.getSession().getAttribute("loginMember");
//        System.out.println("로그인된 사용자 ID: " + loginMember.getU_id());
        model.addAttribute("loginMember",loginMember);
        return "home";
    }
}
