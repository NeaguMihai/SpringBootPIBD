package com.neagumihai.proiectpibddata.config;

import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class CustomMysql extends MySQL8Dialect {

    public CustomMysql() {
        super();
        this.registerFunction("GROUP_CONCAT", new StandardSQLFunction("GROUP_CONCATs"));
    }
}

