package codingon.travelwith.mapper;

import codingon.travelwith.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper{
    public abstract int signMember(Member m); //회원가입
    public abstract List<Member> getMemberById(Member m); // 아이디 중복체크에 사용,로그인에 사용
    public abstract List<Member> getMemberByNickname(Member m); // 닉네임 중복체크에 사용
    public abstract List<Member> findMemberID(Member m); // 아이디 찾기
    public abstract List<Member> findMemberPW(Member m); // 비밀번호 찾기
    public abstract int updateMember(Member m); // 회원정보 수정
    public abstract int deleteMember(Member m);// 회원 탈퇴
}
