package com.blinkx.excelStatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blinkx.excelStatus.entity.TopFund;

import jakarta.transaction.Transactional;

public interface TopFundRepository extends JpaRepository<TopFund, Long>{
	
	@Transactional
	@Query(value = "SELECT setval('m_top_fund_id_seq', 1, false)", nativeQuery = true)
	void restartIdentity();

}
