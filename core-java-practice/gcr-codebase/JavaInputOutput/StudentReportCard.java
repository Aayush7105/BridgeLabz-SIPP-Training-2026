
import java.io.*;
import java.util.*;

public class StudentReportCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            BufferedReader br = new BufferedReader(new FileReader("marks.txt"));

            String line;
            FileWriter fw = new FileWriter("reportcard.txt", true); // append mode

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");

                String name = data[0];
                int m1 = Integer.parseInt(data[1]);
                int m2 = Integer.parseInt(data[2]);
                int m3 = Integer.parseInt(data[3]);

                double avg = (m1 + m2 + m3) / 3.0;

                fw.write("Name: " + name + "\n");
                fw.write("Average: " + avg + "\n");
                fw.write("---------------------\n");
            }

            br.close();
            fw.close();

            System.out.println("Report Card Generated Successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("marks.txt file not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
