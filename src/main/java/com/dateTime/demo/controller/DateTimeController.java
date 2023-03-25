package com.dateTime.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {
	
	LocalDateTime dt;
	DateTimeFormatter format;
	
	
	@GetMapping("")
	public String index(Model m, HttpSession session) {
		
		String dateTemplate = "Date Template";
		String timeTemplate = "Time Template";
		
		m.addAttribute("dateLink", dateTemplate);
		m.addAttribute("timeLink", timeTemplate);
		
		return "index.jsp";
	}
	
//	@PostMapping
//	public String redirect(
//			@RequestParam(value="date", required=false) String date
//			, @RequestParam(value="time", required=false) String time) {
//		
//		
//		
//		return "";
//	}
	
	@GetMapping("/date")
	public String datePage(Model m) {
		dt = LocalDateTime.now();
		format = DateTimeFormatter.ofPattern("EEEE, MMM d, Y");
		String currentDate = dt.format(format);
		m.addAttribute("currentDate", currentDate);
		return "date.jsp";
	}
	@GetMapping("/time")
	public String timePage(Model m) {
		dt = LocalDateTime.now();
		format = DateTimeFormatter.ofPattern("h:mm a");
		String currentTime = dt.format(format);
		m.addAttribute("currentTime", currentTime);
		return "time.jsp";
	}
}
