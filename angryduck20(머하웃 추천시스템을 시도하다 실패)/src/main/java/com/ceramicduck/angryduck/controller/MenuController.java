package com.ceramicduck.angryduck.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ceramicduck.angryduck.dto.BoardDTO;
import com.ceramicduck.angryduck.dto.MailDTO;
import com.ceramicduck.angryduck.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.service.BoardService;
import com.ceramicduck.angryduck.service.PhotoBoardService;
import com.ceramicduck.angryduck.util.Pager;

@Controller
public class MenuController {
	public static final int BOARD_NOTICE=1;
	public static final int PHOTOBOARD_NOTICE=1;
	
	@Inject
	PhotoBoardService photoBoardService;
	
	@Inject
	BoardService boardService;
	
	@Autowired 
	private JavaMailSenderImpl mailSender;

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		return "about/about";
	}
	
	@RequestMapping(value = "/photoboard")
	public ModelAndView photoBoard(@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="all") String searchOption,
			@RequestParam(defaultValue="") String keyword,
			ModelAndView mav, HttpSession session) throws IOException, TasteException {
		int count = photoBoardService.countArticle(searchOption, keyword);
		Pager pager = new Pager(count, curPage, 8, 10);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		List<PhotoBoardDTO> list = photoBoardService.listAll(start,end,searchOption,keyword);
		PhotoBoardDTO notice = photoBoardService.getNotice(PHOTOBOARD_NOTICE);
		mav.setViewName("photo_board/list");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("count",count);
		map.put("search_option",searchOption);
		map.put("keyword",keyword);
		map.put("pager",pager);
		map.put("notice",notice);
		
		if(session.getAttribute("id") !=null && ((String)session.getAttribute("role")).equals("performer")) {
			boolean anythingApply=true;
			if(photoBoardService.countArticle("account_id",((Integer)session.getAttribute("id")).toString())==0)
				anythingApply=false;
			List<PhotoBoardDTO> recommendConcert = new ArrayList<PhotoBoardDTO>();
			
			if(anythingApply==true) {
				DataModel model = new FileDataModel(new File("C:\\Users\\a\\Desktop\\project\\과정\\recommend예시.csv")); 
				UserSimilarity similarity = new PearsonCorrelationSimilarity(model); 
				UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
				UserBasedRecommender recommender = new GenericUserBasedRecommender( model, neighborhood, similarity); 
				List<RecommendedItem> recommendations = recommender.recommend(2, 3);
				
				logger.info(""+recommendations.size());
				for(RecommendedItem rcm : recommendations) {
					//recommendConcert.add(photoBoardService.getView((int)rcm.getItemID()));
					logger.info(rcm.getItemID()+" "+rcm.getValue());
				}
			}
			else {
				recommendConcert.add(photoBoardService.getView(1));
			}
			map.put("recommendConcert",recommendConcert);
		}
		
		mav.addObject("map",map);
		return mav;
	}
	
	@RequestMapping(value = "/board")
	public ModelAndView board(
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="all") String searchOption,
			@RequestParam(defaultValue="") String keyword,ModelAndView mav) {
		int count = boardService.countArticle(searchOption, keyword);
		Pager pager = new Pager(count, curPage, 8, 10);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		List<BoardDTO> list = boardService.listAll(start,end,searchOption,keyword);
		BoardDTO notice = boardService.getNotice(BOARD_NOTICE);
		mav.setViewName("board/list");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("count",count);
		map.put("search_option",searchOption);
		map.put("keyword",keyword);
		map.put("pager",pager);
		map.put("notice",notice);
		mav.addObject("map",map);
		return mav;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact(@RequestParam("id") int id, ModelAndView mav) {
		String to = "";
		
		if(id == 1) {
			to = "duckduck31216@gmail.com";
		}
		else{
			to = "kys4548@gmail.com";
		}
		
		mav.addObject("to",to);
		mav.setViewName("contact/writeMail");
		return mav;
	}
	
	@RequestMapping(value="/contact/sendMail")
	public ModelAndView sendMail(MailDTO dto, ModelAndView mav) { 
		final MimeMessagePreparator preparator = new MimeMessagePreparator() { 
			@Override 
			public void prepare(MimeMessage mimeMessage) throws Exception { 
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setFrom(dto.getFrom()); 
				helper.setTo(dto.getTo()); 
				helper.setSubject(dto.getSubject()); 
				helper.setText(dto.getContents(), true);
			} 
		}; 
		mav.setViewName("main");
		mav.addObject("message","sendMailSuccess");
		mailSender.send(preparator); 
		return mav;
	}
}
