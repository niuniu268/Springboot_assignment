package com.example.controller;

import com.example.domain.Invoice;
import com.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    HttpSession session;

/*@GetMapping
    public List<Invoice> getByConditional(){
        String username = (String) session.getAttribute( "username" );
        return invoiceService.getByConditional( username  );

    }*/

@GetMapping
    public List<Invoice> getAll(){
        return invoiceService.getAll(  );
    }
    @PostMapping
    public Boolean save(@RequestBody Invoice invoice){
        return invoiceService.save( invoice );
    }
    @PutMapping
    public Boolean update(@RequestBody Invoice invoice){
        return invoiceService.update( invoice );
    }
    @DeleteMapping("{id}")
    public Boolean delete( @PathVariable Integer id){
        return invoiceService.delete( id );
    }

    @GetMapping("{id}")
    public Invoice getById( @PathVariable Integer id){
        return invoiceService.getById( id );
    }
}
