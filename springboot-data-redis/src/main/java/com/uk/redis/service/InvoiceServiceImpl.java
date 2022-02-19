package com.uk.redis.service;

import com.uk.redis.beans.Invoice;
import com.uk.redis.exception.InvoiceNotFoundException;
import com.uk.redis.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Override
    public Invoice save(Invoice inv) {
        return invoiceRepo.save(inv);
    }

    @Override
    @CachePut(value = "Invoice", key = "#invId")
    public Invoice update(Invoice inv, Long invId) {
        Invoice invoice = invoiceRepo.findById(inv.getInvId())
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoice.setInvAmount(inv.getInvAmount());
        invoice.setInvName(inv.getInvName());
        return invoiceRepo.save(invoice);
    }

    @Override
    @CacheEvict(value = "Invoice", key = "#invId")
    public void delete(Long invId) {
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepo.delete(invoice);
    }

    @Override
    @Cacheable(value = "Invoice", key = "#invId")
    public Invoice find(Long invId) {
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        return invoice;
    }

    @Override
    @Cacheable(value = "Invoice")
    public List<Invoice> findAll() {
        return invoiceRepo.findAll();
    }
}
