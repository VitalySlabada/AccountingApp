package com.example.accountingapp.service;

import com.example.accountingapp.dto.InvoiceProductDTO;
import com.example.accountingapp.dto.ProductDTO;
import com.example.accountingapp.entity.InvoiceProduct;
import com.example.accountingapp.enums.InvoiceType;
import java.util.List;

public interface InvoiceProductService {

    List<InvoiceProduct> listAll();


    //TODO Vitaly - do I need to move to product services?
    List<ProductDTO> findAllProductsByCompanyName(String companyName);
}