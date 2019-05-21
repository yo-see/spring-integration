package com.arbs.monitoring.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arbs.monitoring.main.mapper.MonitoringListMapper;

@Service("monitoringListService")
public class MonitoringListService {

	@Autowired
	private MonitoringListMapper monitoringListMapper;
	
	public String testQuery() {
		return monitoringListMapper.testQuery();
	}
	
	public int testInsert() {
		return monitoringListMapper.testInsert();
	}
	

}
