package DBUtilities;

import java.sql.*;
import java.util.*;

public class SQLDatabase {
    Connection conn;
    Statement statement;
    String url;
    String username;
    private String password;
    String host;

    int port;

    private static SQLDatabase instance = null;

    SQLDatabase() {
        // do not thing!!
    }

    // Initialize and connect to mysql server
    public SQLDatabase(String host, int port, String user, String pass, String database) {
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
    public static SQLDatabase instance() throws SQLException {
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
        // Reference: https://gist.github.com/cworks/4175942
        var md = rs.getMetaData();
        var columns = md.getColumnCount();
        var rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            var row = new HashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
    
    public void insert(String table,Map<String,Object> data) throws SQLException {
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
        statement.executeUpdate(sql);
    }

    public void update(String table,int id,Map<String,Object> data) throws SQLException {
        String values = "";
        for (Map.Entry<String,Object> entry : data.entrySet()){
            values+=entry.getKey()+"='"+entry.getValue()+"',";
        }
        StringBuffer sb= new StringBuffer(values);
        sb.deleteCharAt(sb.length()-1);
        values = sb.toString();
        String sql = "Update "+table+ " set "+ values+" where id="+id;
        statement.executeUpdate(sql);
    }

    public void updateStatus(String table,int id,boolean status) throws SQLException {
        String sql = "Update "+table+ " set is_enable="+ status +" where id="+id;
        statement.executeUpdate(sql);
    }

    public void delete(String table,int id) throws SQLException {
        String sql = "Delete from "+table+" where id="+id;
        statement.executeUpdate(sql);
    }

    // How to use?
    // you can call the function with a table as argument
    // Example: I have an "employee" table. It will access into database then returns a list of employees.
    // var employees = findAll("employee");
    public List<Map<String, Object>> findAll(String table) {
        var sql = "Select * from " + table;

        List<Map<String, Object>> list = null;
        ResultSet rs;
        try {
            rs = this.statement.executeQuery(sql);

            list = this.resultSetToList(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    // can run but it has not been optimized :)
    public Map<String, Object> findOneUser(String table, String user, String pass) {
        var sql = "select * from "+table+" where" +
                " username = \"" +
                user + "\"and password = \"" + pass + "\"";

        List<Map<String, Object>> list = null;
        Map<String, Object> result = null;
        ResultSet resultSet;
        try {
            resultSet = this.statement.executeQuery(sql);

            if (resultSet == null) return null;

            list = this.resultSetToList(resultSet);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        for (var item : list) {
            result = item;
            break;
        }

        return result;
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

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
