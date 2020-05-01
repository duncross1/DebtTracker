/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

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
    
    //Constructor
    public Person()
    {
        firstName = "";
        lastName = "";
        notes = "";
    }
    
    //Overloaded Constructors
    public Person(String firstNameIn, String lastNameIn, String notesIn)
    {
        firstName = firstNameIn;
        lastName = lastNameIn;
        notes = notesIn;
    }
    
    public Person(int peopleIDIn, String firstNameIn, String lastNameIn, String notesIn)
    {
        peopleID = peopleIDIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
        notes = notesIn;
    }
}
