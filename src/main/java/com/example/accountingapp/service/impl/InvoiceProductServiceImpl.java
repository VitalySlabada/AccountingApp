package com.example.accountingapp.service.impl;


import com.example.accountingapp.dto.ProductDTO;
import com.example.accountingapp.entity.Product;
import com.example.accountingapp.mapper.MapperUtil;
import com.example.accountingapp.repository.CompanyRepository;
import com.example.accountingapp.entity.InvoiceProduct;
import com.example.accountingapp.repository.InvoiceProductRepository;
import com.example.accountingapp.repository.ProductRepository;
import com.example.accountingapp.service.InvoiceProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class InvoiceProductServiceImpl implements InvoiceProductService {

    final private InvoiceProductRepository invoiceProductRepository;
    final private CompanyRepository companyRepository;
    final private ProductRepository productRepository;
    final private MapperUtil mapperUtil;

    public InvoiceProductServiceImpl(InvoiceProductRepository invoiceProductRepository, CompanyRepository companyRepository, ProductRepository productRepository, MapperUtil mapperUtil) {
        this.invoiceProductRepository = invoiceProductRepository;
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<InvoiceProduct> listAll() {
        return invoiceProductRepository.findAll();
    }

    @Override
    public List<ProductDTO> findAllProductsByCompanyName(String companyName) {
        //find company ID
        Long companyId = companyRepository.findByTitle(companyName).get().getId();
        //get all products that this company sells
        List<Product> productList = productRepository.findAllByCompanyId(companyId);
        //map to DTO
        List<ProductDTO> productDTOList= productList.stream()
                .map(p->mapperUtil.convert(p,new ProductDTO()))
                .collect(Collectors.toList());
        return productDTOList;
    }

}
