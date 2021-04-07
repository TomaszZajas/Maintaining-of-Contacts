//Name = Tomasz Zajas
//Student No. = 20278748

import java.util.Arrays;
public class TestContactList{
    public static void main(String[] args){
        ContactList test = new ContactList();
        ContactList test2 = new ContactList(5);
        
        Contact TestOne = new Contact("Johann", "", "j@gmail.com", "", "jh20", "");
        Contact TestTwo = new Contact("Diego Armando Maradona is a legend", "0892369049");
        Contact TestThree = new Contact("Tomasz Zajas", "", "tomek.zajas03@gmail.com");
        Contact TestFour = new Contact("Tomek Zajas", "+353892369049", "tomek.zajas03@gmail.com", "", "tomek_zajas", "TomekZ20");
        Contact TestFive = new Contact("Tomasz", "9999999999", "tomek.zajas@gmail.com", "", "", "TomekZ20");
        Contact TestSix = new Contact("Zajas", "123456789", "tomek.zajas@gmail.com", "Tomek Zajas", "tomek_zajas", "TomekZ20");
        Contact TestSeven = new Contact("Messi", "123456", "messi@goat.ul.ie", "LeoMessi", "", "");
        
        test.add(TestOne);
        test.add(TestTwo);
        test.add(TestThree);
        test.add(TestFour);
        test.add(TestFive);
        test.add(TestSix);
        test.add(TestSeven);
        
        test.remove("Tomasz");
        test.remove(3);
        
        test.sort();
        test.display();
        
       
    }
}