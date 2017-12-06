import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class IntGeneratorTest {
    public static void processData(ArrayList<Integer> data) {
        if (data != null) {
            double sum = 0;
            int[] freq = new int[10];
            for (Integer item : data) {
                freq[item / 10]++;
                sum += item;
            }

            int i = 0;
            for (int item : freq) {
                System.out.println("Freq (" + i + "-" + (i + 9) + "):\t" + item);
                i += 10;
            }
            System.out.println("\nNumber of data: " + data.size());
            if (data.size() > 0) 
                System.out.println("Average " + sum / data.size());
             else
                System.out.println("Average 0.0");
        }
    }

    public static void main(String[] args) {
        String filename = JOptionPane.showInputDialog("Enter filename");
        if (filename == null)
            System.exit(-1);
        File file = new File(filename);
        IntGenerator genfile = new IntGenerator();
        genfile.setFile(file);
        boolean toAppend = false;
        if (file.exists()) {
            int option = JOptionPane.showConfirmDialog(null, 
                            "Replace existing data? Click 'Yes' to replace and 'No' to append.",
                            "Confirm to replace contents",
                            JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION)
                toAppend = true;
        }

//        genfile.generateData(10000, toAppend);
        ArrayList<Integer> data = genfile.readData();
        processData(data);

        int start = (int)file.length()/4 - 10;
        ArrayList<Integer> subdata = genfile.readData(start, 10);
        if (subdata != null) {
            for (int i = 0; i < subdata.size(); i++) {
                System.out.println(subdata.get(i) + " " + data.get(start + i));
            }
            System.out.println();
        }
    }

}
