import javax.swing.JOptionPane;
import java.util.ArrayList;

class accounts
{
    String accNum;
    String accName;
    double balance;
    String pin;
    String status;

    accounts(String accNum, String accName, double balance, String pin, String status)
    {
        this.accNum = accNum;
        this.accName = accName;
        this.balance = balance;
        this.pin = pin;
        this.status = status;
    }

    public String getAccNum()
    {
        return accNum;
    }

    public String getAccName()
    {
        return accName;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getPin()
    {
        return pin;
    }

    public String getStatus()
    {
        return status;
    }
}

public class bank {
    static accounts findAcc(ArrayList<accounts> accountlist, String accNum) {
        for(accounts acc : accountlist)
        {
            if (acc.getAccNum().equals(accNum))
            {
                if(acc.getStatus().equals("Active") || acc.getStatus().equals("Admin"))
                {
                    return acc;
                }
            }
        }
        return null;
    }

    static accounts findAccAdmin(ArrayList<accounts> accountlist, String input) {
        for(accounts acc : accountlist)
        {
            if (acc.getAccNum().equals(input) || acc.getAccName().equals(input))
            {
                    return acc;
            }
        }
        return null;
    }


    static boolean findPin(accounts account, String pin) {
        if(account != null && account.getPin().equals(pin))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        JOptionPane jop = new JOptionPane();
        int f = 1;

        ArrayList<accounts> account = new ArrayList<accounts>();

        //accNum, accName, balance, pin, status
        accounts acc1 = new accounts("0123-4567-8901", "Rhianne Nacino", 5000, "1111", "Active");
        accounts acc2 = new accounts("2345-6789-0123", "John Carl Rasonable", 0, "2222", "Blocked");
        accounts acc3 = new accounts("3456-7890-1234", "Gerald Reyes", 10000, "3333", "Active");
        accounts acc4 = new accounts("4567-8901-2345", "Shiaorene Lomyier Capuno", 2500, "4444", "Active");
        accounts acc5 = new accounts("5678-9012-3456", "Angelica Estores", 10000, "5555", "Active");
        accounts acc6 = new accounts("0000-0000-0000", "Zen Admin", 10000, "0000", "Admin");

        account.add(acc1);
        account.add(acc2);
        account.add(acc3);
        account.add(acc4);
        account.add(acc5);
        account.add(acc6);


        while(f > 0) {

            //OUTPUT #1

            String firmenu = jop.showInputDialog(null,
                    "==========================================\n" +
                            "                             [S] -> Start\n                             [Q] -> Quit\n" +
                            "==========================================",
                    "Group 4 Banking Corporation" , jop.PLAIN_MESSAGE);

            char conv = firmenu.charAt(0);

            if (conv == 'Q' || conv == 'q') {
                jop.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            } else if (conv == 'S' || conv == 's') {

                // OUTPUT #2
                String secmenu = jop.showInputDialog(null, "                 Input Account Number\n" +
                                "           FORMAT -> xxxx-xxxx-xxxx"
                        , "Group 4 Banking Corporation", jop.PLAIN_MESSAGE);

                accounts foundacc = findAcc(account, secmenu);

                if(foundacc != null)
                {
                    jop.showMessageDialog(null, "          Account Found!", "Group 4 Banking Corporation", jop.INFORMATION_MESSAGE);

                    //PINNNNNN LOOOOOP
                    int p = 3;
                    boolean verified = false;

                    while(p > 0) {
                        String pinput = jop.showInputDialog(null, "               Input Pin Number\n               " +
                                " Format -> XXXX", "Group 4 Banking Corporation", jop.QUESTION_MESSAGE);


                        if(findPin(foundacc, pinput))
                        {
                            jop.showMessageDialog(null, "PIN VERIFIED! \nWelcome, " + foundacc.getAccName(), "Group 4 Banking Corporation", jop.INFORMATION_MESSAGE);
                            break;
                        }
                        else
                        {
                            p--;
                            jop.showMessageDialog(null, "INCORRECT PIN. \n" + p + " TRIES REMAINING.", "Group 4 Banking Corporation", jop.WARNING_MESSAGE);
                            if (p == 0)
                            {
                                jop.showMessageDialog(null, "CAPTURED CARD.... PLEASE CALL ME <3 \nTOO MANY FAILED ATTEMPTS, YOUR ACCOUNT IS NOW BLOCKED.", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                                foundacc.status = "Blocked";
                            }
                        }
                    }

                    // OUTPUT #5 ADMIN CONTROLS
                    if(foundacc.status == "Admin") {
                        // WALA PANG FUNCTION OR ANY KIND OF THING ONLY SHELL
                        boolean adminlop = true;
                        while (adminlop){
                            String adput = jop.showInputDialog(null, "What would you like to do?\n" +
                                    "( 1 ) - View Customer Information\n( 2 ) - Search Customer\n( 3 ) - Add New Customer\n" +
                                    "( 4 ) - Edit Customer Information\n( 5 ) - Change Customer Pin Number\n( 6 ) - Transfer Fund\n( 7 ) - Activate/Block Account\n" +
                                    "( X ) - Exit", "Group 4 Admin", jop.QUESTION_MESSAGE);

                        char convadput = adput.charAt(0);

                        if (convadput == '1') {

                            // SHIAO OR RASONABLE





                        } else if (convadput == '2') {
                            String search = jop.showInputDialog(null, "Enter the Customer's Name or Account Number:", "Group 4 Admin", jop.QUESTION_MESSAGE);

                            accounts searchedAcc= findAccAdmin(account, search);

                            if (searchedAcc != null) {
                                String accountInfo = "Account Number: " + searchedAcc.getAccNum() + "\n" +
                                        "Account Name: " + searchedAcc.getAccName() + "\n" +
                                        "Balance: " + searchedAcc.getBalance() + "\n" +
                                        "Status: " + searchedAcc.getStatus() +
                                        "\nPIN: " + searchedAcc.getPin();

                                jop.showMessageDialog(null, accountInfo, "Customer Information", jop.INFORMATION_MESSAGE);
                            } else {
                                jop.showMessageDialog(null, "Account not found! Please check the name and account number.", "Group 4 Admin", jop.ERROR_MESSAGE);
                            }
                        } else if (convadput == '3') {

                            // SHIAO OR RASONABLE



                        }  else if (convadput == '4') {
                            String infoChange = jop.showInputDialog(null, "CHANGE INFORMATION\nInput Name or Account number: ", "Group 4 Admin", jop.QUESTION_MESSAGE);

                            accounts foundinfoAcc = findAccAdmin(account, infoChange);
                            if (foundinfoAcc != null) {
                                jop.showMessageDialog(null, "Found Account!", "Group 4 Admin", jop.INFORMATION_MESSAGE);

                                String infochoice = jop.showInputDialog(null, "[1] -> Change name\n[2] -> Change Account number", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                char convinfo = infochoice.charAt(0);

                                if(convinfo == '1') {
                                    String NCchoice = jop.showInputDialog(null, "Change name to:", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                    foundinfoAcc.accName = NCchoice;
                                }
                                else if(convinfo == '2')
                                {
                                    String ANchoice = jop.showInputDialog(null, "Change Account Number to:", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                    foundinfoAcc.accNum = ANchoice;
                                }

                            } else {
                                jop.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", jop.ERROR_MESSAGE);
                            }
                        } else if (convadput == '5') {

                            String pinchange = jop.showInputDialog(null, "CHANGE PIN\nInput Name or Account number: ", "Group 4 Admin", jop.QUESTION_MESSAGE);

                            accounts changepinAcc = findAccAdmin(account, pinchange);

                            if(changepinAcc != null) {

                                String newpin = jop.showInputDialog(null, "Current pin: " + changepinAcc.getPin() + "\nInput New Pin for " + changepinAcc.getAccName() + " : ", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                changepinAcc.pin = newpin;
                            }
                            else{
                                jop.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", jop.ERROR_MESSAGE);
                            }


                        } else if (convadput == '6') {

                            String admintransfer = jop.showInputDialog(null, "TRANSFER FUNDS:\nInput Account number or Name: ", "Group 4 Admin Banking Corporation", jop.QUESTION_MESSAGE);
                            accounts foundTransferAcc = findAccAdmin(account, admintransfer);

                            if (foundTransferAcc != null) {
                                jop.showMessageDialog(null, "Found Account!", "Group 4 Admin", jop.INFORMATION_MESSAGE);
                                String admintransferfund = jop.showInputDialog(null, "Enter amount to transfer:", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                int adminparsedtransfer = Integer.parseInt(admintransferfund);

                                foundTransferAcc.balance += adminparsedtransfer;

                                jop.showMessageDialog(null, "Transferred " + adminparsedtransfer + " to " + foundTransferAcc.getAccName() +
                                        "\nBalance is now " + foundTransferAcc.getBalance(), "Group 4 Admin Banking Corporation", jop.INFORMATION_MESSAGE);

                            } else {
                                jop.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", jop.ERROR_MESSAGE);
                            }

                        }else if (convadput == '7') {

                            String adminstatus = jop.showInputDialog(null,
                                    "ACTIVATE/BLOCK ACCOUNT\n\nEnter account number or Name:",
                                    "RGBC - Account Status", jop.PLAIN_MESSAGE);

                            if (adminstatus == null) return;

                            accounts statuschange = findAccAdmin(account , adminstatus);

                            if (statuschange == null) {
                                jop.showMessageDialog(null, "Account not found!", "Error",
                                        jop.ERROR_MESSAGE);
                            } else {
                                String[] options = {"Active", "Blocked"};
                                int choice = jop.showOptionDialog(null,
                                        "Account: " + statuschange.accName + "\nCurrent status: " + statuschange.status +
                                                "\n\nSelect new status:",
                                        "Group 4 Admin Banking Corporation",
                                        jop.DEFAULT_OPTION,
                                        jop.QUESTION_MESSAGE,
                                        null, options, options[0]);

                                if (choice >= 0) {
                                    statuschange.status = options[choice];
                                    jop.showMessageDialog(null, "Status updated successfully to: " + statuschange.status,
                                            "Group 4 Admin", jop.INFORMATION_MESSAGE);
                                }
                            }

                        } else if (convadput == 'x' || convadput == 'X') {
                            adminlop = false;
                            jop.showMessageDialog(null, "Goodbye " + foundacc.getAccName() + "!", "Group 4 Admin Banking Corporation", jop.PLAIN_MESSAGE);
                        }
                    }
                    }

                    // OUTPUT #3 MGA TRANSSACTION
                    if(foundacc.status == "Active") {
                        int trloop = 1;
                        while (trloop > 0) {
                            String transact = jop.showInputDialog(null, "Please select type of transaction: \n[B] -> Balance Inquiry \n[W] -> Withdrawal\n[D] -> Deposit \n[T] -> Transfer Fund \n[C] -> Cancel"
                                    , "Group 4 Banking Corporation", jop.QUESTION_MESSAGE);

                            char convtrs = transact.charAt(0);

                            // ALL THE OUTPUT #4 BANKING KENEME

                            if (convtrs == 'B') {
                        /* gamititin yung function na foundacc.[insert kung ano man yung hinahanap niyo na variable nandun naman na sa taas just read.]
                           for example foundacc.getName();  -> lalabas nito yung pangalan ng nakitang account from last time. naka set up na yung mga functions
                           just read and understand the whole thing thanks guys <3
                         */
                            } else if (convtrs == 'W' || convtrs == 'w') {
                                String with = jop.showInputDialog(null, "WITHDRAWAL\nEnter amount to be withdrawn", "Group 4 Banking Corporation", jop.QUESTION_MESSAGE);
                                if (with == null) continue;
                                try {
                                    double amt = Double.parseDouble(with);
                                    if (amt < 100 || amt % 100 != 0 || amt > foundacc.getBalance()) {
                                        jop.showMessageDialog(null, "Invalid amount or insufficient funds!", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                                    } else {
                                        foundacc.balance -= amt;
                                        jop.showMessageDialog(null, "Withdrawal successful!\nNew balance: " + foundacc.getBalance(), "Group 4 Banking Corporation", jop.INFORMATION_MESSAGE);
                                    }
                                } catch (Exception e) {
                                    jop.showMessageDialog(null, "Invalid input!", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                                }

                            } else if (convtrs == 'D' || convtrs == 'd') {

                            } else if (convtrs == 'T' || convtrs == 't') {

                            } else if (convtrs == 'C' || convtrs == 'c') {
                                break;
                            } else {
                                jop.showMessageDialog(null, "Invalid Input!" , "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                            }
                        }
                    }

                    // end of the whole main banking shi
                } else {
                    jop.showMessageDialog(null, "Account Not Found or Blocked!", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                }

            } else {
                jop.showMessageDialog(null, "\t\tInvalid Input", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
            }
        }
        // END of while loop ng output #1 nakakainis talaga kanina pato


    }
}