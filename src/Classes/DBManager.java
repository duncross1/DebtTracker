/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**DBManager Class
 * This class handles all the interaction with the access database
 *
 * Ross Duncan
 * 30/04/2020
 */
public class DBManager {
    
    
    public boolean removeDebt(int debtIDIn)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            Statement stmt = conn.createStatement();
            
            //Get every row in the Debts table where the Debtee equals the passed in ID
            ResultSet rs = stmt.executeQuery("SELECT * FROM Debts WHERE DebtID = '" + String.valueOf(debtIDIn) + "'");
            
            if(rs.next())
            {
                //Loop through and remove any rows returned by the query above
                stmt.executeUpdate("DELETE FROM Debts WHERE DebtID = '" + String.valueOf(debtIDIn) + "'");
                conn.close();
                return true;
            }
            else
            {
                conn.close();
                return false;
            }  
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public boolean removeAllDebtsWithID(int debteeIDIn)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            Statement stmt = conn.createStatement();
            
            //Get every row in the Debts table where the Debtee equals the passed in ID
            ResultSet rs = stmt.executeQuery("SELECT * FROM Debts WHERE Debtee = '" + String.valueOf(debteeIDIn) + "'");
            
            if(rs.next())
            {
                //Loop through and remove any rows returned by the query above
                stmt.executeUpdate("DELETE FROM Debts WHERE Debtee = '" + String.valueOf(debteeIDIn) + "'");
                conn.close();
                return true;
            }
            else
            {
                conn.close();
                return false;
            }  
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public boolean removeDebtee(int debteeIDIn)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            Statement stmt = conn.createStatement();
            
            //Get every row in the people table where the PeopleID equals the passed in ID
            ResultSet rs = stmt.executeQuery("SELECT * FROM People WHERE PeopleID = '" + String.valueOf(debteeIDIn) + "'");
            
            //Call the removeDebtsWithID function, which will remove any debts tied to the debtee about to be removed
            removeAllDebtsWithID(debteeIDIn);
            
            //Loop through and remove any rows returned by the query above
            if(rs.next())
            {
                stmt.executeUpdate("DELETE FROM People WHERE PeopleID = '" + String.valueOf(debteeIDIn) + "'");
                conn.close();
                return true;
            }
            else
            {
                conn.close();
                return false;
            }  
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public boolean addDebt(Debt newDebt)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            
            //Create a new blank query statement
            Statement stmt = conn.createStatement();
            
            //Add a new row to the debt tables with passed in values
            stmt.executeUpdate("INSERT INTO Debts (Debtee, DebtName, Notes, Amount, DOD) " +
                "VALUES ('" + newDebt.getDebteeID() + "','" + newDebt.getDebtName() + 
                     "','" + newDebt.getNotes() + "','" + newDebt.getAmount() + "','" + newDebt.getDOD() + "')");
            //close database connection and return true
            conn.close();
            return true;
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public HashMap<Integer, Debt> loadIndividualDebts(HashMap<Integer, Debt> debts, int DebteeID)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            
            //Create a new blank query statement
            Statement stmt = conn.createStatement();
            
            //Returns all rows of the debts table in the database and assigns them to resultSet 'rs'
            ResultSet rs = stmt.executeQuery("SELECT * FROM Debts WHERE Debtee = '" + String.valueOf(DebteeID) + "'");
            
            //Loop through the results set
            while(rs.next())
            {
                //Create a new person using a row of database data
                Debt newDebt = new Debt(rs.getInt("DebtID"), rs.getInt("Debtee"), rs.getString("DebtName"), rs.getString("Notes"), rs.getDouble("Amount"), rs.getDate("DOD"));
                
                debts.put(newDebt.getDebtID(), newDebt);
            }
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            
        }
        finally
        {
            return debts;
        }
    }
    
    public boolean addPerson(Person newPerson)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            
            //Create a new blank query statement
            Statement stmt = conn.createStatement();
            
            //Add a new row to the person tables with passed in values
            stmt.executeUpdate("INSERT INTO People (FirstName, LastName, Notes) " +
                "VALUES ('" + newPerson.getFirstName() + "','" + newPerson.getLastName() + "','"  + newPerson.getNotes() + "')");
            //close database connection and return true
            conn.close();
            return true;
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public HashMap<Integer, Person> loadPeople(HashMap<Integer, Person> debtees)
    {
        try
        {
            //Form a connection to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://data\\DTD.accdb");
            
            //Create a new blank query statement
            Statement stmt = conn.createStatement();
            
            //Returns all rows of the people table in the database and assigns them to resultSet 'rs'
            ResultSet rs = stmt.executeQuery("SELECT * FROM People");
            
            //Loop through the results set
            while(rs.next())
            {
                //Create a new person using a row of database data
                Person newPerson = new Person(rs.getInt("PeopleID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Notes"));
                
                debtees.put(newPerson.getPeopleID(), newPerson);
            }
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            
        }
        finally
        {
            return debtees;
        }
    }
    
}
