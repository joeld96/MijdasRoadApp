
package Mijdas.RoadApp.spring.Models.UserModels;

import Mijdas.RoadApp.spring.Models.ReviewModels.MechanicReview;
import Mijdas.RoadApp.spring.Models.ReviewModels.TransactionModels.TransactionHistory;
import java.util.ArrayList;

public class Mechanic extends User
{
    private Integer quality;
    private int licenseNumber;
    private int mechanicId;
    private ArrayList<MechanicReview> reviews;
    private TransactionHistory transactionHistory;
    
    public Mechanic(String username, String firstName, String lastName, String email, int mechanicId)
    {
        super(username, firstName, lastName, email);
        //quality should display as "Unset" on view.
        this.quality = null; // upon instatiation, quality of stars may not be set
        init();
    }
    
    //Allows for setting of quality on constructor
    public Mechanic(String username, String firstName, String lastName, String email,int mechanicId ,int quality)
    {
        super(username, firstName, lastName, email);
        this.quality = quality; // upon instatiation, quality of stars may not be set
        init();
      
    }
    
    private void init()
    {
        if(reviews == null)
        {
            reviews = new ArrayList<>();
        }
        
        if(transactionHistory == null)
        {   
            transactionHistory = new TransactionHistory(); 
        }
  
    }
        

    /************************SETTERS***************************/
    //Should be set in order to calculate quality
    public void setReviewList(ArrayList<MechanicReview> rList)
    {
        this.reviews = rList;
    }
    public void setLicenseNumber(int licenseNumber)
    {
        this.licenseNumber = licenseNumber;
    }
    
    /**************************************************
     *Calculate quality through average star rating 
     ************************************************/
    private void calcQuality()
    {
        int totalStars = 0;
        
        for(MechanicReview r: reviews)
        {
            totalStars += r.getRating();
        }
        quality = totalStars/ reviews.size();
    }
    

    
    /************************GETTERS***************************/
    public Integer getQuality()
    {   //ensure any request of quality is up-to date
        calcQuality();
        return quality;
    }

    public int getLicenseNumber()
    {
        return licenseNumber;
    }

    public int getMechanicId()
    {
        return mechanicId;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Mechanic{" + "quality=" + quality + ", licenseNumber=" + licenseNumber;
    }
    
    
    
    
    
    
}