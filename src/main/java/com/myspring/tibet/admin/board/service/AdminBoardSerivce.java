package com.myspring.tibet.admin.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.utils.Criteria;

public interface AdminBoardSerivce {
	// 공지사항 글쓰기
	public void insertNoticeWritePage(NoticeVO noticeVO) throws Exception;
	// 공지사항 상세
	public NoticeVO adminnoticeDetail(Integer notice_num) throws Exception;
	// 공지사항 수정
	public Integer noticeModify(Integer notice_num) throws Exception;
	// 공지사항 선택삭제
	public void noticedelete(String notice_num);
	// 공지사항 선택
	 public int countNoticeListTotal(); 
	// 공지사항 리스트
	public List<Map<String, Object>> selectNoticeList(Criteria cri);
}
