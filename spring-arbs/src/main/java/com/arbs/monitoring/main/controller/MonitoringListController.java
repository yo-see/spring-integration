package com.arbs.monitoring.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.arbs.monitoring.main.service.MonitoringListService;

@Controller
public class MonitoringListController {
	
	@Autowired
	private MonitoringListService monitoringListService;
	
	@GetMapping("/")
	public String hello(ModelMap modelMap) {
		
		String time = monitoringListService.testQuery();
		modelMap.addAttribute("param_time", time);
		
		return "index";
	}
}
