import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle file by store and read data
 */

public class FileHandling <T> {
    File file ;
    static List<Person> people = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    private final String fileName;
    public FileHandling(String fileName){
        this.file = new File(fileName);
        this.fileName = fileName;
    }


    /**
     * Store an arrayList of objects
     *
     * @param objects An object to store
     * @throws IOException
     */
    public void writeObjectList(ArrayList<T> objects) throws IOException {
      
            try {
                FileOutputStream fileout1 = new FileOutputStream(file);   // to append add true
                ObjectOutputStream fileout2 = new ObjectOutputStream(fileout1);

                fileout2.writeObject(objects);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * Fun
     *
     * @return ArrayList of objects that stored in the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  ArrayList<T> readObjectList() throws IOException, ClassNotFoundException {
        ArrayList<T> objects = new ArrayList<>();
        FileInputStream filein1 = null;

        if (!file.exists()||file.length() == 0) {

            System.out.println("No results available.");
            return objects;
        }

        try {
            filein1 = new FileInputStream(file);
            ObjectInputStream filein2 = new ObjectInputStream(filein1);

            objects = (ArrayList<T>) filein2.readObject();



        } catch (EOFException e) {
            e.getMessage();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if(file.exists() && file.isFile()){
                filein1.close();
            }
        }
        return objects;

    }

    /**
     * Store an object to the file
     * @param object An object to store
     * @throws IOException
     */
    public void writeObject(T object) throws IOException {

        try
        {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            objectOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read an object from the file
     *
     * @return The object read from the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public T readObject() throws IOException, ClassNotFoundException {

        if (!file.exists() || file.length() == 0) {
            //System.out.println("No results available.");
            return null;
        }

        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            return (T) objectIn.readObject();
        } catch (EOFException e) {
            e.getMessage(); // Handle the end of file exception if needed
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public void readDataForUsers() throws IOException {

        BufferedReader fr = new BufferedReader(new FileReader(this.fileName));
        try {
            String currentLine;
            while ((currentLine = fr.readLine()) != null) {
                String[] tokens = currentLine.split("/");
                people.add(new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4]));
            }

            for(Person person : people){
                if(person.role.equals("student"))
                {
                    students.add(new Student(person.ID, person.name, person.Email, person.getPassword(), person.role));
                }
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
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName,true));
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
