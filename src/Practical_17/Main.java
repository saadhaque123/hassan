
package Practical_17;

import java.util.HashMap;
import java.util.Map;

// Class User to create a phone book instance and subsequently inserts, updates, removes, and prints phone book entries
class User {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        PhoneBookEntry entry1 = new PhoneBookEntry("David Beckham", "123-456-7890", "davidbeckham@email.com", "125 Mill St");
        PhoneBookEntry entry2 = new PhoneBookEntry("Will Smith", "098-765-4321", "willsmith@email.com", "446 `Green Ave");
        PhoneBookEntry entry3 = new PhoneBookEntry("Christiano Ronaldo", "111-111-1111", "christianoronaldo@email.com", "779 Willow St");

        // Inserting entries into phone book
        phoneBook.insert(entry1);
        phoneBook.insert(entry2);
        phoneBook.insert(entry3);

        // Print all entries in phone book
        phoneBook.printAll();

        System.out.println("\nUpdating entry for David Beckham...\n");

        // Updating phone number for David Beckham
        entry1.setPhoneNumber("111-111-1111");
        phoneBook.update(entry1);

        // Print all entries in phone book
        phoneBook.printAll();

        System.out.println("\nSearching for entry for Will Smith...\n");

        // Searching for entry for Jane Smith
        phoneBook.search("Will Smith");

        System.out.println("\nDeleting entry for Christiano Ronaldo...\n");

        // Deleting entry for Bob Johnson
        phoneBook.delete("Christiano Ronaldo");

        // Print all entries in phone book
        phoneBook.printAll();
    }
}
