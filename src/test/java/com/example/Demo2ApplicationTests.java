package com.example;

import com.example.dao.KvittonMapper;
import com.example.domain.Kvitton;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private KvittonMapper kvittonMapper;

    @Test
    void contextLoads() {
        List <Kvitton> kvittons = kvittonMapper.selectAll( );

        System.out.println(kvittons );
    }

}
