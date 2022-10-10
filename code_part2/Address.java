public class Address
{
    // Instance variables
    private String street;
    private int number;
    private String postal;

    // Constructor
    public Address(String street, int number, String postal)
    {
        this.street = street;
        this.number = number;
        this.postal = postal;
    }

    public String toString()
    {
        return number + " " + street + ", " + postal;
    }
}