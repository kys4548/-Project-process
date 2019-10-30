package com.ceramicduck.angryduck.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceramicduck.angryduck.model.dao.AccountDAO;
import com.ceramicduck.angryduck.model.dto.AccountDTO;

@Service
public class AccountServiceImpl implements AccountService {
	@Inject
	AccountDAO accountDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Override
	public void insert(AccountDTO dto) {
		accountDao.insert(dto);
	}
	
	@Override
	public String emailDoubleCheck(String email) {
		String checkEmail =  accountDao.emailDoubleCheck(email);
		
		if(checkEmail != null) //아이디가 중복일 경우
			return "emailFail";
		else //중복이 아닌경우
			return "emailSuccess";
	}
	@Override
	public int getID(String email) {
		return accountDao.getID(email);
	}

	@Override
	public void accountInstrument(int accountID, String[] instrument) {
		accountDao.accountInstrument(accountID, instrument);
	}

	@Override
	public void accountTag(int accountID, String[] tag) {
		accountDao.accountTag(accountID, tag);
	}
	
}
