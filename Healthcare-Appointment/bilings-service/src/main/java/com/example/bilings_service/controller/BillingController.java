package com.example.bilings_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bilings_service.dto.BillingDTO;
import com.example.bilings_service.model.Billing;
import com.example.bilings_service.service.BillingService;
@RestController
@RequestMapping("/api/billing")
public class BillingController {
	
	 @Autowired
	    BillingService billingService;

	    // Generate a new bill
	    @PostMapping("/generate")
	    public Billing createBill(@RequestBody Billing bill) {
	        return billingService.generateBill(bill);
	    }

	    // Get all bills with patient details
	    @GetMapping("/all")
	    public List<BillingDTO> getAllBills() {
	        return billingService.getAllBillsFull();
	    }

	    // Get bills for a specific patient
	    @GetMapping("/patient/{patientId}")
	    public List<BillingDTO> getBillsByPatient(@PathVariable Long patientId) {
	        return billingService.getBillsByPatient(patientId);
	    }

	    // Pay a bill
	    @PutMapping("/pay/{id}")
	    public Billing payBill(@PathVariable Long id) {
	        return billingService.payBill(id);
	    }

	    // Delete a bill
	    @DeleteMapping("/delete/{id}")
	    public String deleteBill(@PathVariable Long id) {
	        billingService.deleteBill(id);
	        return "Bill with ID " + id + " deleted successfully.";
	    }

}
