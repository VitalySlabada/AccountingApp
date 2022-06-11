package com.example.accountingapp.controller;

import com.example.accountingapp.dto.ClientVendorDTO;
import com.example.accountingapp.dto.ProductDTO;
import com.example.accountingapp.enums.Unit;
import com.example.accountingapp.service.ClientVendorService;
import com.example.accountingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String productList(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "/product/product-list";
    }

    @GetMapping("/add")
    public String createClient(Model model) {
        model.addAttribute("product", new ProductDTO());
//        model.addAttribute("categories", categoryService.listAllCategories());
        return "/product/product-add";
    }

    @PostMapping("/add")
    public String insertClient(@ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", new ProductDTO());
            return "/product/product-add";
        }
        //productService.save(productDTO);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}") //
    public String updateClient(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/product-edit";
    }

    @PostMapping("/edit/{id}")
    public String editClient(@PathVariable("id") Long id, @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult,Model model) {

//        if (bindingResult.hasErrors()) {
//            return "/product/product-edit";
//        }
        System.out.println("To update id: "+id);
//        // productService.update(productDTO);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
//        productService.delete(id);
        return "redirect:/product/list";
    }

}
