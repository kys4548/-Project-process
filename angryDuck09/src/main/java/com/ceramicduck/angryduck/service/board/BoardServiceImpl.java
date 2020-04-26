package com.ceramicduck.angryduck.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ceramicduck.angryduck.model.dao.BoardDAO;
import com.ceramicduck.angryduck.model.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> listAll(int start, int end, 
			String search_option, String keyword){
		return boardDao.listAll(start, end, search_option, keyword);
	}
	@Override
	public void insert(BoardDTO dto) {
		boardDao.insert(dto);
	}
	
	@Override
	public BoardDTO getContent(int id) {
		return boardDao.getContent(id);
	}
	@Override
	public int countArticle(String search_option, String keyword) {
		return boardDao.countArticle(search_option,keyword);
	}
}
