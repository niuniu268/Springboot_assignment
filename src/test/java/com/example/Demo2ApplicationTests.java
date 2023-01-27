package com.example;

import com.example.dao.InvoiceMapper;
import com.example.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Test
    void contextLoads() {
        List <Invoice> invoices = invoiceMapper.selectList( null );

        System.out.println(invoices );


    }

}
