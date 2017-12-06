import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RABinaryFile {
    private File file;
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void writeMessage(String msg) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(msg.getBytes());
        }
    }
    
    private byte[] readBytesFromFile(File tFile) throws IOException {
        try (FileInputStream in = new FileInputStream(tFile)) {
            byte[] byteMsg = new byte[(int) (tFile.length())];
            in.read(byteMsg);
            return byteMsg;
        }
    }

    public String readRawFile() throws IOException {
        byte[] byteMsg = readBytesFromFile(file);
        return new String(byteMsg);
    }
    
    public String insertMessage(int start, File insertFile)
            throws FileNotFoundException {
        try (RandomAccessFile inOut = new RandomAccessFile(file, "rw")) {
            int fileLength = (int) inOut.length();
            if (start <= fileLength) {
                byte[] byteMsg = new byte[(int) (fileLength - start)];
                inOut.seek(start);
                inOut.read(byteMsg);
                
                inOut.seek(start);
                inOut.write(readBytesFromFile(insertFile));
                inOut.write(byteMsg);
                
                inOut.seek(0);
                byteMsg = new byte[(int) inOut.length()];
                inOut.read(byteMsg);
                return new String(byteMsg); 
            } else
                throw new IllegalArgumentException(
                        "Can't insert msg out of range");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
