import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.*;

/**
 * Handle file by store and read data
 */
public class FileHandling <T> {
    File file ;

    public FileHandling(String fileName){

        this.file = new File(fileName);
    }

//last
    /**
     * Store an arrayList of objects
     * @param objects An object to store
     * @throws IOException
     */
    public  void writeObject(ArrayList<T> objects) throws IOException {

        try {
            FileOutputStream fileout1 = new FileOutputStream(file);   // to append add true
            ObjectOutputStream fileout2 = new ObjectOutputStream(fileout1);
            fileout2.writeObject(objects);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("step done");
        }
    }

/*    public  void writeObjectQuestions (ArrayList<AdminMakeQuestions> objects) throws IOException {

        FileOutputStream fileout1 = new FileOutputStream(file);   // to append add true
        ObjectOutputStream fileout2 = new ObjectOutputStream(fileout1);
        fileout2.writeObject(objects);
    }
    */

    /**
     * Fun
     * @return ArrayList of objects that stored in the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  ArrayList<T> readObject() throws IOException, ClassNotFoundException {

        FileInputStream filein1 = null;

        try {
            filein1 = new FileInputStream(file);
            ObjectInputStream filein2 = new ObjectInputStream(filein1);
            ArrayList<T> testArray2 = (ArrayList<T>) filein2.readObject();
            return testArray2;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if(file.exists() && file.isFile()){}
            filein1.close();
        }

    }

}
