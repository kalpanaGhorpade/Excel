package com.blinkx.excelStatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.TempTopFund;
import com.blinkx.excelStatus.service.TempTopFundService;
import com.blinkx.excelStatus.serviceIml.ExcelHelperImpl;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"*"})
public class TempTopFundController {
	
	@Autowired
	private TempTopFundService tempTopFundService;
	
	@PostMapping("addTempTopFunds")
	private String addTempTopFunds(@RequestParam("file")MultipartFile file) {
		if(ExcelHelperImpl.hasExcelFormat(file)) {
			try {
				tempTopFundService.saveTempTopFund(file);
				return "Data added successfully";
			}
			catch (Exception e) {
				return " failed to add data";
			}		
	}
		else {
			return "Error, please upload correct file";
		}
			
	}
	
	@GetMapping("getAllTempTopFund")
	private Object getAllTempTopFund(){
		List<TempTopFund> tempTopFund = tempTopFundService.getAllTempTopFund();
		if(tempTopFund!=null&!tempTopFund.isEmpty()) {
			return tempTopFund;
		}
		else {
			return "no Fund data found";
		}
	}

}
