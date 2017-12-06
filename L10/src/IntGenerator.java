import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class IntGenerator {
    private File file;

    public void generateData(int length, boolean toAppend) {
        if (file == null)
            throw new RuntimeException("No file to generate data to.");

        Random rand = new Random();
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(
                file, toAppend))) {
            for (int i = 0; i < length; i++) {
                out.writeInt(rand.nextInt(100));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("gen " + e.getMessage());
        }
    }

    public ArrayList<Integer> readData() {
        if (file != null && file.exists()) {
            ArrayList<Integer> list = new ArrayList<>();
            try (DataInputStream in = new DataInputStream(new FileInputStream(
                    file))) {
                while (true) {
                    try {
                        list.add(in.readInt());
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            return list;
        }
        return null;
    }

    public ArrayList<Integer> readData(int start, int amount) {
        if (file != null && file.exists() && start >= 0 && amount > 0) {
            try (RandomAccessFile raFile = new RandomAccessFile(file, "r")) {
                long length = raFile.length();
                int intSize = Integer.SIZE/Byte.SIZE;
                int startByte = start * intSize;
                int endByte = (start+amount) * intSize; ;
                
                if (endByte <= length) {
                    ArrayList<Integer> list = new ArrayList<>();
                    raFile.seek(startByte);
                    while (raFile.getFilePointer() < endByte) {
                        list.add(raFile.readInt());
                    }
                    return list;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public ArrayList<Integer> replaceData(int[] data, int start) {
        if (file != null && file.exists() && start >= 0) {
            try (RandomAccessFile raFile = new RandomAccessFile(file, "rw")) {
                long length = raFile.length();
                int intSize = Integer.SIZE/Byte.SIZE;
                int startByte = start * intSize;
                int endByte = (start+data.length) * intSize; ;
                
                if (endByte <= length) {
                    ArrayList<Integer> list = new ArrayList<>();
                    raFile.seek(startByte);
                    int i = 0;
                    while (raFile.getFilePointer() < endByte) {
                        list.add(raFile.readInt());
                        raFile.seek(raFile.getFilePointer()-intSize);
                        raFile.writeInt(data[i]);
                        i++;
                    }
                    for (; i<data.length; i++) {
                        raFile.writeInt(data[i]);
                    }
                    return list;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
