/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.Map;

/**Person Class
 * This data class is for containing information about debtees
 *
 * @author Ross Duncan
 * 30/04/2020
 */
public class Person {
    //Attributes
    private int peopleID;
    private String firstName;
    private String lastName;
    private String notes;
    private double totalDebt;
    
    //Getters
    public int getPeopleID()
    {
        return peopleID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getNotes()
    {
        return notes;
    }
    
    public double getTotalDebt()
    {
        return totalDebt;
    }
    
    //Setters
    public void setPeopleID(int peopleIDIn)
    {
        peopleID = peopleIDIn;
    }
    
    public void setFirstName(String firstNameIn)
    {
        firstName = firstNameIn;
    }
    
    public void setLastName(String lastNameIn)
    {
        lastName = lastNameIn;
    }
    
    public void setNotes(String notesIn)
    {
        notes = notesIn;
    }
    
    public void setTotalDebt(double totalDebtIn)
    {
        totalDebt = totalDebtIn;
    }
    
    //Constructor
    public Person()
    {
        firstName = "";
        lastName = "";
        notes = "";
        totalDebt = 0;
    }
    
    //Overloaded Constructors
    public Person(String firstNameIn, String lastNameIn, String notesIn)
    {
        firstName = firstNameIn;
        lastName = lastNameIn;
        notes = notesIn;
        calculateTotalDebt();
    }
    
    public Person(int peopleIDIn, String firstNameIn, String lastNameIn, String notesIn)
    {
        peopleID = peopleIDIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
        notes = notesIn;
        calculateTotalDebt();
    }
    
    //Methods
    public void calculateTotalDebt()
    {
        //Get a hashmap of all debts this debtee has
        DBManager db = new DBManager();
        HashMap<Integer, Debt> debts = new HashMap<>();
        debts = db.loadIndividualDebts(debts, peopleID);
        
        //Set total debt to 0
        totalDebt = 0;
        //Loop through debts hashmap and add each debt value to the total debt
        for(Map.Entry<Integer, Debt> entry : debts.entrySet())
        {
            totalDebt = totalDebt + entry.getValue().getAmount();
        }
    }
}
