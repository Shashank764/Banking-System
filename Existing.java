import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.*;

public class Existing {
    public void Withdraw(String path){
        Scanner sc= new Scanner(System.in);
        ExitGreeting eg=new ExitGreeting();
        String txt=" ";
        int ln;
        try {
            FileReader r=new FileReader(path);
            BufferedReader br=new BufferedReader(r);
            for(ln=1; ln<20;ln++){
                if(ln==5){
                    txt=br.readLine();
                    break;
                }
                else{
                    br.readLine();
                }
            }
            String str= txt.substring(19);
            int amt = Integer.parseInt(str);
            System.out.print("Enter amount to withdrew:- ");
            int amt2= sc.nextInt();
            if(amt2<=amt) {
                int finalAmt = amt - amt2;
                List<String> lines = new ArrayList<>();
                // Step 1: Read the file
                try (BufferedReader brr = new BufferedReader(new FileReader(path))) {
                    String line;
                    while ((line = brr.readLine()) != null) {
                        lines.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Step 2: Modify the content
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).contains("Balance")) {
                        lines.set(i, lines.get(i).replace(lines.get(i), "Account Balance:- ₹"+finalAmt));
                        break;
                    }
                }
                // Step 3: Write back to the file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                    for (String line : lines) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LocalDateTime tym = LocalDateTime.now();
                DateTimeFormatter mytym = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String Nformat = tym.format(mytym);
                String statement = "Debited: ₹" + amt2 + "  ["+Nformat+"]";
                String filePath = path;
                // Lines to be added
                String[] linesToAdd = {
                        statement
                };
                // Step 1: Open the file in append mode
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                    // Step 2: Write the new lines
                    for (String line : linesToAdd) {
                        bw.write(line);
                        bw.newLine(); // Add a new line after each line
                    }
                    System.out.println("Lines added successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Remaining Account Balance :- ₹"+finalAmt);
                eg.exit();
            }
            else{
                System.out.println("INSUFFICIENT BALANCE... \n Account Balance:- ₹"+ amt);
                eg.exit();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void Deposit(String path) {
        Scanner sc = new Scanner(System.in);
        String txt = " ";
        int ln;
        int amt2 = 0;
        try {
            FileReader r = new FileReader(path);
            BufferedReader br = new BufferedReader(r);
            for (ln = 1; ln < 20; ln++) {
                if (ln == 5) {
                    txt = br.readLine();
                    break;
                } else {
                    br.readLine();
                }
            }
            String str = txt.substring(19);
            int amt = Integer.parseInt(str);
            System.out.print("Enter amount to deposit:- ₹");
            amt2 = sc.nextInt();
            int finalAmt = amt + amt2;
            List<String> lines = new ArrayList<>();
            // Step 1: Read the file
            try (BufferedReader brr = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = brr.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Step 2: Modify the content
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("Balance")) {
                    lines.set(i, lines.get(i).replace(lines.get(i), "Account Balance:- ₹" + finalAmt));
                    break;
                }
            }

            // Step 3: Write back to the file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Account Balance:- ₹" + finalAmt);
            System.out.println();
            System.out.println();
            System.out.println("Thank You For Using Our Services.........");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime tym = LocalDateTime.now();
        DateTimeFormatter mytym = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String Nformat = tym.format(mytym);
        String statement = "Credited: ₹" + amt2 + "  ["+Nformat+"]";
        String filePath = path;

        // Lines to be added
        String[] linesToAdd = {
            statement
        };

        // Step 1: Open the file in append mode
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            // Step 2: Write the new lines
            for (String line : linesToAdd) {
                bw.write(line);
                bw.newLine(); // Add a new line after each line
            }
            System.out.println("Lines added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String BalanceCheck(String path){
        String txt=" ";
        int ln;
        try {
            FileReader r=new FileReader(path);
            BufferedReader br=new BufferedReader(r);
            for(ln=1; ln<20;ln++){
                if(ln==5){
                    txt=br.readLine();
                    break;
                }
                else{
                    br.readLine();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return txt;

    }
    public void  AccStatement(String path){
        try {
            FileReader fr=new FileReader(path);
            Scanner s=new Scanner(fr);
            while (s.hasNextLine()){
                String data=s.nextLine();
                Pattern p=Pattern.compile("Statement",Pattern.CASE_INSENSITIVE);
                Matcher m=p.matcher(data);
                boolean match=m.find();
                if(match){
                    while (s.hasNextLine()){
                        String ss=s.nextLine();
                        System.out.println(ss);
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Thank You For Using Our Services.........");
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
