package com.example.demo.config.aop;

public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextLocal = new ThreadLocal<>();

    public static void setDataSourceType(String dataSourceType){
        contextLocal.set(dataSourceType);
    }

    public static String getDataSourceType(){
        return contextLocal.get();
    }

    public static void clear(){
        contextLocal.remove();
    }
}
