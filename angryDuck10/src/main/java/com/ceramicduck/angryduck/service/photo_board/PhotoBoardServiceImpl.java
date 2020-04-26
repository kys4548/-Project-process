package com.ceramicduck.angryduck.service.photo_board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ceramicduck.angryduck.model.dao.PhotoBoardDAO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.service.board.BoardService;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {
	@Inject
	PhotoBoardDAO photoBoardDao;
	
	@Override
	public List<PhotoBoardDTO> listAll(int start, int end, 
			String search_option, String keyword){
		return photoBoardDao.listAll(start, end, search_option, keyword);
	}
	@Override
	public void insert(PhotoBoardDTO dto) {
		photoBoardDao.insert(dto);
	}
	
	@Override
	public PhotoBoardDTO getView(int id) {
		return photoBoardDao.getView(id);
	}
	@Override
	public int countArticle(String search_option, String keyword) {
		return photoBoardDao.countArticle(search_option,keyword);
	}
}
