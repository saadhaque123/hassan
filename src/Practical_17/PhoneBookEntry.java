package Practical_17;

// Class PhoneBookEntry to store details of a phone book entry
public class PhoneBookEntry {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    public PhoneBookEntry(String fullName, String phoneNumber, String email, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Creates a human friendly representation of the class
    @Override
    public String toString() {
        return "Full Name: " + fullName + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nAddress: " + address;
    }
}
