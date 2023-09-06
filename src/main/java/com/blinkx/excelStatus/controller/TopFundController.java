package com.blinkx.excelStatus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.service.TopFundService;
import com.blinkx.excelStatus.serviceIml.ExcelHelperImpl;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"*"})
public class TopFundController {
	
	@Autowired
	private TopFundService topFundService;
	
	@PostMapping("addTopfund")
	private String addTopfund(@RequestParam ("multipartFile")MultipartFile multipartFile ) {
		if(ExcelHelperImpl.hasExcelFormat(multipartFile)) {
			try {
				topFundService.saveTopFunds(multipartFile);
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

}
