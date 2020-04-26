package com.ceramicduck.angryduck.model.dao;

import com.ceramicduck.angryduck.model.dto.AccountDTO;

public interface AccountDAO {
	public String emailDoubleCheck(String email);
	public void insert(AccountDTO dto);
	public int getID(String email);
	public void accountInstrument(int accountId, String[] instrument);
	public void accountTag(int accountId, String[] tag);
	public AccountDTO loginCheck(AccountDTO dto);
	public void deleteAccountInstrument(int accountId);
	public void deleteAccountTag(int accountId);
	public void delete(int accountId);
	
}
