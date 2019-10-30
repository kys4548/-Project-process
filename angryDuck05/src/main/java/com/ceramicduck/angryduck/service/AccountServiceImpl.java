package com.ceramicduck.angryduck.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceramicduck.angryduck.model.dao.AccountDAO;
import com.ceramicduck.angryduck.model.dto.AccountDTO;

/**
 * @author a
 *
 */
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
	public void accountInstrument(int accountId, String[] instrument) {
		accountDao.accountInstrument(accountId, instrument);
	}

	@Override
	public void accountTag(int accountId, String[] tag) {
		accountDao.accountTag(accountId, tag);
	}

	@Override
	public String loginCheck(AccountDTO dto, HttpSession session) {
		AccountDTO tempdto = accountDao.loginCheck(dto);
		String message;
		if(tempdto !=null) { //로그인 성공
			session.setAttribute("name",tempdto.getName());
			session.setAttribute("id",tempdto.getId());
			message = "loginSuccess";
		}
		else { // 로그인 실패
			message = "loginFail";
		}
		return message;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public void delete(HttpSession session) {
		int accountId = (int)session.getAttribute("id"); 
		accountDao.deleteAccountInstrument(accountId);
		accountDao.deleteAccountTag(accountId);
		accountDao.delete(accountId);
		session.invalidate();
	}
	
}
