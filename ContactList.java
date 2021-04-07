
import java.util.Arrays;
public class ContactList {
    private Contact[] contacts;
    private int used;

    public ContactList() {
        contacts = new Contact[150];
        used  = 0;

    }

    public ContactList(int capacity) {
         contacts = new Contact[capacity];
        used  = 0;
    }

    public boolean add(Contact aContact) {
        if(used < contacts.length) {
            contacts[used] = aContact;
            used++;
            return true;
        }
        return false;
    }

    public String nameFor(String number) {
        // Use the overloaded method to do the actual work and return whatever it returns
        return nameFor(number,0);
    }

    
    public String nameFor(String number, int startPos) {
        int i = 0;
        if(startPos >= 0) {
            for(i = startPos; i < used; i++) {
                if(contacts[i].getPhoneNumber().compareTo(number) == 0) {
                    return contacts[i].getContactName();
                }
            }
        }
        return "";
    }

     
    public String numberFor(String name) {
        return numberFor(name,0);
    }

    
    public String numberFor(String name, int startPos) {
        int i = 0;
        if(startPos >= 0) {
            for(i = startPos; i < used; i++) {
                if(contacts[i].getContactName().indexOf(name) != -1) {

                    return contacts[i].getPhoneNumber();
                }
            }
        }
        return "";
    }

    public boolean remove(String name){
        //This method firstly cycles through each of the used spaces in the array
        //if the String name is equal to another name in the arrays it uses a nested for loop to move all the objects after it down a space
        //and remove it
        for(int n = 0; n<used; n++){
            if(contacts[n].getContactName().compareTo(name) == 0){
                for (int i = n; i < contacts.length - 1; i++) {
                    contacts[i] = contacts[i + 1];
                }
                used--;
                return true;

            }
        }
        return false;
    }

    public boolean remove(int position){
        //overloaded remove method that takes an integer and and removes an object from that position in the array
        //if int position is between 0 and used a for loop is used to move all the objects after it down a space and remove it
        //if int position is greater or less than used return false
        if(position<=used && position>=0){
            for(int i = position; i < contacts.length - 1; i++) {
                contacts[i] = contacts[i + 1];
            }
            used--;
            return true;
        }
        return false;
    }
    
    public void sort(){
        //uses the compareTo method in the contact class to compare contact names and lists the objects in the array according to their natural ordering
        //Arrays.sort uses compareTo
        Arrays.sort(contacts, 0, used);

    }
    
    public void display() {
        for(int i = 0; i < used; i++) {

            System.out.printf("Contact %d of %d\n",i+1,used);
            System.out.println(contacts[i]);
        }
    }
}
