import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class BankApp {
    //Creating HashMap for Accounts having account id and balance
    static HashMap<String, Integer> account;
    //Creating hashMap for customer having customer account id and their Name
    static HashMap<String, String> customer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Initializing account and customer hashMap
        account = new HashMap<>();
        customer = new HashMap<>();

            while (true) {
                //Taking Input
                String req = sc.nextLine();
                //If Stop command is given, The application will be stopped
                if(req.toLowerCase(Locale.ROOT).equals("stop")) break;
                //Splitting the command to get account id from string
                String[] command = req.split("\\s+");

               // calling functions according to input received
                if(command[0].toLowerCase(Locale.ROOT).equals("create")){
                    createAccount(command);
                }else if(command[0].toLowerCase(Locale.ROOT).equals("deposit")){
                    depositMoney(command);
                }else if(command[0].toLowerCase(Locale.ROOT).equals("withdraw")){
                    withdrawMoney(command);
                }else if(command[0].toLowerCase(Locale.ROOT).equals("balance")){
                    getBalance(command);
                }else{
                    //If No Related functions are found
                    System.out.println("Command Not found!!! Please Use CREATE, DEPOSIT, WITHDRAW, BALANCE");

                }

            }


    }

    //To create new account with account id and customer name
    public static void createAccount(String[] cmd) {
        //If account already exists
        if (account.containsKey(cmd[1])) {
            System.out.println("Account Already exists");
        } else {
            //Creating new account with balance 0
            account.put(cmd[1], 0);
            // Creating Acoount id with Customer name
            customer.put(cmd[1], cmd[2]);
        }
    }

    //To Deposit money in account
    public static void depositMoney(String[] cmd) {
        //If account does not exists
        if (!account.containsKey(cmd[1])) {
            System.out.println("Account does not exist");
        }

        //Updating the account balance by adding it to the existing balance
        account.put(cmd[1], account.get(cmd[1]) + Integer.parseInt(cmd[2]));
    }

    //To withdraw money from account
    public static void withdrawMoney(String[] cmd){
        //If account does not exists
        if (!account.containsKey(cmd[1])) {
            System.out.println("Account does not exist");
        }
        //To get the existing balance of the account
        int balance = account.get(cmd[1]);
        //If withdrawing amount is greater than existing balance
        if(balance < Integer.parseInt(cmd[2])){
            System.out.println("Not Sufficient Balance");
            return;
        }
        account.put(cmd[1], balance - Integer.parseInt(cmd[2]));
    }

    //To get the account balance
    public static void getBalance(String[] cmd){
        //If account does not exists
        if (!account.containsKey(cmd[1])) {
            System.out.println("Account does not exist");
        }

        System.out.println();
        System.out.println(customer.get(cmd[1]) +" " + account.get(cmd[1]));
    }


}


