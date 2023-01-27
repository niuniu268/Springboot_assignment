package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.InvoiceMapper;
import com.example.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceimpl implements InvoiceService{
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Override
    public Boolean save(Invoice invoice) {
        return invoiceMapper.insert( invoice ) > 0;
    }

    @Override
    public Boolean update(Invoice invoice) {
        return invoiceMapper.updateById( invoice ) > 0 ;
    }

    @Override
    public Boolean delete(Integer id) {
        return invoiceMapper.deleteById( id ) > 0;
    }

    @Override
    public Invoice getById(Integer id) {
        return invoiceMapper.selectById( id );
    }

    @Override
    public List <Invoice> getAll() {

        return invoiceMapper.selectList( null );
    }

    @Override
    public List<Invoice> getByConditional(String username) {

        QueryWrapper<Invoice>  qw = new QueryWrapper<>();
        qw.like("username", username);


        return invoiceMapper.selectList( qw );
    }
}
