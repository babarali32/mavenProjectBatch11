package utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class dButils {
    public static List<Map<String,String>> getTableData(String query) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData=null;
        List<Map<String,String >> tableData = null;
        try {
            connection = DriverManager.getConnection(configReader.getvalue("dBurl"),configReader.getvalue("dBusername"),configReader.getvalue("dBpassword"));
            System.out.println(connection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSetMetaData=resultSet.getMetaData();

             tableData=new ArrayList<>();
            while (resultSet.next()) {
                Map<String,String> row=new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    System.out.println("Column Name: "+columnName+" ");
                    String rows =resultSet.getString(resultSetMetaData.getColumnName(i));
                    row.put(resultSetMetaData.getColumnName(i), resultSet.getString(resultSetMetaData.getColumnName(i)));
                }

                tableData.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return tableData;
    }
}