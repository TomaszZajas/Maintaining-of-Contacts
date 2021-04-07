
import java.util.Arrays;
public class Contact implements Comparable<Contact>{

    // Useful Named 'static' Constants
    private static final int HEADING_WIDTH = 17;
    private static final int DATA_WIDTH = 30;
    private static final String TRUNCATED_ELLIPSE = "...";
    private static final String NEWLINE = "\n";
    private static final String FILLER = " ";

    // Instance Variables
    public String contactName;
    private String phoneNumber;
    private String emailAddress;
    private String facebookHandle;
    private String instagramHandle;
    private String twitterHandle;

    public Contact(String contactName) {
       

        this(contactName,"","","","","");
    }

    public Contact(String contactName, String phoneNumber) {
    

        this(contactName,phoneNumber,"","","","");
    }

    public Contact(String contactName, String phoneNumber, String emailAddress) {
        

        this(contactName,phoneNumber,emailAddress,"","","");
    }

    public Contact(String contactName, String phoneNumber, String emailAddress, String facebookHandle, String instagramHandle, String twitterHandle) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.facebookHandle = facebookHandle;
        this.instagramHandle = instagramHandle;
        this.twitterHandle = twitterHandle;

    }

    public String toString() {
        String layoutHeading = "";
        return layoutHeading +
        formatLine("Name",contactName) +
        formatLine("Phone Number",phoneNumber) +
        formatLine("Email Address",emailAddress) +
        formatLine("Facebook Handle",facebookHandle) +
        formatLine("Instagram Handle",instagramHandle) +
        formatLine("Twitter Handle",twitterHandle);
    }

    //Mutators and Accessors
    public void setContactName(String contactName) {
         this.contactName = contactName;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
         return this.phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
         this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
         return this.emailAddress;
    }

    public void setFacebookHandle(String facebookHandle) {
         this.facebookHandle = facebookHandle;
    }

    public String getFacebookHandle() {
         return this.facebookHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
         this.instagramHandle = instagramHandle;
    }

    public String getInstagramHandle() {
         return this.instagramHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
         this.twitterHandle = twitterHandle;
    }

    public String getTwitterHandle() {
         return this.twitterHandle;
    }

    //Helper Methods

    private String formatLine(String heading, String data) {
        if(data.length() == 0) {
            return "";
        }

        String dataID = String.format("%-"+HEADING_WIDTH+"s: ",heading);
        //String dataID = expand(heading,HEADING_WIDTH) + ": ";
        if(data.length() > DATA_WIDTH) {
            return dataID + 
            trim(data,DATA_WIDTH - TRUNCATED_ELLIPSE.length()) + 
            TRUNCATED_ELLIPSE + NEWLINE;
        }
        return dataID + centre(data,30) + NEWLINE;
    }

    private  String centre(String text, int width) {
     
        if(text.length() > width) {
            return text.substring(0,width);
        }
      
        int totalSpacesRequired = width - text.length();

        if(totalSpacesRequired % 2 == 0) {
         
            return repeat(FILLER,totalSpacesRequired/2) + text + repeat(FILLER,totalSpacesRequired/2);
        } else {
            de.
            return repeat(FILLER,totalSpacesRequired/2 + 1) + text + repeat(FILLER,totalSpacesRequired/2);
             //                                           ^ additional space
        }            
    }

    private String expand(String text, int width) {
     
        if(text.length() >= width) {
             return text.substring(0,width);
        }
 
        return text + repeat(FILLER, width - text.length());
    }

    private String repeat(String text, int times) {
       
        String repeatString = "";
     
       
        for(i = 0; i < times; i++) {
            repeatString = repeatString + text;
        }
        // Return the value of 'repeatString'
        return repeatString;
    }

    private String trim(String text, int width) {
      
        return expand(text,width);
    }

    public int compareTo(Contact other) {
      
        return this.contactName.compareTo(other.contactName);
      }
}

