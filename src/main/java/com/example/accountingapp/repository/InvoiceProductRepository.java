package com.example.accountingapp.repository;

import com.example.accountingapp.dto.InvoiceProductDTO;
import com.example.accountingapp.enums.InvoiceType;
import java.util.List;
import com.example.accountingapp.dto.InvoiceDTO;
import com.example.accountingapp.entity.Invoice;
import com.example.accountingapp.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long> {

    List<InvoiceProduct>  findAllByInvoiceId(Long id);


    @Query(value = "SELECT MAX(id) FROM invoice_product",nativeQuery = true)
    Optional<Long> findHighestId();


    @Query("SELECT i.invoice.id from InvoiceProduct i where i.id =?1")
    Long findInvoiceByInvoiceProductId (@Param("id") Long id);
    InvoiceProduct getByInvoiceId(Long id);

}
