package com.javops.webapp.sql;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.StorageException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void start(String sql) {
        start(sql, PreparedStatement::execute);
    }

    public <T> T start(String sql, Executor<T> executor) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            throw new ExistStorageException(sql);
        }
    }
}


