package com.example.bilings_service.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bilings_service.dto.BillingDTO;
import com.example.bilings_service.dto.PatientDTO;
import com.example.bilings_service.feign.PatientClient;
import com.example.bilings_service.model.Billing;
import com.example.bilings_service.repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    BillingRepository billingRepository;

    @Autowired
    PatientClient patientClient;

    // Generate a new bill
    public Billing generateBill(Billing bill) {
        bill.setBillingDate(LocalDate.now());
        bill.setPaid(false);
        return billingRepository.save(bill);
    }

    // Get all bills with patient info
    public List<BillingDTO> getAllBillsFull() {
        List<Billing> bills = billingRepository.findAll();
        List<BillingDTO> result = new ArrayList<>();

        for (Billing bill : bills) {
            PatientDTO patient = patientClient.getPatientById(bill.getPatientId());

            BillingDTO dto = new BillingDTO();
            dto.setId(bill.getId());
            dto.setMedicalRecordId(bill.getMedicalRecordId());
            dto.setAmount(bill.getAmount());
            dto.setBillingDate(bill.getBillingDate());
            dto.setPaid(bill.isPaid());
            dto.setPatient(patient);

            result.add(dto);
        }

        return result;
    }

    // Get bills by patient (without using repo method)
    public List<BillingDTO> getBillsByPatient(Long patientId) {
        List<Billing> allBills = billingRepository.findAll(); // get all bills
        List<BillingDTO> result = new ArrayList<>();

        for (Billing bill : allBills) {
            if (bill.getPatientId().equals(patientId)) { // filter manually
                PatientDTO patient = patientClient.getPatientById(patientId);

                BillingDTO dto = new BillingDTO();
                dto.setId(bill.getId());
                dto.setMedicalRecordId(bill.getMedicalRecordId());
                dto.setAmount(bill.getAmount());
                dto.setBillingDate(bill.getBillingDate());
                dto.setPaid(bill.isPaid());
                dto.setPatient(patient);

                result.add(dto);
            }
        }

        return result;
    }

    // Pay a bill
    public Billing payBill(Long id) {
        Billing bill = billingRepository.findById(id).orElse(null);
        if (bill != null) {
            bill.setPaid(true);
            billingRepository.save(bill);
        }
        return bill;
    }

    // Delete a bill
    public void deleteBill(Long id) {
        billingRepository.deleteById(id);
    }
}
