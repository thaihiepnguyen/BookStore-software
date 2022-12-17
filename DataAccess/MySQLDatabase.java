package DataAccess;

import java.sql.*;
import java.util.*;

public class MySQLDatabase {
    Connection conn;
    Statement statement;
    String url;
    String username;
    private String password;
    String host;

    int port;

    private static MySQLDatabase instance = null;

    MySQLDatabase() {
        // do not thing!!
    }

    // Initialize and connect to mysql server
    public MySQLDatabase(String host, int port, String user, String pass, String database) {
        username = user;
        password = pass;
        this.host = host;
        this.port = port;
        this.url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            statement = conn.createStatement();

        }catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

        instance = this;
    }

    // Singleton design pattern!
    public static MySQLDatabase getInstance() throws SQLException {
        if (instance != null) {
            return instance;
        } else {
            throw new SQLException("SQL have not been initialized");
        }
    }

    public Statement getStatement() {
        return this.statement;
    }
    public Connection getConn() { return this.conn; }

    // Convert result to list. This is easy for reading and writing into database.
    public List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        var md = rs.getMetaData();
        var columns = md.getColumnCount();
        var rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            var row = new LinkedHashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }

    // How to use?
    // you can call the function with a table as argument
    // Example: I have an "employee" table. It will access into database then returns a list of employees.
    // var employees = findAll("employee");
    public ResultSet findAll(String table) {
        String sql = "Select * from " + table;

        ResultSet entitySet = null;
        try {
            entitySet = this.statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return entitySet;
    }

    public ResultSet findOneUser(String table, String user, String pass) {
        ResultSet entity = null;

        String sql = "select * from "+table+" where username = ? and password = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            entity = preparedStatement.executeQuery();

            if (entity == null) {
                return null;   
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return entity;
    }

    public Map<String, Object> findOne(String table, int id) {
        var sql = "select * from "+table+" where" +
                " id = \"" + id;
        List<Map<String, Object>> list = null;
        Map<String, Object> result = null;
        ResultSet rs;
        try {
            rs = this.statement.executeQuery(sql);

            if (rs == null) return null;

            list = this.resultSetToList(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        for (var item : list) {
            result = item;
            break;
        }

        return result;
    }

    public void insert(String table,Map<String,Object> data) {
        String keys = "(";
        String values = "('";
        for (Map.Entry<String,Object> entry : data.entrySet()){
            keys+=entry.getKey().toString()+",";
            values+=entry.getValue()+"','";
        }
        StringBuffer sb= new StringBuffer(keys);
        sb.deleteCharAt(sb.length()-1);
        keys=sb.toString()+") ";
        sb = new StringBuffer(values);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        values=sb.toString()+")";

        String sql = "Insert into "+table+keys+"values "+values;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String table,int id,Map<String,Object> data) {
        String values = "";
        for (Map.Entry<String,Object> entry : data.entrySet()){
            values+=entry.getKey()+"='"+entry.getValue()+"',";
        }
        StringBuffer sb= new StringBuffer(values);
        sb.deleteCharAt(sb.length()-1);
        values = sb.toString();
        String sql = "Update "+table+ " set "+ values+" where id="+id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
