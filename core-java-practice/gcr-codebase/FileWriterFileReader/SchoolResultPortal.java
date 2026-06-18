
import java.io.*;
import java.util.Scanner;

public class SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "report.txt";

        try {
            File input = new File(inputFile);
            Scanner sc = new Scanner(input);

            FileWriter fw = new FileWriter(outputFile, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("===== Student Report Card =====\n");

            while (sc.hasNext()) {
                String name = sc.next();

                double m1 = sc.nextDouble();
                double m2 = sc.nextDouble();
                double m3 = sc.nextDouble();

                double average = (m1 + m2 + m3) / 3;

                bw.write("Name    : " + name + "\n");
                bw.write("Marks   : " + m1 + ", " + m2 + ", " + m3 + "\n");
                bw.write(String.format("Average : %.2f\n", average));
                bw.write("-------\n");
            }

            bw.close();
            sc.close();

            System.out.println("Report generated successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error writing to the report file.");
        }
    }
}
