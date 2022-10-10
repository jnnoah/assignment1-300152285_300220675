public class Employee
{
    // Instance variables
    private String name;
    private double hours;
    private double rate;
    private Address[] address;

    // Constructor
    public Employee(String name, double hours, double rate, Address[] address)
    {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.address = address;
    }

    public String toString()
    {
        String addresses = "";
        int i = 0;

        // Concatinating all addresses of an employee
        while(address[i] != null)
        {
            addresses += "\n" + address[i];
            i++;
        }
        
        return name + "'s addresses are: " + addresses;
    }

}