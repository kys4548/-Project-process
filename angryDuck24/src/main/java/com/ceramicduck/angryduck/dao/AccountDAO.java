package com.ceramicduck.angryduck.dao;

import java.util.ArrayList;
import java.util.List;

import com.ceramicduck.angryduck.dto.AccountDTO;
import com.ceramicduck.angryduck.dto.InstrumentDTO;
import com.ceramicduck.angryduck.dto.TagDTO;

public interface AccountDAO {
	//회원가입 관련
	public String emailDoubleCheck(String email); // 이메일 중복 확인
	public void insertAccount(AccountDTO dto); //account table insert
	public int getId(String email); // 회원가입 후 얻은 account_id를 통해 instrument, tag 넣기 위해 사용
	public void insertAccountInstrument(int accountId, String[] instrument); // account_instrument insert
	public void insertAccountTag(int accountId, String[] tag); // account_tag insert
	//로그인 관련
	public AccountDTO loginCheck(AccountDTO dto);
	//회원탈퇴 관련
	public void deleteAll(int accountId); //community, concert 관련 table delete
	public void deleteAccountInstrument(int accountId); // instrument 관련 table delete
	public void deleteAccountTag(int accountId); // tag 관련 table delete
	public void deleteAccount(int accountId); // account 관련 table delete
	//정보수정 관련
	public void updateAccount(AccountDTO dto);
	//사용자 한명 정보 얻어오기
	public AccountDTO getAccount(int accountId);
	public List<InstrumentDTO> getAccountInstrument(int accountId);
	public List<TagDTO> getAccountTag(int accountId);
	//concert에 지원한 사용자 리스트 얻어오기
	public List<AccountDTO> getApplicants(int concertId);
	
}
