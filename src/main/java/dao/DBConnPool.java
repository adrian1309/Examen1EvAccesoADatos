package dao;

import config.JDBCProperties;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnPool {
    public static DBConnPool dbConnectionPool = null;
    public BasicDataSource pool = null;

    public DBConnPool()
    {
        super();
        pool = this.getPool();
    }

    public void rollBackSQL(Connection dbConnection){
        try {
            dbConnection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnPool getInstance(){
        if (dbConnectionPool == null) {
            dbConnectionPool = new DBConnPool();
        }

        return dbConnectionPool;
    }


    public static void closePool(BasicDataSource dbConnectionPool) throws SQLException {
        System.out.println("Releasing all open resources ...");
        if (dbConnectionPool != null) {
            dbConnectionPool.close();
            dbConnectionPool = null;
        }
    }

    public static void printSQLException(SQLException e) {

        while (e != null) {
            if (e instanceof SQLException) {
                //ANSI SQLState
                e.printStackTrace(System.err);
                System.err.println("SQLState: "
                        + e.getSQLState());

                //Error code from the DBMS
                System.err.println("Error Code: "
                        + e.getErrorCode());

                //Text message
                System.err.println("Message: " + e.getMessage());

                //Objects that trigger the exception
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                //Any other exceptions caused by this one
                e = e.getNextException();

            }
        }
    }

    public BasicDataSource getPool() {

        JDBCProperties properties = new JDBCProperties();
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUsername(properties.getUserName());
        basicDataSource.setPassword(properties.getPassword());
        basicDataSource.setUrl(properties.getUrlDB());
        // Sets the size of the dbConnectionPool. Optional, default value is 10
        basicDataSource.setInitialSize(4);

        // Optional. For validating connection
        basicDataSource.setValidationQuery("select 1");


        System.out.println("Pool created");
        return basicDataSource;
    }

    public Connection getConnection() throws Exception {
        return pool.getConnection();
    }

    public static void closeConnection(Connection connArg) {
        System.out.println("Releasing all open resources ...");
        try {
            if (connArg != null) {
                connArg.close();
                connArg = null;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void releaseResources(Statement stmt, ResultSet rs) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
