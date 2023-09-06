package com.blinkx.excelStatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blinkx.excelStatus.entity.TempTopFund;

import jakarta.transaction.Transactional;

public interface TempTopFundRepository extends JpaRepository<TempTopFund, Long>{

	@Transactional
	@Query(value = "SELECT setval('temp_top_fund_id_seq', 1, false)", nativeQuery = true)
	void restartIdentity();
}
