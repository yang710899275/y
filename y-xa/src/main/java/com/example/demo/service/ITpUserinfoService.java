package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.TpUserInfo;

public interface ITpUserinfoService extends IService<TpUserInfo> {
     void testInsert1();
     void testInsert2();
     void ttt();

     //xa分布式分包测试
     void testPackageInsert1();
     void testPackageInsert2();

     //xa分布式分包测试（事务）
     void testPackageInsert3();
     void testPackageInsert4();
}
