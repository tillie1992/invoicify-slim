package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/api/billing-records/flat-fees")

public class FlatFeesApiController {

	private BillingRecordRepository billingRecordRepository;
	private CompanyRepository companyRepository;

	public FlatFeesApiController(BillingRecordRepository billingRecordRepository, CompanyRepository companyRepository) {
		this.billingRecordRepository = billingRecordRepository;
		this.companyRepository = companyRepository;
	}

	@PostMapping
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		record.setClient(companyRepository.findOne(record.getClient().getId()));
		return billingRecordRepository.save(record);

	}
}
