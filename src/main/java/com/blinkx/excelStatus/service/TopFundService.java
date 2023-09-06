package com.blinkx.excelStatus.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.TopFund;

public interface TopFundService {
	
	public void saveTopFunds(MultipartFile file) throws Exception;
	
	public List<TopFund> getAllTopFund();
	
	
	
	

}
