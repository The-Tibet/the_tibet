package com.myspring.tibet.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.board.vo.QnaCommentVO;
import com.myspring.tibet.board.vo.QnaVO;
import com.myspring.tibet.board.vo.ReviewVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.SearchCriteria;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Inject
    private SqlSession sqlSession;



	@Override
	public void insertQnaWritePage(QnaVO _qnaVO) throws DataAccessException{
		sqlSession.insert("mapper.board.insertQnaWritePage", _qnaVO);

	}
	// 공지사항 페이징
	@Override
	public List<NoticeVO> selectAllNoticesList(SearchCriteria scri) throws Exception {
		return sqlSession.selectList("mapper.board.selectAllNoticesList", scri);
	}
	// 공지사항 목록
	@Override
	public int countNoticeList(SearchCriteria scri) throws Exception {
	    return sqlSession.selectOne("mapper.board.countNoticeList");
	}
	
	// QNA 페이징
	@Override
	public List<QnaVO> selectAllQnasList(Criteria cri) throws Exception {
		return sqlSession.selectList("mapper.board.selectAllQnasList", cri);
	}
	
	// QNA 목록
	@Override
	public int countQnaList(){
	    return sqlSession.selectOne("mapper.board.countQnaList");
	}
	
	@Override
	public void insertNoticeWritePage(NoticeVO noticeVO) throws DataAccessException{
		sqlSession.insert("mapper.board.insertNoticeWritePage", noticeVO);
	}

	@Override
	public NoticeVO noticeDetail(Integer notice_num) {
		return sqlSession.selectOne("mapper.board.noticeDetail",notice_num);
	}
	
	@Override
	public QnaVO qnaDetail(Integer qna_num) {
		return sqlSession.selectOne("mapper.board.qnaDetail",qna_num);
	}
	
	@Override
	public QnaCommentVO qnaDetailComment(Integer qna_num) {
		return sqlSession.selectOne("mapper.board.qnaDetailComment",qna_num);
	}
	
	@Override
	public int modifyQna(QnaVO qnaVO) {
		return sqlSession.update("mapper.board.modifyQna", qnaVO);
	}
	
	@Override
	public boolean deleteQna(Integer qna_num) {
		sqlSession.delete("mapper.board.deleteQna",qna_num);
		return true;
	}
	
	@Override
	public List<QnaVO> selectProdQnasList(String product_num) throws DataAccessException {
		List<QnaVO> prodQnasList = sqlSession.selectList("mapper.board.selectProdQnasList", product_num);
		return prodQnasList;
	}
	
	@Override
	public List<ReviewVO> selectProdReviewsList(String product_num) throws DataAccessException {
		List<ReviewVO> prodReviewsList = sqlSession.selectList("mapper.board.selectProdReviewsList", product_num);
		return prodReviewsList;
	}
}
