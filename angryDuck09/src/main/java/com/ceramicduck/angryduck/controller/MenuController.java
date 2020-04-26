package com.ceramicduck.angryduck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ceramicduck.angryduck.model.dto.BoardDTO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.service.board.BoardService;
import com.ceramicduck.angryduck.service.photo_board.Pager;
import com.ceramicduck.angryduck.service.photo_board.PhotoBoardService;

@Controller
public class MenuController {
	
	@Inject
	PhotoBoardService photo_boardService;
	
	@Inject
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
	
	/*
	 * @RequestMapping(value = "/join", method = RequestMethod.GET) public String
	 * join(Locale locale, Model model) { return "member/join"; }
	 */
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		return "about/about";
	}
	
	@RequestMapping(value = "/photoboard", method = RequestMethod.GET)
	public String photoBoard(@RequestParam(defaultValue="1")int curPage,
			@RequestParam(defaultValue="all")String search_option,
			@RequestParam(defaultValue="")String keyword,
			Locale locale, Model model) {
		
		int count=1000;
		Pager pager = new Pager(count,curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<PhotoBoardDTO> list = photo_boardService.listAll(
				start,end,search_option,keyword);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		model.addAttribute("search_option",search_option);
		model.addAttribute("keyword",keyword);
		model.addAttribute("pager",pager);
		return "photo_board/list";
	}
	
	@RequestMapping(value = "/board")
	public ModelAndView board(@RequestParam(defaultValue="1") int curPage,
	@RequestParam(defaultValue="all") String search_option,
	@RequestParam(defaultValue="") String keyword,ModelAndView mav) {
		
		int count = boardService.countArticle(search_option, keyword);
		Pager pager = new Pager(count,curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		List<BoardDTO> list = boardService.listAll(start,end,search_option,keyword);
		mav.setViewName("board/list");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("count",count);
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		map.put("pager",pager);
		mav.addObject("map",map);
		return mav;
	}
	
	
}
