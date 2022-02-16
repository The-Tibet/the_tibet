package com.myspring.tibet.admin.member.dao;

import java.util.List;
import java.util.Map;

import com.myspring.tibet.member.vo.MemberVO;
import com.myspring.tibet.utils.Criteria;

public interface AdminMemberDAO {
	// 관리자 회원수정
	public int adminMemberUpdate(MemberVO vo) throws Exception;
	// 회원수정 폼
	public MemberVO adminMemberUpdateForm(String user_id);
	// 회원관리 페이징
	public List<Map<String, Object>> selectAllmemberList(Criteria cri);
	// 회원 목록
	public int countMemberList();
	// 회원 강제탈퇴
	public void memberDelete(String user_id);
	
}	
