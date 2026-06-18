
import java.io.*;

public class EmailDomainCounter {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("emails.txt"));

        String line;

        int gmail = 0;
        int yahoo = 0;
        int outlook = 0;

        while ((line = br.readLine()) != null) {

            String domain = line.substring(line.indexOf("@") + 1);

            if (domain.equalsIgnoreCase("gmail.com")) {
                gmail++; 
            }else if (domain.equalsIgnoreCase("yahoo.com")) {
                yahoo++; 
            }else if (domain.equalsIgnoreCase("outlook.com")) {
                outlook++;
            }
        }

        br.close();

        System.out.println("Gmail Users = " + gmail);
        System.out.println("Yahoo Users = " + yahoo);
        System.out.println("Outlook Users = " + outlook);
    }
}
