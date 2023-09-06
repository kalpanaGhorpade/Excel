package com.blinkx.excelStatus.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.TempTopFund;
import com.blinkx.excelStatus.repository.TempTopFundRepository;
import com.blinkx.excelStatus.service.TempTopFundService;

@Service

public class TempTopFundServiceImpl implements TempTopFundService {
	
	@Autowired
	private TempTopFundRepository tempTopFundRepository;

	@Override
	public void saveTempTopFund(MultipartFile file) throws Exception {
			try {
				tempTopFundRepository.deleteAll();
				tempTopFundRepository.restartIdentity();
				 List<TempTopFund> tempTopFund = ExcelHelperImpl.convertExceltoSqlTempTopFund(file.getInputStream());
				tempTopFundRepository.saveAll(tempTopFund);
			} catch (Exception e) {
				 throw new RuntimeException("fail to store excel data: " + e.getMessage());
			}
	}

	@Override
	public List<TempTopFund> getAllTempTopFund() {
		List<TempTopFund> tempTopFunds = tempTopFundRepository.findAll();
		return tempTopFunds;
	}

}
