package com.myspring.tibet.admin.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.tibet.board.dao.BoardDAOImpl;
import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.utils.Criteria;

@Repository("adminBoardDAO")
public class AdminBoardDAOImpl  implements AdminBoardDAO {
	@Inject
    private SqlSession sqlSession;
	protected Log log = LogFactory.getLog(BoardDAOImpl.class);

	protected void printQueryId(String queryId) {
		if (log.isDebugEnabled()) {
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	@SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.selectList(queryId,params);
    }
	
	// 공지사항 글쓰기
	@Override
	public void insertNoticeWritePage(NoticeVO noticeVO) throws DataAccessException{
		sqlSession.insert("mapper.admin.board.insertNoticeWritePage", noticeVO);
	}
	
	// 공지사항 상세
	@Override
	public NoticeVO adminnoticeDetail(Integer notice_num) {
		return sqlSession.selectOne("mapper.admin.board.adminnoticeDetail",notice_num);
	}
	
	// 공지사항 수정
	@Override
	public Integer modifynotice(Integer notice_num) {
		return sqlSession.update("mapper.admin.board.noticemodify", notice_num);
	} 
	
	// 공지사항 선택사제
	@Override
	public void noticedelete(String notice_num) {
		sqlSession.delete("mapper.admin.board.noticedelete", notice_num);
	}
	
	// 공지사항 페이징
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectNoticeList(Criteria cri) {
		return (List<Map<String,Object>>)selectList("mapper.admin.board.selectAllNoticesList", cri);
	}
	
	// 공지사항 리스트
	@Override
	public int countNoticeList(){
	    return (Integer) sqlSession.selectOne("mapper.admin.board.countNoticeList");
	}
}
