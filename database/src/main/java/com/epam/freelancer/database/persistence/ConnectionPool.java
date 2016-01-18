package com.epam.freelancer.database.persistence;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {

    public static final Logger LOG = Logger.getLogger(ConnectionPool.class);
    private BlockingQueue<Connection> pool;
    private AtomicInteger currentPoolSize = new AtomicInteger();
    private int maxPoolSize;
    private int initialPoolSize;
    private String driverClassName;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public ConnectionPool() throws SQLException, ClassNotFoundException {
        this.driverClassName = "com.mysql.jdbc.Driver";
        this.dbUrl = "jdbc:mysql://127.0.0.1:3306/freelancerdb?characterEncoding=UTF-8";
        this.dbUser = "root";
        this.dbPassword = "root";
        this.maxPoolSize = 10;
        this.initialPoolSize = 1;
        pool = new LinkedBlockingQueue<>(maxPoolSize);

        initPooledConnections();

        if (pool.size() != initialPoolSize) {
            LOG.warn("Initial sized pool creation failed.");
        }
    }

    public ConnectionPool(Properties properties) throws SQLException, ClassNotFoundException {
        this.driverClassName = properties.getProperty("driver");
        this.dbUrl = properties.getProperty("dbUrl");
        this.dbUser = properties.getProperty("dbUser");
        this.dbPassword = properties.getProperty("dbPassword");

        String max = properties.getProperty("maxPoolSize");
        if (max == null || "0".equals(max))
            this.maxPoolSize = 10;
        else
            this.maxPoolSize = Integer.parseInt(max);

        String init = properties.getProperty("initialPoolSize");
        if (init == null || init.equals(this.maxPoolSize))
            this.initialPoolSize = this.maxPoolSize / 2;
        else
            this.initialPoolSize = Integer.parseInt(init);

        pool = new LinkedBlockingQueue<>(maxPoolSize);

        initPooledConnections();

        if (pool.size() != initialPoolSize) {
            LOG.warn("Initial sized pool creation failed.");
        }
    }


    private void initPooledConnections() throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);

        for (int i = 0; i < initialPoolSize; i++) {
            openAndPoolConnection();
        }
    }

    private synchronized void openAndPoolConnection() throws SQLException {
        if (currentPoolSize.intValue() == maxPoolSize) {
            return;
        }

        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        pool.offer(new CustomConnection(conn, this));
        currentPoolSize.incrementAndGet();
    }

    public Connection borrowConnection() throws InterruptedException, SQLException {

        if (currentPoolSize.intValue() < maxPoolSize) {
            openAndPoolConnection();
        }
        // Borrowing thread will be blocked till connection
        // becomes available in the queue
        return pool.take();
    }

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "maxPoolSize=" + maxPoolSize +
                ", initialPoolSize=" + initialPoolSize +
                ", driverClassName='" + driverClassName + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                ", dbUser='" + dbUser + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                '}';
    }

    public void surrenderConnection(Connection conn) {
        if (!(conn instanceof CustomConnection)) {
            return;
        }
        pool.offer(conn); // offer() as we do not want to go beyond capacity
    }
}
