package com.ceramicduck.angryduck.model.dao;

import java.util.List;

import com.ceramicduck.angryduck.model.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> listAll(int start, int end, 
			String search_option, String keyword);
	
	public void insert(BoardDTO dto);
	public BoardDTO getContent(int id);
	public int countArticle(String search_option, String keyword);
}
