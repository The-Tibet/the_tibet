package com.myspring.tibet.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.board.vo.QnaCommentVO;
import com.myspring.tibet.board.vo.QnaVO;
import com.myspring.tibet.board.vo.ReviewVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.SearchCriteria;

public interface BoardDAO {
	
	// 공지사항 페이징
    public  List<NoticeVO> selectAllNoticesList(SearchCriteria scri) throws Exception;
	// 공지사항 목록
	public int countNoticeList(SearchCriteria scri) throws Exception;
	// QNA 페이징
	public List<QnaVO>selectAllQnasList(Criteria cri) throws Exception;
	// QNA 목록
	public int countQnaList()throws Exception;	
	
	public void insertQnaWritePage(QnaVO qnaVO) throws DataAccessException;
	public void insertNoticeWritePage(NoticeVO noticeVO) throws DataAccessException;
	public NoticeVO noticeDetail(Integer notice_num);
	public QnaVO qnaDetail(Integer qna_num);
	public boolean deleteQna(Integer qna_num);
	public List<QnaVO> selectProdQnasList(String product_num) throws DataAccessException;
	public List<ReviewVO> selectProdReviewsList(String product_num) throws DataAccessException;
	public int modifyQna(QnaVO qnaVO);
	public QnaCommentVO qnaDetailComment(Integer qna_num);
}
