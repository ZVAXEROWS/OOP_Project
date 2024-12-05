import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle file by store and read data
 */
public class FileHandling <T> {
    File file ;
    static List<Person> people = new ArrayList<>();
    private String fileName;
    public FileHandling(String fileName){

        this.file = new File(fileName);
        this.fileName = fileName;
    }


    /**
     * Store an arrayList of objects
     * @param objects An object to store
     * @throws IOException
     */
    public  void writeObjectList(ArrayList<T> objects) throws IOException {

        FileOutputStream fileout1 = new FileOutputStream(file);   // to append add true
        ObjectOutputStream fileout2 = new ObjectOutputStream(fileout1);
        fileout2.writeObject(objects);
    }

    /**
     * Fun
     * @return ArrayList of objects that stored in the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  ArrayList<T> readObjectList() throws IOException, ClassNotFoundException {

        FileInputStream filein1 = new FileInputStream(file);
        ObjectInputStream filein2 = new ObjectInputStream(filein1);
        ArrayList<T> testArray2 = (ArrayList<T>) filein2.readObject();
        return testArray2;

    }

     public void readDataForUsers() throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        try {
            String currentLine;
            while ((currentLine = fr.readLine()) != null) {
                String[] tokens = currentLine.split("/");
                people.add(new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally
        {
            fr.close();
        }
    }

     public void saveRegisteredUsers(List<Person> newerCredentials) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
        try
        {
            for (Person person : newerCredentials)
            {
                writer.write(person.ID+"/"+ person.name + "/" + person.Email + "/" + person.getPassword() + person.role + "\n");
            }

        }catch (IOException e)
        {
            System.out.println(e.getMessage());;
        }
        finally {
            writer.close();
        }
    }
}
