package com.example.accountingapp.controller;

import com.example.accountingapp.dto.InvoiceDTO;
import com.example.accountingapp.dto.InvoiceProductDTO;
import com.example.accountingapp.entity.Invoice;
import com.example.accountingapp.entity.InvoiceProduct;
import com.example.accountingapp.enums.CompanyType;
import com.example.accountingapp.enums.InvoiceType;
import com.example.accountingapp.service.ClientVendorService;
import com.example.accountingapp.service.InvoiceProductService;
import com.example.accountingapp.service.InvoiceService;
import com.example.accountingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoice")
public class PurchaseInvoiceController {


    final private InvoiceService invoiceService;
    final private InvoiceProductService invoiceProductService;
    final private ClientVendorService clientVendorService;

    public PurchaseInvoiceController(InvoiceService invoiceService, InvoiceProductService invoiceProductService, ClientVendorService clientVendorService, ProductService productService) {
        this.invoiceService = invoiceService;
        this.invoiceProductService = invoiceProductService;
        this.clientVendorService = clientVendorService;
    }

    @GetMapping("/purchaseInvoiceList")
    public String purchaseInvoiceList(Model model) {
        model.addAttribute("purchaseInvoices", invoiceService.listAllByInvoiceType(InvoiceType.PURCHASE));
        return "invoice/purchase-invoice-list";
    }

    @GetMapping("/purchaseInvoiceCreate")
    public String purchaseInvoiceCreate(Model model) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("vendors", clientVendorService.findAllByCompanyType(CompanyType.VENDOR));

        return "invoice/purchase-invoice-create";

    }

    @GetMapping("/purchaseInvoiceSelectProduct")
    public String getProductDetailsForInvoiceProduct(@ModelAttribute("invoiceDTO") InvoiceDTO invoiceDTO , Model model){
        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("invoiceProductDTO", new InvoiceProductDTO());
        model.addAttribute("products", invoiceProductService.findAllProductsByCompanyName(invoiceDTO.getCompanyName()));


        //TODO VITALY remove debug
        System.out.println(invoiceDTO.getCompanyName());
        return "invoice/purchase-invoice-select-product";
    }




}
