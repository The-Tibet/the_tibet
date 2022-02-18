package com.myspring.tibet.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.tibet.board.dao.BoardDAO;
import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.board.vo.QnaCommentVO;
import com.myspring.tibet.board.vo.QnaVO;
import com.myspring.tibet.board.vo.ReviewVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.SearchCriteria;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;
	
	// 공지사항 페이징
	@Override
    public  List<NoticeVO> selectAllNoticesList(SearchCriteria scri) throws Exception {
	    return boardDAO.selectAllNoticesList(scri);
	}
	// 공지사항 목록
	@Override
	public int countNoticeList(SearchCriteria scri) throws Exception{
	    return boardDAO.countNoticeList(scri);
	}
	// QNA 페이징
	@Override
    public  List<QnaVO> selectAllQnasList(Criteria cri) throws Exception {
	    return boardDAO.selectAllQnasList(cri);
	}
	// QNA 목록
	@Override
	public int countQnaList() throws Exception{
	    return boardDAO.countQnaList();
	}
	@Override
	public void insertQnaWritePage(QnaVO qnaVO) throws Exception{
		boardDAO.insertQnaWritePage(qnaVO);
	}
	
	@Override
	public NoticeVO noticeDetail(Integer notice_num) throws Exception {
		return boardDAO.noticeDetail(notice_num);
	}

	@Override
	public QnaVO qnaDetail(Integer qna_num) throws Exception {
		return boardDAO.qnaDetail(qna_num);
	}
	
	@Override
	public QnaCommentVO qnaDetailComment(Integer qna_num) throws Exception {
		return boardDAO.qnaDetailComment(qna_num);
	}
	
	@Override
	public int modifyQna(QnaVO qnaVO) {
		return boardDAO.modifyQna(qnaVO);
	}
	
	@Override
	public boolean deleteQna(Integer qna_num) throws Exception {
		return boardDAO.deleteQna(qna_num);
	}
	
	@Override
	public List<QnaVO> listProdQnas(String product_num) throws Exception{
		List<QnaVO> prodQnasList = boardDAO.selectProdQnasList(product_num);
		return prodQnasList;
	}
	
	@Override
	public List<ReviewVO> listProdReviews(String product_num) throws Exception {
		List<ReviewVO> prodReviewsList = boardDAO.selectProdReviewsList(product_num);
		return prodReviewsList;
	}
}
