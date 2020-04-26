package com.ceramicduck.angryduck.service.board;

import java.util.List;

import com.ceramicduck.angryduck.model.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> listAll(int start, int end, 
			String search_option, String keyword);
	public void insert(BoardDTO dto);
	public BoardDTO getContent(int id);
	public int countArticle(String search_option, String keyword);
}
