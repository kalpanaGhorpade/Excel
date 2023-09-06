package com.blinkx.excelStatus.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.ExcelStatusEntity;
import com.blinkx.excelStatus.entity.TopFund;
import com.blinkx.excelStatus.repository.TopFundRepository;
import com.blinkx.excelStatus.service.TopFundService;

@Service
public class TopFundServiceImpl implements TopFundService {
	
	@Autowired
	private TopFundRepository topFundRepository;


	@Override
	public void saveTopFunds(MultipartFile file) throws Exception {
		
		try {
			topFundRepository.deleteAll();
			topFundRepository.restartIdentity();
			 List<TopFund> convertExcelSheetToSql = ExcelHelperImpl.convertExcelToSqlTopFunds(file.getInputStream());
			 topFundRepository.saveAll(convertExcelSheetToSql);
			}
			catch (Exception e) {
				 throw new RuntimeException("fail to store excel data: " + e.getMessage());
				 }

	}

	@Override
	public List<TopFund> getAllTopFund() {
		List<TopFund> topFunds = topFundRepository.findAll();
		return topFunds;
	}

}
