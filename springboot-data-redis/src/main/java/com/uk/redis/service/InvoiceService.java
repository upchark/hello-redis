package com.uk.redis.service;

import com.uk.redis.beans.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice save(Invoice inv);
    Invoice update(Invoice inv, Long invId);
    void delete(Long invId);
    Invoice find(Long invId);
    List<Invoice> findAll();
}
