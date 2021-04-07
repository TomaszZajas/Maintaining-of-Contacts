//Name = Tomasz Zajas
//Student No. = 20278748
//!! I am using the contact class given to us in the sample programs and just adding the compareTo !!


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
        //this.contactName = contactName;
        //this.phoneNumber = "";
        //this.emailAddress = "";
        //this.facebookHandle = "";
        //this.instagramHandle = "";
        //this.twitterHandle = "";
        // Alternatively

        this(contactName,"","","","","");
    }

    public Contact(String contactName, String phoneNumber) {
        //this.contactName = contactName;
        //this.phoneNumber = phoneNumber;
        //this.emailAddress = "";
        //this.facebookHandle = "";
        //this.instagramHandle = "";
        //this.twitterHandle = "";
        // Alternatively

        this(contactName,phoneNumber,"","","","");
    }

    public Contact(String contactName, String phoneNumber, String emailAddress) {
        //this.contactName = contactName;
        //this.phoneNumber = phoneNumber;
        //this.emailAddress = emailAddress;
        //this.facebookHandle = "";
        //this.instagramHandle = "";
        //this.twitterHandle = "";
        // Alternatively

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
        // If 'text' is longer/wider than the specified 'width' we return 
        // the leftmost 'width' characters from the 'text' String.
        if(text.length() > width) {
            return text.substring(0,width);
        }
        // Otherwise, weed to 'centre' the 'text' in a String that is 'width' wide/long.
        // So we calculate how many spaces are required in total.
        int totalSpacesRequired = width - text.length();
        // Now calculate how many spaces are required on each side.
        // If 'totalSpacesRequired' is even we put the same number of spaces on each side.
        // However, if 'totalSpacesRequired' is odd we put the extra space on the left side.
        if(totalSpacesRequired % 2 == 0) {
            // It's even
            // We can use our 'repeat' operation to create the space String required for each side.
            return repeat(FILLER,totalSpacesRequired/2) + text + repeat(FILLER,totalSpacesRequired/2);
        } else {
            // It's odd so we have added one additional space on the left hand side
            // We can use our 'repeat' operation to create the space String required for each side.
            return repeat(FILLER,totalSpacesRequired/2 + 1) + text + repeat(FILLER,totalSpacesRequired/2);
             //                                           ^ additional space
        }            
    }

    private String expand(String text, int width) {
        // If 'text' is already 'width' characters OR if it is longer than 'width' characters
        // we can just return a String that contains the first 'width' characters in 'text'.
        if(text.length() >= width) {
             return text.substring(0,width);
        }
        // If we reach this point then 'text' is shorter than 'width' we just need to add sufficient
        // spaces to fill it out with spaces so that its length is 'width'
        // We can use our 'repeat' operation to create the space String required.
        return text + repeat(FILLER, width - text.length());
    }

    private String repeat(String text, int times) {
        // 'repeatString' is the String that will be returned by the method
        String repeatString = "";
        // 'i' is a counter to ensure we repeat the correct number of times
        // NOTE: If 'times' is negative or zero the 'for' loop WILL NOT EXECUTE
        //       because the initial value of 'i' is 0 and that will NOT be less
        //       than a negative number or 0. 
        int i;
        // Add 'times' copies of the 'text' String to the 'repeatString'
        for(i = 0; i < times; i++) {
            repeatString = repeatString + text;
        }
        // Return the value of 'repeatString'
        return repeatString;
    }

    private String trim(String text, int width) {
        /*
         *
         * The code required for this method is EXACTLY the same as the code in our 'expand'
         * method above. So, instead of duplicating the code we can REUSE the code in the 'expand'
         * method by just using the 'expand' method here in the 'trim' method! 
         *
         * So we just return whatever answer we get from the 'trim' method as the answer from the 
         * 'expand' method.
         */
        return expand(text,width);
    }

    public int compareTo(Contact other) {
        //This method uses compareTo to compare one contact with another contact
        //if greater it returns 1
        //if less than it returns -1
        //if equal it returns 0
        //This is used by the Arrays.sort in the ContactList class
        return this.contactName.compareTo(other.contactName);
      }
}

