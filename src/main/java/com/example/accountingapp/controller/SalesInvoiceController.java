package com.example.accountingapp.controller;

import com.example.accountingapp.dto.InvoiceDTO;

import com.example.accountingapp.entity.InvoiceProduct;
import com.example.accountingapp.enums.CompanyType;
import com.example.accountingapp.enums.InvoiceType;
import com.example.accountingapp.service.ClientVendorService;
import com.example.accountingapp.service.CompanyService;
import com.example.accountingapp.service.InvoiceProductService;
import com.example.accountingapp.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/invoice")
public class SalesInvoiceController {

    private final InvoiceService invoiceService;
    private final CompanyService companyService;

    private final InvoiceProductService invoiceProductService;
    private final ClientVendorService clientVendorService;


    public SalesInvoiceController(InvoiceService invoiceService, CompanyService companyService, InvoiceProductService invoiceProductService, ClientVendorService clientVendorService) {
        this.invoiceService = invoiceService;
        this.companyService = companyService;
        this.invoiceProductService = invoiceProductService;
        this.clientVendorService = clientVendorService;
    }

    @GetMapping("/salesInvoiceList")
    public String salesInvoiceList(Model model) {
        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));

        return "/invoice/sales-invoice-list";
    }

    @GetMapping("/salesInvoiceCreate")

    public String salesInvoiceCreate(Model model) {
        InvoiceDTO newInvoiceCreate = new InvoiceDTO();
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        return "/invoice/sales-invoice-create";
    }

    @GetMapping("/salesInvoiceSelectProduct")
    public String salesInvoiceSelectProduct(Model model) {
        InvoiceDTO newInvoiceCreate = new InvoiceDTO();
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        return "/invoice/sales-invoice-select-product";
    }


}
