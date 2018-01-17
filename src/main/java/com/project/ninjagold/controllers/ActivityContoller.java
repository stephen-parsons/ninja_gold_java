package com.project.ninjagold.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.Collections;

import com.project.ninjagold.models.Activity;

@Controller
public class ActivityContoller{
	@RequestMapping("/")
		public String home(){
		return "redirect:/activities";	
	}
	
	@RequestMapping("/activities")
	public String activities(){
		return "activities";
	}	

	@PostMapping("/process")
	public String process(@RequestParam(value="building") String location, HttpSession session){
		int min =0;
		int max =0;
		if (session.getAttribute("total") == null ){
			session.setAttribute("total", 0);
		}
		if (session.getAttribute("messages") == null) {
			ArrayList<Activity> messages = new ArrayList<Activity>();
			session.setAttribute("messages", messages);
		}
		if (location.equals("farm")) {
			min = 10;
			max = 20;
		}
		if (location.equals("cave")) {
			min = 5;
			max = 10;
		}
		if (location.equals("house")) {
			min = 2;
			max = 5;
		}
		if (location.equals("casino")) {
			double money = Math.random();
			if (money > 0.5){
				min = 0;
				max = 50;
			}
			else {
				min = -50;
				max = 0;
			}
		}
		Activity findGold = new Activity(location, min, max);
		session.setAttribute("total", (int) session.getAttribute("total") + findGold.getGold());
		ArrayList<Activity> list = (ArrayList) session.getAttribute("messages");
		Collections.reverse(list);
		list.add(findGold);
		Collections.reverse(list);
		session.setAttribute("messages", list);
		return "redirect:/activities";
	}

	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.setAttribute("messages", null);
		session.setAttribute("total", null);
		return "redirect:/";
	}
}
