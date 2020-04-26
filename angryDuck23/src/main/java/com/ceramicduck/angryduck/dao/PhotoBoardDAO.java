package com.ceramicduck.angryduck.dao;

import java.util.List;

import com.ceramicduck.angryduck.dto.AccountDTO;
import com.ceramicduck.angryduck.dto.InstrumentDTO;
import com.ceramicduck.angryduck.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.dto.TagDTO;

public interface PhotoBoardDAO {
	//list 페이지 출력
	public List<PhotoBoardDTO> listAll(int start, int end, String searchOption, String keyword);
	//concert 추가
	public void insert(PhotoBoardDTO dto);
	//content 페이지 출력
	public PhotoBoardDTO getView(int id);
	//view count 증가
	public void increaseViewcnt(int id);
	//keyword에 해당하는 concert 갯수
	public int countArticle(String searchOption, String keyword);
	//writerId로 concertId 얻어오기
	public int getId(int writerId);
	//concert_instrument 추가
	public void insertConcertInstrument(int concertId, String[] instrument);
	//concert_tag 추가
	public void insertConcertTag(int concertId, String[] tag);
	//concert의 instrument얻어오기
	public List<InstrumentDTO> getConcertInstrument(int id);
	//concert의 tag얻어오기
	public List<TagDTO> getConcertTag(int id);
	//공지 가져오기
	public PhotoBoardDTO getNotice(int id);
	//한 writer가 올린 모집공고 가져오기
	public List<Integer> getAllId(int writerId);
	//concert_performer 추가
	public void insertApply(int accountId, int concertId, double preference);
	//concert관련 table delete
	void deleteConcert(int concertId);
	public List<PhotoBoardDTO> getRecommend(int index);
}
