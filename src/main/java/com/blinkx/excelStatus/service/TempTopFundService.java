package com.blinkx.excelStatus.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.TempTopFund;
import com.blinkx.excelStatus.entity.TopFund;

public interface TempTopFundService {
	
	public void saveTempTopFund(MultipartFile file) throws Exception;
	
	public List<TempTopFund> getAllTempTopFund();


}
