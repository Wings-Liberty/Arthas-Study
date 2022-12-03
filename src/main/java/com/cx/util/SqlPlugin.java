package com.cx.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "parameterize",
        args = {Statement.class}
)})
@Component
public class SqlPlugin implements Interceptor {

    Logger logger = LoggerFactory.getLogger(SqlPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object returnObject = invocation.proceed();

        Boolean enableSqlDebug = SpringUtil.getApplicationContext().getEnvironment().getProperty("sql.debug", Boolean.class);
        if (ObjectUtil.isNotEmpty(enableSqlDebug) && Boolean.TRUE.equals(enableSqlDebug)) {
            try {
                Statement statement = (Statement) invocation.getArgs()[0];
                String finalExecutableSql = null;
                if (Proxy.isProxyClass(statement.getClass())) {
                    MetaObject metaObject = SystemMetaObject.forObject(statement);
                    Object h = metaObject.getValue("h");
                    PreparedStatementLogger psl = (PreparedStatementLogger) h;
                    finalExecutableSql = psl.getPreparedStatement().toString();
                } else if(statement.getClass().equals(DruidPooledPreparedStatement.class)){
                    DruidPooledPreparedStatement proxy = (DruidPooledPreparedStatement) statement;
                    PreparedStatementProxyImpl rawObject = (PreparedStatementProxyImpl)proxy.getRawPreparedStatement();
                    finalExecutableSql = rawObject.getRawObject().toString().split(": ")[1];
                }else {
                    finalExecutableSql = statement.toString();
                }
                logger.info("最终执行的SQL语句: {}", finalExecutableSql);
            } catch (Exception e) {
                logger.warn("获取 sql 失败，失败原因是 {}", e.getLocalizedMessage());
            }
        }
        return returnObject;
    }
}
