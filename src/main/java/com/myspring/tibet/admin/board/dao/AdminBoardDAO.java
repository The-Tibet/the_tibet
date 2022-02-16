package com.myspring.tibet.admin.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.utils.Criteria;

public interface AdminBoardDAO {
	// 공지사항 글쓰기
	public void insertNoticeWritePage(NoticeVO noticeVO) throws DataAccessException;
	// 공지사항 상세
	public NoticeVO adminnoticeDetail(Integer notice_num);
	// 공지사항 수정
	public Integer modifynotice(Integer notice_num);
	// 공지사항 삭제
    public void noticedelete(String notice_num); 
	// 공지사항 페이징
	public List<Map<String, Object>> selectNoticeList(Criteria cri);
	// 공지사항 목록
	public int countNoticeList();
}
