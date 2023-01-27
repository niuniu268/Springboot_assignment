package com.example.service;

import com.example.domain.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InvoiceService {

    Boolean save (Invoice invoice);
    Boolean update (Invoice invoice);

    Boolean delete (Integer id);
    Invoice getById(Integer id);

    List<Invoice> getAll();

    List<Invoice> getByConditional(String username);
}
