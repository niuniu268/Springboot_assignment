package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.dao.InvoiceMapper;
import com.example.domain.Invoice;
import com.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;
import java.io.PrintWriter;
import java.util.function.Consumer;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @GetMapping
    public RedirectView checkInfo(@PathParam( "username" ) String username, @PathParam("password") String password){

        System.out.println(username );

        System.out.println(invoiceMapper.selectList( null ) );

        QueryWrapper <Invoice> wrapper = new QueryWrapper <>( );
        wrapper.like( "username", username ).and( Consumer -> Consumer.like("password", password) );

        System.out.println(invoiceMapper.selectCount( wrapper ) );

        if(invoiceMapper.selectCount( wrapper ) < 1) {

            return new RedirectView( "Error.html");

        }else{

            return new RedirectView(  "Invoice.html");
        }


        }



}
