package com.ceramicduck.angryduck.service;

import com.ceramicduck.angryduck.model.dto.AccountDTO;

public interface AccountService {
	public String emailDoubleCheck(String email);
	public void insert(AccountDTO dto);
	public int getID(String email);
	public void accountInstrument(int accountID, String[] instrument);
	public void accountTag(int accountID, String[] tag);
}
