import java.io.*;
import java.util.ArrayList;

/**
 * Handle file by store and read data
 */
public class FileHandling<T> {
    File file;

    public FileHandling(String fileName) {

        this.file = new File(fileName);
    }


    /**
     * Store an arrayList of objects
     *
     * @param objects An object to store
     * @throws IOException
     */
    public void writeObjectList(ArrayList<T> objects) throws IOException {

        FileOutputStream fileout1 = new FileOutputStream(file);   // to append add true
        ObjectOutputStream fileout2 = new ObjectOutputStream(fileout1);
        fileout2.writeObject(objects);
    }

    /**
     * Fun
     *
     * @return ArrayList of objects that stored in the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<T> readObjectList() throws IOException, ClassNotFoundException {
        if (!file.exists()||file.length() == 0) {

                System.out.println("No results available.");
                return new ArrayList<>();
        }
        FileInputStream filein1 = new FileInputStream(file);
        ObjectInputStream filein2 = new ObjectInputStream(filein1);
        ArrayList<T> testArray2 = (ArrayList<T>) filein2.readObject();
        return testArray2;


    }

}
