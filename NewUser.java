import java.io.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class NewUser {
    public void Nuser(String path,String user){
        Scanner sc=new Scanner(System.in);
        ExitGreeting eg=new ExitGreeting();
        try {
            File f = new File(path);
            if (f.createNewFile()) {
                System.out.print("Create Password:- ");
                String password = sc.next();
                System.out.print("Enter initial Balance:- ");
                int bal = sc.nextInt();
                String balance = String.valueOf(bal);
                System.out.println();
                System.out.println("Account Created Successfully...");
                System.out.println("Please login again...!");
                FileWriter info = new FileWriter(path);
                LocalDateTime tym = LocalDateTime.now();
                DateTimeFormatter mytym = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String Nformat = tym.format(mytym);
                info.write("Account Created on: " + Nformat + "\n\n");
                info.write("Account name:- " + user + "\n");
                info.write("Account Password:- " + password + "\n");
                info.write("Account Balance:- ₹" + balance + "\n");
                info.write("Account Statement............\n");
                info.write("TRANSACTIONS...\n");
                info.write("Credited: ₹" + balance + "  [" + Nformat + "]\n");
                info.close();
                eg.exit();
            } else {
                System.out.println("Credential Already exists...");
                eg.exit();
            }
        } catch (IOException e) {
            System.out.println("Error while opening new Account...");
            System.out.println("********************************************");
            eg.exit();
            e.printStackTrace();
        }
    }
}
