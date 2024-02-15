package com.kitri.myservletboard.dao;

import com.kitri.myservletboard.data.Member;

public interface MemberDao {
    public Member getMember(String id);
    public void addMember(Member member);
    public void updateMember(Member member);
    public void deleteMember(String id);
}
