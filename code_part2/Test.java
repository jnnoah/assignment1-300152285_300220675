public class Test
{
    public static void main(String[] args)
    {
        Employee employee;
        Address[] addresses = new Address[5];
        addresses[0] = new Address("Queen", 48, "K1P1N2");
        addresses[1] = new Address("King Edward", 800, "K1N6N5");
        
        employee = new Employee("Falcao", 40, 15.50, addresses);

        System.out.println(employee);
    }
}