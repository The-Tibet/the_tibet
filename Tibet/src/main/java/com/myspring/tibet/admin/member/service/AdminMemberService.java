package com.myspring.tibet.admin.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myspring.tibet.member.vo.MemberVO;
import com.myspring.tibet.utils.Criteria;

@Service("adminMemberService")
public interface AdminMemberService {
	// 관리자 회원수정
	public int adminMemberUpdate(MemberVO vo) throws Exception;
	// 회원 수정폼
	public MemberVO adminMemberUpdateForm(String id) throws Exception;
	// 회원관리 페이징
	public List<Map<String, Object>> selectAllmemberList(Criteria cri);
	// 회원 목록
	public int countMemberList();
	// 회원 강제탈퇴
	public void memberDelete(String user_id);
	
}
