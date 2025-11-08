import javax.swing.JOptionPane;
import java.util.ArrayList;

public class bank
{
    // Customer data stored in ArrayLists
    static ArrayList<String> accNum = new ArrayList();
    static ArrayList<String> accName = new ArrayList();
    static ArrayList<Double> balance = new ArrayList();
    static ArrayList<String> pin = new ArrayList();
    static ArrayList<String> status = new ArrayList();

    static int findAcc(String accNumInput)
    {
        for(int ctr = 0; ctr < accNum.size(); ctr++)
        {
            if (accNum.get(ctr).equals(accNumInput))
            {
                if(status.get(ctr).equals("Active") || status.get(ctr).equals("Admin"))
                {
                    return ctr;
                }
            }

        }
        return -1;
    }

    static int findAccAdmin(String input)
    {
        for(int ctr = 0; ctr < accNum.size(); ctr++)
        {
            if (accNum.get(ctr).equals(input) || accName.get(ctr).equals(input))
            {
                return ctr;
            }
        }
        return -1;
    }

    static boolean findPin(int accountIndex, String pinInput)
    {
        if(pin.get(accountIndex).equals(pinInput))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        JOptionPane jop = new JOptionPane();

        accNum.add("0123-4567-8901");
        accNum.add("2345-6789-0123");
        accNum.add("3456-7890-1234");
        accNum.add("4567-8901-2345");
        accNum.add("5678-9012-3456");
        accNum.add("0000-0000-0000");

        accName.add("Rhianne Nacino");
        accName.add("John Carl Rasonable");
        accName.add("Gerald Reyes");
        accName.add("Shiaorene Lomyier Capuno");
        accName.add("Angelica Estores");
        accName.add("Zen Admin");

        balance.add(5000.0);
        balance.add(0.0);
        balance.add(10000.0);
        balance.add(2500.0);
        balance.add(10000.0);
        balance.add(10000.0);

        pin.add("1111");
        pin.add("2222");
        pin.add("3333");
        pin.add("4444");
        pin.add("5555");
        pin.add("0000");

        status.add("Active");
        status.add("Blocked");
        status.add("Active");
        status.add("Active");
        status.add("Active");
        status.add("Admin");

        int f = 1;
        while(f > 0)
        {
            //OUTPUT #1
            String firmenu = jop.showInputDialog(null,
                    "==========================================\n" +
                            "                             [S] -> Start\n                             [Q] -> Quit\n" +
                            "==========================================",
                    "Group 4 Banking Corporation" , jop.PLAIN_MESSAGE);

            char conv = firmenu.charAt(0);

            if (conv == 'Q' || conv == 'q')
            {
                jop.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }
            else if (conv == 'S' || conv == 's')
            {
                // OUTPUT #2
                String secmenu = jop.showInputDialog(null, "                 Input Account Number\n" +
                                "           FORMAT -> xxxx-xxxx-xxxx"
                        , "Group 4 Banking Corporation", jop.PLAIN_MESSAGE);

                int foundaccIndex = findAcc(secmenu);

                if(foundaccIndex != -1)
                {
                    jop.showMessageDialog(null, "          Account Found!", "Group 4 Banking Corporation", jop.INFORMATION_MESSAGE);

                    //PINNNNNN LOOOOOP
                    int p = 3;

                    while(p > 0)
                    {
                        String pinput = jop.showInputDialog(null, "               Input Pin Number\n               " +
                                " Format -> XXXX", "Group 4 Banking Corporation", jop.QUESTION_MESSAGE);

                        if(findPin(foundaccIndex, pinput))
                        {
                            jop.showMessageDialog(null, "PIN VERIFIED! \nWelcome, " + accName.get(foundaccIndex), "Group 4 Banking Corporation", jop.INFORMATION_MESSAGE);
                            break;
                        }
                        else
                        {
                            p--;
                            jop.showMessageDialog(null, "INCORRECT PIN. \n" + p + " TRIES REMAINING.", "Group 4 Banking Corporation", jop.WARNING_MESSAGE);
                            if (p == 0)
                            {
                                jop.showMessageDialog(null, "CAPTURED CARD.... PLEASE CALL ME <3 \nTOO MANY FAILED ATTEMPTS, YOUR ACCOUNT IS NOW BLOCKED.", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                                status.set(foundaccIndex, "Blocked");
                            }
                        }
                    }

                    // OUTPUT #5 ADMIN CONTROLS
                    if(status.get(foundaccIndex).equals("Admin"))
                    {
                        boolean adminlop = true;
                        while (adminlop)
                        {
                            String adput = jop.showInputDialog(null, "What would you like to do?\n" +
                                    "( 1 ) - View Customer Information\n( 2 ) - Search Customer\n( 3 ) - Add New Customer\n" +
                                    "( 4 ) - Edit Customer Information\n( 5 ) - Change Customer Pin Number\n( 6 ) - Transfer Fund\n( 7 ) - Activate/Block Account\n" +
                                    "( X ) - Exit", "Group 4 Admin", jop.QUESTION_MESSAGE);

                            char convadput = adput.charAt(0);

                            if (convadput == '1')
                            {
                                String allAcc = "";

                                for(int ctr = 0; ctr < accNum.size(); ctr++)
                                {
                                    allAcc += "Account " + ctr + " : " + "Account Number: " + accNum.get(ctr) + " ,  Name: " + accName.get(ctr) + " \nBalance: " + balance.get(ctr) + " ,  Pin: " + pin.get(ctr) + " ,  Status: " + status.get(ctr) + "\n\n";
                                }
                                jop.showMessageDialog(null, allAcc, "Group 4: Banking Corporation All Customers", jop.INFORMATION_MESSAGE);

                            } else if (convadput == '2') {
                                String search = jop.showInputDialog(null, "Enter the Customer's Name or Account Number:", "Group 4 Admin", jop.QUESTION_MESSAGE);

                                int searchedAccIndex = findAccAdmin(search);

                                if (searchedAccIndex != -1) {
                                    String accountInfo = "Account Number: " + accNum.get(searchedAccIndex) + "\n" +
                                            "Account Name: " + accName.get(searchedAccIndex) + "\n" +
                                            "Balance: " + balance.get(searchedAccIndex) + "\n" +
                                            "Status: " + status.get(searchedAccIndex) +
                                            "\nPIN: " + pin.get(searchedAccIndex);

                                    jop.showMessageDialog(null, accountInfo, "Customer Information", jop.INFORMATION_MESSAGE);
                                } else {
                                    jop.showMessageDialog(null, "Account not found! Please check the name and account number.", "Group 4 Admin", jop.ERROR_MESSAGE);
                                }
                            } else if (convadput == '3') {
                                String newAccNum = jop.showInputDialog(null, "Enter new account number (xxxx-xxxx-xxxx):", "Add New Customer", jop.QUESTION_MESSAGE);

                                boolean accNumExists = false;
                                for(int ctr = 0; ctr < accNum.size(); ctr++)
                                {
                                    if(accNum.get(ctr).equals(newAccNum))
                                    {
                                        accNumExists = true;
                                        break;
                                    }
                                }

                                if(accNumExists)
                                {
                                    jop.showMessageDialog(null, "Account number already exists!", "Error", jop.ERROR_MESSAGE);
                                }
                                else
                                {
                                    String newAccName = jop.showInputDialog(null, "Enter account holder name:", "Add New Customer", jop.QUESTION_MESSAGE);
                                    String newBalanceStr = jop.showInputDialog(null, "Enter initial balance:", "Add New Customer", jop.QUESTION_MESSAGE);
                                    String newPin = jop.showInputDialog(null, "Enter PIN (4 digits):", "Add New Customer", jop.QUESTION_MESSAGE);
                                    String newStatus = jop.showInputDialog(null, "Enter Status (Active, Blocked, Admin)", "Add New Customer", jop.QUESTION_MESSAGE);

                                    double newBalance = Double.parseDouble(newBalanceStr);

                                    // Add new customer to ArrayLists
                                    accNum.add(newAccNum);
                                    accName.add(newAccName);
                                    balance.add(newBalance);
                                    pin.add(newPin);
                                    status.add(newStatus);

                                    jop.showMessageDialog(null, "New customer added successfully!\n" +
                                            "Account Number: " + newAccNum + "\n" +
                                            "Account Name: " + newAccName + "\n" +
                                            "Initial Balance: " + newBalance + "\n" +
                                            "Status: " + newStatus, "Group 4 Admin Create Account Success", jop.INFORMATION_MESSAGE);
                                }

                            } else if (convadput == '4') {
                                String infoChange = jop.showInputDialog(null, "CHANGE INFORMATION\nInput Name or Account number: ", "Group 4 Admin", jop.QUESTION_MESSAGE);

                                int foundinfoAccIndex = findAccAdmin(infoChange);

                                if (foundinfoAccIndex != -1) {
                                    jop.showMessageDialog(null, "Found Account!", "Group 4 Admin", jop.INFORMATION_MESSAGE);

                                    String infochoice = jop.showInputDialog(null, "[1] -> Change name\n[2] -> Change Account number", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                    char convinfo = infochoice.charAt(0);

                                    if(convinfo == '1') {
                                        String NCchoice = jop.showInputDialog(null, "Change name to:", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                        accName.set(foundinfoAccIndex, NCchoice);
                                    } else if(convinfo == '2') {
                                        String ANchoice = jop.showInputDialog(null, "Change Account Number to:", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                        accNum.set(foundinfoAccIndex, ANchoice);
                                    }
                                } else {
                                    jop.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", jop.ERROR_MESSAGE);
                                }
                            }
                             else if (convadput == '5')
                             {
                                String pinchange = jop.showInputDialog(null, "CHANGE PIN\nInput Name or Account number: ", "Group 4 Admin", jop.QUESTION_MESSAGE);

                                int changepinAccIndex = findAccAdmin(pinchange);

                                if(changepinAccIndex != -1)
                                {
                                    String newpin = jop.showInputDialog(null, "Current pin: " + pin.get(changepinAccIndex) + "\nInput New Pin for " + accName.get(changepinAccIndex) + " : ", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                    pin.set(changepinAccIndex, newpin);
                                }
                                else
                                {
                                    jop.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", jop.ERROR_MESSAGE);
                                }

                            }
                             else if (convadput == '6')
                             {
                                String admintransfer = jop.showInputDialog(null, "TRANSFER FUNDS:\nInput Account number or Name: ", "Group 4 Admin Banking Corporation", jop.QUESTION_MESSAGE);
                                int foundTransferAccIndex = findAccAdmin(admintransfer);

                                if (foundTransferAccIndex != -1)
                                {
                                    jop.showMessageDialog(null, "Found Account!", "Group 4 Admin", jop.INFORMATION_MESSAGE);
                                    String admintransferfund = jop.showInputDialog(null, "Enter amount to transfer:", "Group 4 Admin", jop.QUESTION_MESSAGE);
                                    int adminparsedtransfer = Integer.parseInt(admintransferfund);

                                    balance.set(foundTransferAccIndex, balance.get(foundTransferAccIndex) + adminparsedtransfer);

                                    jop.showMessageDialog(null, "Transferred " + adminparsedtransfer + " to " + accName.get(foundTransferAccIndex) +
                                            "\nBalance is now " + balance.get(foundTransferAccIndex), "Group 4 Admin Banking Corporation", jop.INFORMATION_MESSAGE);

                                }
                                else
                                {
                                    jop.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", jop.ERROR_MESSAGE);
                                }

                            }
                             else if (convadput == '7')
                             {
                                String adminstatus = jop.showInputDialog(null, "ACTIVATE/BLOCK/ADMIN\n\nEnter account number or Name:",  "Group 4: Admin", jop.PLAIN_MESSAGE);

                                int statuschangeIndex = findAccAdmin(adminstatus);

                                  if (statuschangeIndex == -1) {
                                    jop.showMessageDialog(null, "Account not found!", "Error", jop.ERROR_MESSAGE);
                                   }
                                  else
                                   {
                                     String[] options = {"Active", "Blocked", "Admin"};
                                    int choice = jop.showOptionDialog(null,
                                            "Account: " + accName.get(statuschangeIndex) + "\nCurrent status: " + status.get(statuschangeIndex) +
                                                    "\n\nSelect new status:",
                                            "Group 4 Admin Banking Corporation",
                                            jop.DEFAULT_OPTION,
                                            jop.QUESTION_MESSAGE,
                                            null, options, options[0]);

                                      if (choice >= 0)
                                      {
                                        status.set(statuschangeIndex, options[choice]);
                                        jop.showMessageDialog(null, "Status updated successfully to: " + status.get(statuschangeIndex),
                                                "Group 4 Admin", jop.INFORMATION_MESSAGE);
                                       }
                                }

                            } else if (convadput == 'x' || convadput == 'X') {
                                adminlop = false;
                                jop.showMessageDialog(null, "Goodbye " + accName.get(foundaccIndex) + "!", "Group 4 Admin Banking Corporation", jop.PLAIN_MESSAGE);
                            }
                        }
                    }

                    // OUTPUT #3 MGA TRANSSACTION
                    if(status.get(foundaccIndex).equals("Active"))
                    {
                        int trloop = 1;
                        while (trloop > 0)
                        {
                            String transact = jop.showInputDialog(null, "Please select type of transaction: \n[B] -> Balance Inquiry \n[W] -> Withdrawal\n[D] -> Deposit \n[T] -> Transfer Fund \n[C] -> Cancel"
                                    , "Group 4 Banking Corporation", jop.QUESTION_MESSAGE);

                            char convtrs = transact.charAt(0);

                            // ALL THE OUTPUT #4 BANKING KENEME
                            if (convtrs == 'B' || convtrs == 'b')
                            {

                                jop.showMessageDialog(null, "Account Number: " + accNum.get(foundaccIndex) + "\n\nAccount Name: " + accName.get(foundaccIndex) + "\n\nAccount Balance: " + balance.get(foundaccIndex), "Group 4 Banking Corporation: Balance Inquiry", jop.INFORMATION_MESSAGE);

                            }
                            else if (convtrs == 'W' || convtrs == 'w')
                            {

                                String withdrawAmount = jop.showInputDialog(null, "Withdrawn amount should not be lower than 100 pesos and should not be insufficient\nValid amount is 100 denomination." +
                                        "\nExample: 100, 200, 1700" +
                                        "\n\nEnter amount to withdraw:", "Group 4: Banking Corporation Withdrawal", jop.QUESTION_MESSAGE);
                                double wdamount = Double.parseDouble(withdrawAmount);

                                if(wdamount <= balance.get(foundaccIndex) && wdamount % 100 == 0)
                                {
                                    balance.set(foundaccIndex, balance.get(foundaccIndex) - wdamount);
                                    jop.showMessageDialog(null, "Withdrawal successful!\nNew balance: " + balance.get(foundaccIndex), "Group 4: Banking Corporation Withdraw", jop.INFORMATION_MESSAGE);

                                }
                                else if (wdamount % 100 != 0)
                                {
                                    jop.showMessageDialog(null, "Invalid Input only 100 Denomination!", "Withdraw Error", jop.ERROR_MESSAGE);

                                }
                                else
                                {
                                    jop.showMessageDialog(null, "Insufficient amount!", "Withdraw Error", jop.ERROR_MESSAGE);
                                }
                            }
                            else if (convtrs == 'D' || convtrs == 'd')
                            {
                                String depositAmount = jop.showInputDialog(null, "Deposit should not be lower than 100.\n\nEnter amount to deposit:", "Group 4: Banking Corporation Deposit", jop.QUESTION_MESSAGE);
                                double depamount = Double.parseDouble(depositAmount);

                                if(depamount < 100)
                                {
                                   jop.showMessageDialog(null, "Deposit Amount invalid!\n\n Deposit amount should be higher than 100.", "Deposit Error", jop.ERROR_MESSAGE);
                                }
                                else
                                {
                                    balance.set(foundaccIndex, balance.get(foundaccIndex) + depamount);
                                    jop.showMessageDialog(null, "Deposit Successful!\n\n Your Balance is now: " + balance.get(foundaccIndex), "Group 4: Banking Corporation Deposit", jop.INFORMATION_MESSAGE);
                                }

                            }
                            else if (convtrs == 'T' || convtrs == 't')
                            {
                                String transferAccount = jop.showInputDialog(null, "Transferring to account number:", "Group 4: Banking Corporation Transfer", jop.QUESTION_MESSAGE);
                                int targetIndex = findAcc(transferAccount);

                                if(targetIndex != -1 && status.get(targetIndex).equals("Active"))
                                {
                                    String transferAmount = jop.showInputDialog(null, "Enter amount to transfer:", "Transfer", jop.QUESTION_MESSAGE);
                                    double amount = Double.parseDouble(transferAmount);

                                    // MERON NA DEDUCTION PERO DI AKO HAPPY SA PROCESS NEED PA IPOLISH


                                    if(amount <= balance.get(foundaccIndex) && amount > 1000)
                                    {
                                        double count = amount / 1000;
                                        double deduct = 25 * count;
                                        amount = amount - deduct;

                                        balance.set(foundaccIndex, balance.get(foundaccIndex) - amount);
                                        balance.set(targetIndex, balance.get(targetIndex) + amount);
                                        jop.showMessageDialog(null, "Transfer successful!\nTransferred " + amount + " to " + accName.get(targetIndex) + "\n\nDeduction: " + deduct + "Your new balance: " + balance.get(foundaccIndex), "Transfer", jop.INFORMATION_MESSAGE);
                                    }
                                    else
                                    {
                                        jop.showMessageDialog(null, "Insufficient funds!", "Error", jop.ERROR_MESSAGE);
                                    }
                                }
                                else
                                {
                                    jop.showMessageDialog(null, "Invalid account!", "Error", jop.ERROR_MESSAGE);
                                }
                            }
                            else if (convtrs == 'C' || convtrs == 'c')
                            {
                                break;
                            }
                            else
                            {
                                jop.showMessageDialog(null, "Invalid Input!" , "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                            }
                        }
                    }

                    // end of the whole main banking shi
                }
                else
                {
                    jop.showMessageDialog(null, "Account Not Found or Blocked!", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                }

            }
            else
            {
                jop.showMessageDialog(null, "\t\tInvalid Input", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
            }
        }
    }
}