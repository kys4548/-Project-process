package com.ceramicduck.angryduck.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ceramicduck.angryduck.model.dto.AccountDTO;
import com.ceramicduck.angryduck.service.AccountService;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Inject
	AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping("join")
	public String join() {
		return "account/join";
	}
	
	@RequestMapping("insert")
	public ModelAndView insert(@ModelAttribute AccountDTO dto, @RequestParam("tag") String[] tag
			, @RequestParam("instrument") String[] instrument, ModelAndView mav) {
		
		accountService.insert(dto);
		int accountID = accountService.getID(dto.getEmail());
		accountService.accountInstrument(accountID, instrument);
		accountService.accountTag(accountID,tag);
		
		mav.addObject("message","joinSuccess");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("emailDoubleCheck")
	public ModelAndView emailDoubleCheck(@ModelAttribute AccountDTO dto, ModelAndView mav) {
		//mav에는 값이 하나 밖에 들어가지 못하므로 map을 사용하여 여러가지를 넣고 map을 mav에 넣어준다.
		Map<String, Object> map = new HashMap<String, Object>();
		
		String message = accountService.emailDoubleCheck(dto.getEmail());
		//email이 중복되는지 확인한다.
		//중복시 emailFail, 중복 아닐시 emailSuccess 
		map.put("message",message);
		map.put("dto",dto);
		mav.addObject("map",map);
		mav.setViewName("account/join");
		
		return mav;
		
	}
	
}
