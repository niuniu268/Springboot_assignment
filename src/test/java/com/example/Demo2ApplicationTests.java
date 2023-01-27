package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.InvoiceMapper;
import com.example.domain.Invoice;
import com.example.service.InvoiceService;
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
        QueryWrapper <Invoice> qw = new QueryWrapper <>( );
        qw.like("username", "niuniu");
        List <Invoice> invoices = invoiceMapper.selectList( null );

        System.out.println(invoices );
    }
@Test
    void testSave(){
        Invoice invoice = new Invoice( );
        invoice.setUsername( "test" );
        invoice.setPassword( "test" );
        invoice.setBeskrivning( "test" );
        invoice.setCategory( "test" );
        invoice.setTitle( "test" );
        invoice.setPris( 500 );
        invoiceMapper.insert( invoice );
    }
    @Test
    void testUpdate(){
        Invoice invoice = new Invoice( );
        invoice.setId( 4 );
        invoice.setUsername( "test4" );
        invoice.setPassword( "test4" );
        invoice.setBeskrivning( "test4" );
        invoice.setCategory( "test4" );
        invoice.setTitle( "test4" );
        invoice.setPris( 4500 );
        invoiceMapper.updateById( invoice );
    }
@Test
    void testDelete(){
        invoiceMapper.deleteById( 4 );
    }
    @Autowired
    private InvoiceService invoiceService;
@Test
    void testServiceSelectall(){

        System.out.println(invoiceService.getAll() );
    }

}
