package com.example.demo.controller;

import com.example.demo.service.ITpUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class testXaController {

    //事务正常
    @RequestMapping("/xa2")
    @Transactional
    public void testxa2(){
        tpUserinfoService.ttt();
    }
    //事务正常
    @RequestMapping("/xa")
    @Transactional
    public void testxa(){
        ttt();
    }

    @Autowired
    @Qualifier("symbolOrder")
    private AtomikosDataSourceBean symbolOrder;

    @Autowired
    @Qualifier("symbolPosition")
    private AtomikosDataSourceBean symbolPosition;

      //事务放这里起不到作用
    public void ttt() {
        Connection orderConnection  = null;
        Connection positionConnection = null;
        try {
            positionConnection = symbolPosition.getConnection();
            String sql = "insert into sys_user (id) values (1128)";
            //sql = MessageFormat.format(sql,4,"000002.SZ",200);
            PreparedStatement positionStatement = positionConnection.prepareStatement(sql);
            positionStatement.execute();
            orderConnection = symbolOrder.getConnection();
            sql = "insert into sys_user (id) values (1112)";
            //sql = MessageFormat.format(sql,4,"000004.SZ",100,(float)5.5,"2017-07-27 14:31:00");
            PreparedStatement orderStatement = orderConnection.prepareStatement(sql);
            orderStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ttt");
            //加这个不生效，依然能插入
            throw new RuntimeException();
        } finally {
            try {
                if (orderConnection != null) {
                    orderConnection.close();
                }
                if (positionConnection != null) {
                    positionConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Autowired
    ITpUserinfoService tpUserinfoService;

    /**
     * 事务在service层
     */
    @RequestMapping("/single")
    public void testSingle(){
        tpUserinfoService.testInsert1();
    }

    /**
     * 事务在controller层
     */
    @RequestMapping("/single2")
    @Transactional
    public void testSingle2(){

        tpUserinfoService.testInsert2();
    }


    /**
     * 事务在controller层
     */
    @RequestMapping("/testPackege")
    @Transactional
    public void testPackege(){

        tpUserinfoService.testPackageInsert1();
        tpUserinfoService.testPackageInsert2();
    }
}
