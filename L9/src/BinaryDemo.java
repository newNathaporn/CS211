
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryDemo {
    public static void main(String[] args) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream ("output.dat"));
            os.writeInt(120);
            os.writeUTF("John Snow");
            os.writeLong(30);
            os.writeInt(130);
            os.writeUTF("Marry Kain");
            os.writeLong(20);
            os.close();
            
            ObjectInputStream is = new ObjectInputStream (new FileInputStream ("output.dat"));
            try{
                while (true){
                    System.out.print(is.readInt() + " ");
                    System.out.print(is.readUTF() + " ");
                    System.out.print(is.readLong() + " \n");
                }
            }catch (EOFException eof){
                System.out.println ("Finish Reading");
            }
            
        } catch (IOException e) {
            System.out.println ("Error Writing/Reading file:" + e.getMessage());
        }
    }
}
