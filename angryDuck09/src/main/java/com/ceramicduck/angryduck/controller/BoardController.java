package com.ceramicduck.angryduck.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ceramicduck.angryduck.model.dto.BoardDTO;
import com.ceramicduck.angryduck.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("write")
	public String write() {	
		return "board/write";
	}
	@RequestMapping("insert")
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session) {
		int writer_id = (int)session.getAttribute("id");
		dto.setWriter_id(writer_id);
		boardService.insert(dto);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/content/{id}")
	public ModelAndView content(@PathVariable("id") int id, ModelAndView mav) {
		BoardDTO dto = boardService.getContent(id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("dto",dto);
		mav.addObject("map",map);
		mav.setViewName("board/content");
		
		return mav;
	}
}
