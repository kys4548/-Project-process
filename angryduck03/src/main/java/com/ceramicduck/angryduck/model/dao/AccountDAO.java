package com.ceramicduck.angryduck.model.dao;

import com.ceramicduck.angryduck.model.dto.AccountDTO;

public interface AccountDAO {
	public String emailDoubleCheck(String email);
	public void insert(AccountDTO dto);
	public int getID(String email);
	public void accountInstrument(int accountID, String[] instrument);
	public void accountTag(int accountID, String[] tag);
	
}
