package com.ceramicduck.angryduck.model.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ceramicduck.angryduck.model.dto.AccountDTO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	@Inject
	SqlSession sqlSession;
	
	final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	
	@Override
	public int getID(String email) {
		return sqlSession.selectOne("account.get_id",email);
	}
	@Override 
	public void insert(AccountDTO dto) {
		sqlSession.insert("account.insert",dto);
	}
	@Override
	public String emailDoubleCheck(String email) {
		
		return sqlSession.selectOne("account.email_double_check",email);
	}
	@Override
	public void accountInstrument(int accountId, String[] instrument) {
		for(int i=0; i<instrument.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("accountID",accountId);
			String inst = instrument[i];
			int instrumentId = sqlSession.selectOne("account.instrument",inst);
			map.put("instrumentID",instrumentId);
			sqlSession.insert("account.account_instrument",map);
		}
	}
	@Override
	public void accountTag(int accountId, String[] tag) {
		for(int i=0; i<tag.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("accountID",accountId);
			String t = tag[i];
			int tagId = sqlSession.selectOne("account.tag", t);
			map.put("tagID", tagId);
			sqlSession.insert("account.account_tag",map);
		}
	}
	@Override
	public AccountDTO loginCheck(AccountDTO dto) {
		return sqlSession.selectOne("account.login_check",dto);
	}
	@Override
	public void deleteAccountInstrument(int accountId) {
		sqlSession.delete("account.delete_account_instrument",accountId);
	}
	@Override
	public void deleteAccountTag(int accountId) {
		sqlSession.delete("account.delete_account_tag",accountId);
	}
	
	@Override 
	public void delete(int accountId) {
		sqlSession.delete("account.delete",accountId); 
	}
	
	
}
