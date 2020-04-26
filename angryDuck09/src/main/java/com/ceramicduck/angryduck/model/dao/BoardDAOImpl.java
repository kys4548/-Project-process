package com.ceramicduck.angryduck.model.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ceramicduck.angryduck.model.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int countArticle(String search_option, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		return sqlSession.selectOne("board.countArticle", map);
	}
	@Override
	public List<BoardDTO> listAll(int start, int end, 
			String search_option, String keyword){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		map.put("start",start);
		map.put("end",end);
		return sqlSession.selectList("board.listAll",map);
	}
	
	@Override
	public void insert(BoardDTO dto) {
		sqlSession.insert("board.insert", dto);
		
	}
	
	@Override
	public BoardDTO getContent(int id) {
		return sqlSession.selectOne("board.getContent",id);
		
	}
}
