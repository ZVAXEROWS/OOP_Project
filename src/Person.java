import java.util.*;

public class Person{
    public int ID;
    public String name;
    public String role;
    public String Email;

    private final String password;

    public Person(int id, String name, String Email, String password, String role){
        ID = id;
        this.name = name;
        this.role = role;
        this.Email = Email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    static public List<String> Login(List<Person> people)
    {
        boolean userFound = false;
        Scanner reader = new Scanner(System.in);
        List<String> values = new ArrayList<>();

        do {
            String email;
            String password;
            System.out.print("Enter your Email: ");
            email = reader.nextLine();
            System.out.print("Enter your password: ");
            password = reader.nextLine();

            for (Person person : people) {
                if (email.equals(person.Email) && password.equals(person.getPassword())) {
                    values.add(String.valueOf(person.ID));
                    values.add(String.valueOf(person.name));
                    values.add(String.valueOf(person.Email));
                    values.add(String.valueOf(person.getPassword()));
                    values.add(String.valueOf(person.role));
                    userFound = true;
                    break;
                }
            }
        }
        while(!userFound);

        return values;
    }
}


