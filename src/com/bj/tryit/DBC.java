package com.bj.tryit;

import javax.sql.DataSource;

/**
 * Created by neko on 2018/3/8.
 */
public class DBC {
    private static DBC dbc = new DBC();

    private DBC(){
        //私有构造函数
    }
    //类加载时已初始化，不会有多线程问题
    public static DBC getDbc(){
        return dbc;
    }
}
