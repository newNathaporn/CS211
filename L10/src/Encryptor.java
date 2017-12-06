import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Encryptor {
    private int key;

    public Encryptor(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public byte encrypt(byte b, int key) {
        return (byte) (b + key);
    }

    public void encryptStream(File inFile, File outFile) throws IOException {
        try (FileInputStream in = new FileInputStream(inFile);
                FileOutputStream out = new FileOutputStream(outFile)) {
            while (true) {
                int nread = in.read();
                if (nread != -1) {
                    byte raw = (byte) nread;
                    byte enc = encrypt(raw, key);
                    out.write(enc);
                } else break;
            }
        }
    }

    private byte[] readBytesFromFile(File file) throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] byteMsg = new byte[(int) (file.length())];
            in.read(byteMsg);
            return byteMsg;
        }
    }

    public String readRawFile(File file) throws IOException {
        byte[] byteMsg = readBytesFromFile(file);
        return new String(byteMsg);
    }
    
    private byte[] encryptMsg(byte[] oriByteArray, int keyCode) {
        byte[] byteArray = new byte[oriByteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = encrypt(oriByteArray[i], keyCode);
        }
        return byteArray;
    }

    public void writeEncryptMessage(File inFile, File outFile)
            throws IOException {
        try (FileOutputStream out = new FileOutputStream(outFile)) {
            byte[] data = readBytesFromFile(inFile);
            out.write(encryptMsg(data, key));
        }
    }

    public String readDecryptMessage(File file) throws IOException {
        byte[] byteMsg = readBytesFromFile(file);
        return new String(encryptMsg(byteMsg, -key));
    }

    public String replaceMessage(File file, int start, String replaceStr)
            throws FileNotFoundException {
        try (RandomAccessFile inOut = new RandomAccessFile(file, "rw")) {
            int fileLength = (int) inOut.length();
            if (start <= fileLength) {
                byte[] byteMsg = null;
                if (fileLength - start < replaceStr.length()) {
                    byteMsg = new byte[(int) (fileLength - start)];
                } else
                    byteMsg = new byte[(int) (replaceStr.length())];
                inOut.seek(start);
                inOut.read(byteMsg);
                
                inOut.seek(start);
                inOut.write(encryptMsg(replaceStr.getBytes(), key));
                return new String(encryptMsg(byteMsg, -key));
            } else
                throw new IllegalArgumentException(
                        "Can't replace msg out of range");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 26; i++) {
            str += (char) ('A' + i);
        }
        for (int i = 0; i < 26; i++) {
            str += (char) ('a' + i);
        }
        for (int i = 0; i < 46; i++) {
            str += (char) ('¡' + i);
        }

        File oriFile = new File("sampleMsg.txt");
        File encFile = new File("encrypt.dat");

        try (FileOutputStream out = new FileOutputStream(oriFile)) {
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Encryptor data = new Encryptor(20);
        System.out.println("Encrypt data");
        try {
            // data.writeEncryptMessage(oriFile, encFile);
            data.encryptStream(oriFile, encFile);

            String oriMsg = data.readRawFile(oriFile);
            String msg = data.readRawFile(encFile);
            String decryptMsg = data.readDecryptMessage(encFile);
            System.out.println("Original File " + oriMsg);
            System.out.println("File Encrypt " + msg);
            System.out.println("File Decrypt " + decryptMsg);

            String msg2 = data.replaceMessage(encFile, (int)encFile.length()+1, "xxxxxx");
            data.setKey(-20);
            data.encryptStream(encFile, new File("temp.txt"));
            System.out.println("replace content " + msg2);
            System.out.println("decrypt " + data.readRawFile(new File("temp.txt")));
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
