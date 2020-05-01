/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;
import java.time.LocalDate;

/**Debt Class
 *This data class is for storing information about individual debts
 * @author Ross Duncan
 * 01/05/2020
 */
public class Debt {
    //Attributes
    private int debtID;
    private int debteeID;
    private String debtName;
    private String notes;
    private double amount;
    private Date DOD;
    
    //Getters
    public int getDebtID()
    {
        return debtID;
    }
    
    public int getDebteeID()
    {
        return debteeID;
    }
    
    public String getDebtName()
    {
        return debtName;
    }
    
    public String getNotes()
    {
        return notes;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public Date getDOD()
    {
        return DOD;
    }
    
    //Setters
    public void setDebtID(int debtIDIn)
    {
        debtID = debtIDIn;
    }
    
    public void setDebteeID(int debteeIDIn)
    {
        debteeID = debteeIDIn;
    }
    
    public void setDebtName(String debtNameIn)
    {
        debtName = debtNameIn;
    }
    
    public void setNotes(String notesIn)
    {
        notes = notesIn;
    }
    
    public void setAmount(double amountIn)
    {
        amount = amountIn;
    }
    
    public void setDOD(Date DODIn)
    {
        DOD = DODIn;
    }
    
    //Constructor
    public Debt()
    {
        debtID = -1;
        debteeID = -1;
        debtName = "";
        notes = "";
        amount = 0.00;
        DOD = Date.valueOf(LocalDate.now());
    }
    
    //Overloaded Constructors
    public Debt(int debteeIDIn, String debtNameIn, String notesIn, double amountIn, Date DODIn)
    {
        debteeID = debteeIDIn;
        debtName = debtNameIn;
        notes = notesIn;
        amount = amountIn;
        DOD = DODIn;
    }
    
    public Debt(int debtIDIn, int debteeIDIn, String debtNameIn, String notesIn, double amountIn, Date DODIn)
    {
        debtID = debtIDIn;
        debteeID = debteeIDIn;
        debtName = debtNameIn;
        notes = notesIn;
        amount = amountIn;
        DOD = DODIn;
    }
}
