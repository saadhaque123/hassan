package Practical_17;

import java.util.HashMap;
import java.util.Map;

// Class PhoneBook to store phone book entries in a map
public class PhoneBook {
    private Map<String, PhoneBookEntry> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Inserts phone book entry into the map
    public void insert(PhoneBookEntry entry) {
        phoneBook.put(entry.getFullName(), entry);
    }

    // Updates phone book entry in the map
    public void update(PhoneBookEntry entry) {
        phoneBook.replace(entry.getFullName(), entry);
    }

    // Deletes phone book entry from the map
    public void delete(String fullName) {
        phoneBook.remove(fullName);
    }

    // Prints the details of an existing entry by searching the phone book based on a given full name
    public void search(String fullName) {
        if (phoneBook.containsKey(fullName)) {
            System.out.println(phoneBook.get(fullName).toString());
        } else {
            System.out.println("Entry not found.");
        }
    }

    // Prints all entries within the phone book
    public void printAll() {
        for (Map.Entry<String, PhoneBookEntry> entry : phoneBook.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
