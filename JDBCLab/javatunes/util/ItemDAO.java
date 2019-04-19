/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */

package JDBCLab.javatunes.util;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;

public class ItemDAO
{
   // connection to the database (assumed to be open)
   private Connection m_conn = null;
   
   //// PreparedStatement Lab ////
   //-- declare the PreparedStatement for searchByKeyword --//
   PreparedStatement pstmt;
   
   //// Update Lab ////
   //-- declare the PreparedStatement for create --//
   PreparedStatement stmt;
   
   
   // constructor
   public ItemDAO(Connection conn)
   throws SQLException
   {
      // store the connection
      m_conn = conn;
      
      //// PreparedStatement Lab ////
      //-- define the ?-SQL for searchByKeyword --//
       String sql = "Select * From Item Where Title Like ?";
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
       pstmt = m_conn.prepareStatement(sql);
      
      //// Update Lab ////
      //-- define the ?-SQL for create --//
      sql = "Insert Into Item (Title, Artist, ReleaseDate, ListPrice, Price, Version) " +
              "Values (?, ?, ?, ?, ?, ?)";
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      stmt = m_conn.prepareStatement(sql);
   }
   
   
   //// DAO Lab ////
   public MusicItem searchById(Long id)
   throws SQLException
   {
      // declare return value
      MusicItem result = null;
      
      // declare JDBC objects
      Statement stmt = null;
      
      //-- build the SQL statement --//
      String sql = "Select * From Item Where ITEM_ID = " + id.toString();
      
      try
      {
         //-- initialize the Statement object --//
         stmt = m_conn.createStatement();
         
         //-- execute the SQL statement, get a ResultSet back --//
         ResultSet rs = stmt.executeQuery(sql);
         
         //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
         //-- if ID not found, the return value remains null --//
         if (rs.next())
            result = new MusicItem(
                (long) rs.getInt("ITEM_ID"),
                rs.getString("Title"),
                rs.getString("Artist"),
                rs.getString("ReleaseDate"),
                rs.getBigDecimal("ListPrice"),
                rs.getBigDecimal("Price")
            );
      }
      finally
      {
         //-- close the Statement - this closes its ResultSet --//
         stmt.close();
      }
      
      // return the value object
      return result;
   }
   
   
   //// PreparedStaement Lab ////
   public Collection<MusicItem> searchByKeyword(String keyword)
   throws SQLException
   {
      // create storage for the results
      Collection<MusicItem> result = new ArrayList<>();
      
      // create the %keyword% wildcard syntax used in SQL LIKE operator
      String wildcarded = "%" + keyword + "%";
      
      //-- set the ? parameters on the PreparedStatement --//
      pstmt.setString(1, wildcarded);

      //-- execute the PreparedStatement, get a ResultSet back --//
      ResultSet rs = pstmt.executeQuery();
      
      //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
      //-- add the ItemValue to the Collection via Collection's add method --//
      while (rs.next()) {
          result.add(new MusicItem(
              (long) rs.getInt("ITEM_ID"),
              rs.getString("Title"),
              rs.getString("Artist"),
              rs.getString("ReleaseDate"),
              rs.getBigDecimal("ListPrice"),
              rs.getBigDecimal("Price")
          ));
      }
      
      // return the Collection
      return result;
   }
   
   
   //// Update Lab ////
   public void create(MusicItem item)
   throws SQLException
   {
        // Use the following releaseDate value in the  prepared statement for setDate
        java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
        //-- set the ? parameters on the PreparedStatement --//
        stmt.setString(1, item.getTitle());
        stmt.setString(2, item.getArtist());
        stmt.setDate(3, releaseDate);
        stmt.setBigDecimal(4, item.getListPrice());
        stmt.setBigDecimal(5, item.getPrice());
        stmt.setInt(6, 1);

      
        //-- execute the PreparedStatement - ignore the update count --//
        int count = stmt.executeUpdate();
        System.out.println(count + " rows were inserted");
   }
   
   
   //// PreparedStatement and Update Labs ////
   public void close()
   {
      /*
      REMOVE this comment in PreparedStatement Lab
      try
      {
         //// PreparedStatement Lab ////
         //-- close the PreparedStatement for searchByKeyword --//
         
         
         //// Update Lab ////
         //-- close the PreparedStatement for create --//
         
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
      REMOVE this comment in the PreparedStatement Lab
      */
   }
}
