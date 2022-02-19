package com.uk.redis.controller;

import com.uk.redis.beans.Invoice;
import com.uk.redis.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/saveInv")
    public Invoice saveInvoice(@RequestBody Invoice inv) {
        return invoiceService.save(inv);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @GetMapping("/getOne/{id}")
    public Invoice getOneInvoice(@PathVariable Long id) {
        return invoiceService.find(id);
    }

    @PutMapping("/modify/{invId}")
    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Long invId) {
        return invoiceService.update(inv, invId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceService.delete(id);
        return "Employee with id: "+id+ " Deleted !";
    }

}
