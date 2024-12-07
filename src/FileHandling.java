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
     * @param objects An object to store
     * @throws IOException
     */
    public void writeObjectList(ArrayList<T> objects) throws IOException {
        if(objects.isEmpty())
        {
            boolean append = file.exists() && file.length() > 0;
            try {
                FileOutputStream fileout1 = new FileOutputStream(file);   // to append add true
                ObjectOutputStream fileout2 = append?
                new AppendableWrittenObject(fileout1)
                :new ObjectOutputStream(fileout1);

                fileout2.writeObject(objects);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Fun
     * @return ArrayList of objects that stored in the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  ArrayList<T> readObjectList() throws IOException, ClassNotFoundException {
        ArrayList<T> allObjects = new ArrayList<>();
        FileInputStream filein1 = null;

        if (!file.exists()||file.length() == 0) {

            System.out.println("No results available.");
            return allObjects;
        }

        try {
            filein1 = new FileInputStream(file);
            ObjectInputStream filein2 = new ObjectInputStream(filein1);

            ArrayList<T> objects = (ArrayList<T>) filein2.readObject();
            allObjects.addAll(objects);

        } catch (EOFException e) {
           e.getMessage();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if(file.exists() && file.isFile()){
                filein1.close();
            }
        }
        return allObjects;

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
