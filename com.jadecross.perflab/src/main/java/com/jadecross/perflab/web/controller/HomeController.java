package com.jadecross.perflab.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jadecross.perflab.domain.Towner;
import com.jadecross.perflab.mybatis.mapper.TownerMapper;
import com.jadecross.perflab.mybatis.mapper.TownerMapper2;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TownerMapper townerMapper;
	
	@Autowired
	private TownerMapper2 townerMapper2;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		
		List<Towner> towners = townerMapper.findAll();
		model.addAttribute("towners", towners);
		
		List<Towner> towners2 = townerMapper2.findAll();
		model.addAttribute("towners2", towners);
		
		return "home";
	}
	
}
