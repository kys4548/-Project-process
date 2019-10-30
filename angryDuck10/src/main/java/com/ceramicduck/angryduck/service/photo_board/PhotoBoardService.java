package com.ceramicduck.angryduck.service.photo_board;

import java.util.List;

import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;

public interface PhotoBoardService {
	public List<PhotoBoardDTO> listAll(int start, int end, 
			String search_option, String keyword);
	public void insert(PhotoBoardDTO dto);
	public PhotoBoardDTO getView(int id);
	public int countArticle(String search_option, String keyword);
}
