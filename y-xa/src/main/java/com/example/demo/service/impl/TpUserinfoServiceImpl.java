package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.TpUserinfoMapper;
import com.example.demo.model.TpUserInfo;
import com.example.demo.service.ITpUserinfoService;
import javafx.concurrent.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class TpUserinfoServiceImpl extends ServiceImpl<TpUserinfoMapper, TpUserInfo> implements ITpUserinfoService {
    @Autowired
    private TpUserinfoMapper tpUserinfoMapper;


    @Autowired
    @Qualifier("tpUserinfoMapper2")
    private com.example.demo.dao2.TpUserinfoMapper tpUserinfoMapper2;

    @Override
    //@Transactional
    public void testInsert1() {
        TpUserInfo t = new TpUserInfo();
        t.setBusCode("123123132888888888999911122222");
        tpUserinfoMapper.insert(t);
        int i = 3/0 ;
    }

    @Override
    public void testInsert2() {
        TpUserInfo t = new TpUserInfo();
        t.setBusCode("1231231328888888889999222");
        tpUserinfoMapper.insert(t);
        int i = 3/0 ;
    }


    @Autowired
    @Qualifier("symbolOrder")
    private AtomikosDataSourceBean symbolOrder;

    @Autowired
    @Qualifier("symbolPosition")
    private AtomikosDataSourceBean symbolPosition;

    @Override
    //@Transactional
    public void ttt() {
        Connection orderConnection  = null;
        Connection positionConnection = null;
        try {
            positionConnection = symbolPosition.getConnection();
            String sql = "insert into sys_user (id) values (1129)";
            //sql = MessageFormat.format(sql,4,"000002.SZ",200);
            PreparedStatement positionStatement = positionConnection.prepareStatement(sql);
            positionStatement.execute();
            orderConnection = symbolOrder.getConnection();
            sql = "insert into sys_user (id) values (1111)";
            //sql = MessageFormat.format(sql,4,"000004.SZ",100,(float)5.5,"2017-07-27 14:31:00");
            PreparedStatement orderStatement = orderConnection.prepareStatement(sql);
            orderStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
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
       // int i = 3/ 0;
    }



    @Override
    public void testPackageInsert1() {
        System.out.println("package1");
        TpUserInfo t = new TpUserInfo();
        t.setId(IdWorker.get32UUID());
        t.setBusCode("123123132888888888999977777");
        tpUserinfoMapper.insert2(t);
        //tpUserinfoMapper.insert(t);
    }

    @Override
    public void testPackageInsert2() {
        System.out.println("package2");
        TpUserInfo t = new TpUserInfo();
        t.setBusCode("123123132888888888999977777");
        tpUserinfoMapper2.insert(t);
    }
}
