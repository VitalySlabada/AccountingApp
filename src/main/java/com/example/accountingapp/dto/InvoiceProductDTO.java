package com.example.accountingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 15, min = 2)
    private String name;

    @NotBlank
    @Size(min = 0)
    private Integer qty;

    @NotBlank
    @Size(min = 0)
    private BigDecimal price;

    @NotBlank
    @Size(min = 0)
    private BigDecimal tax;


    @NotBlank
    @Size(min = 0)
    private BigDecimal total;

    @NotBlank
    @Size(min = 0)
    private BigDecimal profit;

    private Long productId;
    private ProductDTO prouctDTO;

    private InvoiceDTO invoiceDTO;


}
