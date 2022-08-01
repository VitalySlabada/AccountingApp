package com.example.accountingapp.service;

import com.example.accountingapp.dto.InvoiceDTO;
import com.example.accountingapp.dto.PaymentDTO;
import com.example.accountingapp.dto.ReportDTO;
import com.example.accountingapp.entity.InvoiceProduct;
import com.example.accountingapp.entity.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    

    Map<String, BigDecimal> profitLoss();

    Set<ReportDTO> calculateByProducts();

    List<InvoiceDTO> findLast3ByCompany();

    List<InvoiceProduct> findAllByCompany();

    List<Payment> listAllByYearAndCompany(String year);
}