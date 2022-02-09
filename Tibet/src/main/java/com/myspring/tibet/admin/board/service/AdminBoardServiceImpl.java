package com.myspring.tibet.admin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.tibet.admin.board.dao.AdminBoardDAO;
import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.utils.SearchCriteria;

@Service("adminBoardService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminBoardServiceImpl implements AdminBoardSerivce {
	@Autowired
	AdminBoardDAO adminBoardDAO;
	
	// 공지사항 글쓰기
	public void insertNoticeWritePage(NoticeVO noticeVO) throws Exception{
	  adminBoardDAO.insertNoticeWritePage(noticeVO);
	}
	
	// 공지사항 상세
	@Override
	public NoticeVO adminnoticeDetail(Integer notice_num) throws Exception {
		return adminBoardDAO.adminnoticeDetail(notice_num);
	}
	
	// 공지사항 수정
	@Override
	public int modifynotice(NoticeVO noticeVO) {
		return adminBoardDAO.modifynotice(noticeVO);
	}
	
	// 공지사항 선택삭제
	@Override
	public void noticedelete(String notice_num) {
		 adminBoardDAO.noticedelete(notice_num);
	}
	
	// 공지사항 페이징
	@Override
    public  List<NoticeVO> selectAllNoticesList(SearchCriteria scri) throws Exception {
	    return adminBoardDAO.selectAllNoticesList(scri);
	}
	
	// 공지사항 목록
	@Override
	public int countNoticeListTotal(SearchCriteria scri) throws Exception{
	    return adminBoardDAO.countNoticeList(scri);
	}
}
