package com.example.dao;

import com.example.domain.Kvitton;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KvittonMapper {
    @Select( "select * from kvitton" )
    List<Kvitton> selectAll();
}
