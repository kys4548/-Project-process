package com.ceramicduck.angryduck.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ceramicduck.angryduck.model.dto.AccountDTO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.service.photo_board.PhotoBoardService;

@Controller
@RequestMapping("/photo_board/*")
public class PhotoBoardController {

	@Inject
	PhotoBoardService photoBoardService;
	
	@RequestMapping("write")
	public String write() {	
		return "photo_board/write";
	}
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoBoardController.class);
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute PhotoBoardDTO dto,@RequestParam("tag") String[] tag
			, @RequestParam("instrument") String[] instrument, HttpSession session) {
		String filename="-";
		if(!dto.getFile1().isEmpty()) {
			filename = dto.getFile1().getOriginalFilename();
			String path1 = "C:\\Users\\a\\Desktop\\project\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\angryDuck\\resources\\images\\";
			String path2 = "C:\\Users\\a\\Desktop\\project\\workspace\\angryDuck\\resources\\images\\";
			try {
				new File(path1).mkdir();
				dto.getFile1().transferTo(new File(path1+filename));
				new File(path2).mkdir();
				dto.getFile1().transferTo(new File(path2+filename));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setImage(filename);
		int writer_id = (int)session.getAttribute("id");
		dto.setWriter_id(writer_id);
		photoBoardService.insert(dto);
		
		int concert_id = photoBoardService.getId(writer_id);
		
		photoBoardService.insertConcertInstrument(concert_id, instrument);
		photoBoardService.insertConcertTag(concert_id,tag);
		
		
		return "redirect:/photoboard";
	}
	
	@RequestMapping("view")
	public ModelAndView view(@RequestParam int id,
			@RequestParam int curPage,
			@RequestParam String search_option,
			@RequestParam String keyword, HttpSession session, ModelAndView mav) {
		photoBoardService.increaseViewcnt(id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		mav.setViewName("photo_board/content");
		map.put("dto",photoBoardService.getView(id));
		map.put("curPage",curPage);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.addObject("map",map);
		
		return mav;
	}
	
	@RequestMapping("insertApply")
	@ResponseBody
	public void insertApply(@RequestParam("concert_id") int concert_id,
			HttpSession session) {
		int account_id = (int)session.getAttribute("id");
		photoBoardService.insertApply(account_id,concert_id);
	}
	
	@RequestMapping("viewApplicants")
	public ModelAndView viewApplicants(@RequestParam("id") int concert_id, HttpSession session, ModelAndView mav) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<AccountDTO> applicants = photoBoardService.getApplicants(concert_id);
		map.put("applicants",applicants);
		mav.addObject("map",map);
		mav.setViewName("photo_board/applicants");
		return mav;
	}
}
