package com.myspring.tibet.admin.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.tibet.admin.member.dao.AdminMemberDAO;
import com.myspring.tibet.member.vo.MemberVO;
import com.myspring.tibet.utils.Criteria;

@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService {
	@Autowired
	AdminMemberDAO adminMemberDAO;

	// 회원관리 페이징
	@Override
	public List<Map<String, Object>> selectAllmemberList(Criteria cri) {
		return adminMemberDAO.selectAllmemberList(cri);
	}
	
	// 회원 목록
	@Override
	public int countMemberList() {
		return adminMemberDAO.countMemberList();
	}
	
	// 회원 강제탈퇴
	@Override
	public void memberDelete(String user_id) {
		adminMemberDAO.memberDelete(user_id);
	}

	// 공지사항 수정화면
	@Override 
	public MemberVO adminmodifyMemberForm(String user_id) throws Exception {
		return adminMemberDAO.adminmodifyMemberForm(user_id); 
	}
	
	// 공지사항 수정기능
	@Override
	public int adminmodifyMember(MemberVO vo) throws Exception {
		return adminMemberDAO.adminmodifyMember(vo);
	}
}

