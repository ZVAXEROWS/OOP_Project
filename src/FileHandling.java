import java.io.*;
import java.util.ArrayList;

/**
 * Handle file by store and read data
 */
public class FileHandling {
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
    public  void writeObject(ArrayList<Result> objects) throws IOException {

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
    public  ArrayList<Result> readObject() throws IOException, ClassNotFoundException {

        FileInputStream filein1 = new FileInputStream(file);
        ObjectInputStream filein2 = new ObjectInputStream(filein1);
        ArrayList<Result> testArray2 = (ArrayList<Result>) filein2.readObject();
        return testArray2;

    }

}
