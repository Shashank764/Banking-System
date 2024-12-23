import java.io.*;
import java.io.IOException;
import java.util.*;

public class Bank {
    public static void main(String[] ags) {
        Scanner sc = new Scanner(System.in);
        System.out.println("                                  Welcome to Bank...");
        System.out.println("--------------------------------------------------------------------------------------------");
//            CREATING OBJECT FOR EXIT GREETING MESSAGE.
        ExitGreeting eg=new ExitGreeting();
        while (true) {
//            MAIN MENU.
            menu1 m1=new menu1();
            m1.MainMenu();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Please enter your username:- ");
                    String name= sc.next();
                    String paths = "C:\\Users\\shash\\OneDrive\\Desktop\\intellij files\\BankUsers\\" + name + ".txt";
                    File f2=new File(paths);
                    if(f2.exists()) {
                        System.out.print("Please enter your Password:- ");
                        String pwd= sc.next();
                        int ln;
                        String text=" ";
                        try {
                            FileReader f = new FileReader(paths);
                            BufferedReader b = new BufferedReader(f);
                            for (ln = 1; ln < 10; ln++) {
                                if (ln == 4) {
                                    text = b.readLine();
                                } else {
                                    b.readLine();
                                }
                            }
                            String str=text.substring(19);
                            if(str.equals(pwd)){
                                System.out.println("login Successfully...");
                                while (true) {
//                                      MENU FOR EXISTING USERS.
                                    menu1 m2=new menu1();
                                    m2.ExistingUserMenu();
                                    int option2 = sc.nextInt();
                                    System.out.println("========================");
                                    switch (option2) {
                                        case 1:
                                            Existing e= new Existing();
                                            System.out.println( e.BalanceCheck(paths));
                                            eg.exit();
                                            return;
                                        case 2:
                                            Existing e3= new Existing();
                                            e3.Deposit(paths);
                                            return;
                                        case 3:
                                            Existing e4= new Existing();
                                            e4.Withdraw(paths);
                                            return;
                                        case 4:
                                            Existing e1= new Existing();
                                            e1.AccStatement(paths);
                                            return;
                                        case 5:
                                            eg.exit();
                                            return;
                                        default:
                                            System.out.println("Invalid option chosen...!  Please Try Again!");
                                            System.out.println("********************************************");
                                            break;
                                    }
                                }
                            }
                            else{
                                System.out.println("WRONG PASSWORD...!");
                                System.out.println("========================");
                                eg.exit();
                                return;
                            }
                        }
                        catch (IOException e){
                            System.out.println("ERROR...............");
                            eg.exit();
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("User Dosen't Exists...!");
                        eg.exit();
                        return;
                    }
                    return;
                case 2:
//                      CREATE FILE FOR NEW USER
                    System.out.print("Enter UserName:- ");
                    String user = sc.next();
                    String path = "C:\\Users\\shash\\OneDrive\\Desktop\\intellij files\\BankUsers\\" + user + ".txt";
                    NewUser nu=new NewUser();
                    nu.Nuser(path,user);
                    return;
                case 3:
                    eg.exit();
                    return;
                default:
                    System.out.println("Invalid option chosen...!  Please Try Again!");
                    System.out.println("********************************************");
                    break;
            }
        }
    }
}
