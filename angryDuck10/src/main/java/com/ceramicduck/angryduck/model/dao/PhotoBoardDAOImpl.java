package com.ceramicduck.angryduck.model.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;

@Repository
public class PhotoBoardDAOImpl implements PhotoBoardDAO {

final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int countArticle(String search_option, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		return sqlSession.selectOne("photoBoard.countArticle", map);
	}
	@Override
	public List<PhotoBoardDTO> listAll(int start, int end, 
			String search_option, String keyword){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		map.put("start",start);
		map.put("end",end);
		return sqlSession.selectList("photoBoard.listAll",map);
	}
	
	@Override
	public void insert(PhotoBoardDTO dto) {
		sqlSession.insert("photoBoard.insert", dto);
		
	}
	
	@Override
	public PhotoBoardDTO getView(int id) {
		return sqlSession.selectOne("photoBoard.getView",id);
		
	}
	
}
