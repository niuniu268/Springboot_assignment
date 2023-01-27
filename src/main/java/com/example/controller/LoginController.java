package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.dao.InvoiceMapper;
import com.example.domain.Invoice;
import com.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.PrintWriter;
import java.util.function.Consumer;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public ModelAndView checkInfo(@PathParam( "username" ) String username, @PathParam("password") String password){

        System.out.println(invoiceMapper.selectList( null ) );

        QueryWrapper <Invoice> wrapper = new QueryWrapper <>( );
        wrapper.like( "username", username ).and( Consumer -> Consumer.like("password", password) );

        System.out.println(invoiceMapper.selectCount( wrapper ) );
        ValueOperations valueOperations = redisTemplate.opsForValue( );
        valueOperations.set("username", username);


        if(invoiceMapper.selectCount( wrapper ) > 0) {

            return new ModelAndView(  "Invoice.html");


        }else{

            return new ModelAndView( "Error.html");

        }


    }



}
