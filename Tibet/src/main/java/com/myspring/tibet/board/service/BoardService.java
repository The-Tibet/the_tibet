package com.myspring.tibet.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.board.vo.QnaCommentVO;
import com.myspring.tibet.board.vo.QnaVO;
import com.myspring.tibet.board.vo.ReviewVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.SearchCriteria;

public interface BoardService {
	// 공지사항 목록
	 public int countNoticeList(SearchCriteria scri) throws Exception; 
	// 공지사항 페이징
	public List<NoticeVO> selectAllNoticesList(SearchCriteria scri) throws Exception;
	// QNA 목록
	 public int countQnaList(SearchCriteria scri) throws Exception; 
	// QNA 페이징
	public List<QnaVO> selectQnaList(SearchCriteria scri) throws Exception;
	
	public void insertQnaWritePage(QnaVO qnaVO) throws Exception;
	public NoticeVO noticeDetail(Integer notice_num) throws Exception;
	public QnaVO qnaDetail(Integer qna_num) throws Exception;
	public boolean deleteQna(Integer qna_num) throws Exception;
	public List<QnaVO> listProdQnas(String product_num) throws Exception;
	public List<ReviewVO> listProdReviews(String product_num) throws Exception;
	public int modifyQna(QnaVO qnaVO);
	public QnaCommentVO qnaDetailComment(Integer qna_num) throws Exception;
}
