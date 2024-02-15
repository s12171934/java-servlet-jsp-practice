package com.kitri.myservletboard.service;

import com.kitri.myservletboard.dao.MemberDao;
import com.kitri.myservletboard.dao.MemberJdbc;
import com.kitri.myservletboard.data.Member;

import javax.servlet.http.HttpSession;

public class MemberService {
    private MemberService(){}
    private static MemberService instance = new MemberService();
    public static MemberService getInstance(){return instance;}
    private MemberDao memberDao = MemberJdbc.getInstance();
    public String[] join(Member member){
        if(memberDao.getMember(member.getId()) != null){
            return new String[]{"join.jsp","중복된 아이디 입니다."};
        }
        if(!member.getPassword().equals(member.getPasswordCheck())){
            return new String[]{"join.jsp","비밀번호 확인이 틀렸습니다."};
        }
        memberDao.addMember(member);
        return new String[]{"login.jsp","회원가입이 성공적으로 완료되었습니다"};
    }
    public String[] login(String id, String pw, HttpSession session){
        Member member = memberDao.getMember(id);
        if(member == null){
            return new String[]{"/view/member/login.jsp","아이디가 존재하지 않습니다"};
        }
        if(!member.getPassword().equals(pw)){
            return new String[]{"/view/member/login.jsp","비밀번호가 틀렸습니다."};
        }
        session.setAttribute("member",member);
        return new String[]{"/board/list",member.getName()};
    }

    public String[] registration(Member member, HttpSession session){
        if(!member.getPassword().equals(member.getPasswordCheck())){
            return new String[]{"/view/member/registration.jsp","비밀번호 확인이 틀렸습니다."};
        }
        memberDao.updateMember(member);
        Member sessionMember = (Member)session.getAttribute("member");
        sessionMember.setPassword(member.getPassword());
        sessionMember.setName(member.getName());
        sessionMember.setEmail(member.getEmail());
        session.setAttribute("member",sessionMember);

        return new String[]{"/board/list","회원정보 수정이 성공적으로 완료되었습니다"};
    }

    public void delete(String id){
        memberDao.deleteMember(id);
    }
}
