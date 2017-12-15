package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/api/billing-records/rate-baseds")
public class RateFeesApiController {

	private BillingRecordRepository billingRecordRepository;
	private CompanyRepository companyRepository;

	public RateFeesApiController(BillingRecordRepository billingRecordRepository, CompanyRepository companyRepository) {
		this.billingRecordRepository = billingRecordRepository;
		this.companyRepository = companyRepository;
	}

	@PostMapping
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		record.setClient(companyRepository.findOne(record.getClient().getId()));
		return billingRecordRepository.save(record);
	}

}
