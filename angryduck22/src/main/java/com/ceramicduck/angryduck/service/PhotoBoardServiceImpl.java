package com.ceramicduck.angryduck.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceramicduck.angryduck.dao.AccountDAO;
import com.ceramicduck.angryduck.dao.AccountDAOImpl;
import com.ceramicduck.angryduck.dao.PhotoBoardDAO;
import com.ceramicduck.angryduck.dto.AccountDTO;
import com.ceramicduck.angryduck.dto.InstrumentDTO;
import com.ceramicduck.angryduck.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.dto.TagDTO;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {
	@Inject
	PhotoBoardDAO photoBoardDao;
	
	@Inject
	AccountDAO accountDao;
	
	final Logger logger = LoggerFactory.getLogger(PhotoBoardServiceImpl.class);
	
	@Override
	public List<PhotoBoardDTO> listAll(int start, int end, String searchOption, String keyword){
		return photoBoardDao.listAll(start, end, searchOption, keyword);
	}
	
	@Override
	public void insert(PhotoBoardDTO dto) {
		photoBoardDao.insert(dto);
	}
	
	@Override
	public PhotoBoardDTO getView(int id) {
		PhotoBoardDTO dto = photoBoardDao.getView(id);
		dto.setInstruments((ArrayList<InstrumentDTO>) photoBoardDao.getConcertInstrument(id));
		dto.setTags((ArrayList<TagDTO>) photoBoardDao.getConcertTag(id));
		return dto;
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) {
		return photoBoardDao.countArticle(searchOption,keyword);
	}
	
	@Override
	public int getId(int writerId) {
		return photoBoardDao.getId(writerId);
	}
	
	@Override
	public void insertConcertInstrument(int concertId, String[] instrument) {
		photoBoardDao.insertConcertInstrument(concertId, instrument);
		
	}
	
	@Override
	public void insertConcertTag(int concertId, String[] tag) {
		photoBoardDao.insertConcertTag(concertId, tag);
	}
	
	@Override
	public void increaseViewcnt(int id) {
		photoBoardDao.increaseViewcnt(id);
	}
	
	@Override
	public PhotoBoardDTO getNotice(int id) {
		return photoBoardDao.getNotice(id);
	}
	
	@Override
	public void insertApply(int accountId, int concertId) {
		double preference = 0;
		PhotoBoardDTO dto1 = getView(concertId);
		AccountDTO dto2 = accountDao.getAccount(accountId);
		preference += dto1.getViewcnt()%3;
		preference += dto1.getId()%1;
		preference += dto2.getId()%1;
		preference += dto2.getAge()%1;
		
		List<InstrumentDTO> accountInstrument  = accountDao.getAccountInstrument(accountId);
		List<TagDTO> accountTag = accountDao.getAccountTag(accountId);
		List<InstrumentDTO> concertInstrument = photoBoardDao.getConcertInstrument(concertId);
		List<TagDTO> concertTag =photoBoardDao.getConcertTag(concertId);
		for(InstrumentDTO ins1 : accountInstrument) {
			for(InstrumentDTO ins2 : concertInstrument) {
				if(ins1.getId()==ins2.getId()) {
					preference += 20;
				}
			}
		}
		for(TagDTO t1 : accountTag) {
			for(TagDTO t2 : concertTag) {
				if(t1.getId()==t2.getId()) {
					preference += 5;
				}
			}
		}
		
		photoBoardDao.insertApply(accountId,concertId,preference);
	}
	
	@Override
	public List<AccountDTO> getApplicants(int concertId) {
		List<AccountDTO> applicants = accountDao.getApplicants(concertId);
		for(int i=0; i<applicants.size(); i++) {
			AccountDTO dto = applicants.get(i);
			int accountId = dto.getId();
			dto.setInstruments((ArrayList<InstrumentDTO>) accountDao.getAccountInstrument(accountId));
			dto.setTags((ArrayList<TagDTO>) accountDao.getAccountTag(accountId));
		}
		return applicants;
	}
	
	@Override
	public void deleteConcert(int concertId) {
		photoBoardDao.deleteConcert(concertId);
	}

}
