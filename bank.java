import javax.swing.JOptionPane;
import java.util.ArrayList;

public class bank
{
    // Customer data stored in ArrayLists
    static ArrayList<String> accNum = new ArrayList<String>();
    static ArrayList<String> accName = new ArrayList<String>();
    static ArrayList<Double> balance = new ArrayList<Double>();
    static ArrayList<String> pin = new ArrayList<String>();
    static ArrayList<String> status = new ArrayList<String>();

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
        accNum.add("0123-4567-8901");
        accNum.add("2345-6789-0123");
        accNum.add("3456-7890-1234");
        accNum.add("4567-8901-2345");
        accNum.add("5678-9012-3456");
        accNum.add("0000-0000-0000");

        accName.add("Roel Richard");
        accName.add("Dorie Marie ");
        accName.add("Railee Darrel");
        accName.add("Railynne Dessirei");
        accName.add("Raine Dessirei");
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
            String firmenu = JOptionPane.showInputDialog(null,
                    "==========================================\n" +
                            "                             [S] -> Start\n                             [Q] -> Quit\n" +
                            "==========================================",
                    "Group 4 Banking Corporation" , JOptionPane.PLAIN_MESSAGE);

            char conv = firmenu.charAt(0);

            if (conv == 'Q' || conv == 'q')
            {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }
            else if (conv == 'S' || conv == 's')
            {
                // OUTPUT #2
                String secmenu = JOptionPane.showInputDialog(null, "                 Input Account Number\n" +
                                "           FORMAT -> xxxx-xxxx-xxxx"
                        , "Group 4 Banking Corporation", JOptionPane.PLAIN_MESSAGE);

                int foundaccIndex = findAcc(secmenu);

                if(foundaccIndex != -1)
                {
                    JOptionPane.showMessageDialog(null, "          Account Found!", "Group 4 Banking Corporation", JOptionPane.INFORMATION_MESSAGE);

                    //PINNNNNN LOOOOOP
                    int p = 3;

                    while(p > 0)
                    {
                        String pinput = JOptionPane.showInputDialog(null, "               Input Pin Number\n               " +
                                " Format -> XXXX", "Group 4 Banking Corporation", JOptionPane.QUESTION_MESSAGE);

                        if(findPin(foundaccIndex, pinput))
                        {
                            JOptionPane.showMessageDialog(null, "PIN VERIFIED! \nWelcome, " + accName.get(foundaccIndex), "Group 4 Banking Corporation", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        else
                        {
                            p--;
                            JOptionPane.showMessageDialog(null, "INCORRECT PIN. \n" + p + " TRIES REMAINING.", "Group 4 Banking Corporation", JOptionPane.WARNING_MESSAGE);
                            if (p == 0)
                            {
                                JOptionPane.showMessageDialog(null, "CAPTURED CARD.... PLEASE CALL 143-44\nTOO MANY FAILED ATTEMPTS, YOUR ACCOUNT IS NOW BLOCKED.", "Group 4 Banking Corporation", JOptionPane.ERROR_MESSAGE);
                                status.set(foundaccIndex, "Blocked");
                            }
                        }
                    }

                    // OUTPUT #5 ADMIN CONTROLS
                    if(status.get(foundaccIndex).equals("Admin"))
                    {

                        while(true)
                        {
                            String adput = JOptionPane.showInputDialog(null, "What would you like to do?\n" +
                                    "( 1 ) - View Customer Information\n( 2 ) - Search Customer\n( 3 ) - Add New Customer\n" +
                                    "( 4 ) - Edit Customer Information\n( 5 ) - Change Customer Pin Number\n( 6 ) - Transfer Fund\n( 7 ) - Activate/Block Account\n" +
                                    "( X ) - Exit", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);

                            if(adput == null)
                            {
                                JOptionPane.showMessageDialog(null, "No Input", "Admin Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }

                            char convadput = adput.charAt(0);

                            if (convadput == '1')
                            {
                                String allAcc = "";

                                for(int ctr = 0; ctr < accNum.size(); ctr++)
                                {
                                    allAcc += "Account " + ctr + " : " + "Account Number: " + accNum.get(ctr) + " ,  Name: " + accName.get(ctr) + " \nBalance: " + balance.get(ctr) + " ,  Pin: " + pin.get(ctr) + " ,  Status: " + status.get(ctr) + "\n\n";
                                }
                                JOptionPane.showMessageDialog(null, allAcc, "Group 4: Banking Corporation All Customers", JOptionPane.INFORMATION_MESSAGE);

                            } else if (convadput == '2') {
                                String search = JOptionPane.showInputDialog(null, "Enter the Customer's Name or Account Number:", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);

                                int searchedAccIndex = findAccAdmin(search);

                                if (searchedAccIndex != -1) {
                                    String accountInfo = "Account Number: " + accNum.get(searchedAccIndex) + "\n" +
                                            "Account Name: " + accName.get(searchedAccIndex) + "\n" +
                                            "Balance: " + balance.get(searchedAccIndex) + "\n" +
                                            "Status: " + status.get(searchedAccIndex) +
                                            "\nPIN: " + pin.get(searchedAccIndex);

                                    JOptionPane.showMessageDialog(null, accountInfo, "Customer Information", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Account not found! Please check the name and account number.", "Group 4 Admin", JOptionPane.ERROR_MESSAGE);
                                }
                            } else if (convadput == '3') {
                                String newAccNum = JOptionPane.showInputDialog(null, "Enter new account number (xxxx-xxxx-xxxx):", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);

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
                                    JOptionPane.showMessageDialog(null, "Account number already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                {
                                    String newAccName = JOptionPane.showInputDialog(null, "Enter account holder name:", "Add New Customer", JOptionPane.QUESTION_MESSAGE);
                                    String newBalanceStr = JOptionPane.showInputDialog(null, "Enter initial balance:", "Add New Customer", JOptionPane.QUESTION_MESSAGE);
                                    String newPin = JOptionPane.showInputDialog(null, "Enter PIN (4 digits):", "Add New Customer", JOptionPane.QUESTION_MESSAGE);
                                    String newStatus = JOptionPane.showInputDialog(null, "Enter Status (Active, Blocked, Admin)", "Add New Customer", JOptionPane.QUESTION_MESSAGE);

                                    double newBalance = Double.parseDouble(newBalanceStr);

                                    // Add new customer to ArrayLists
                                    accNum.add(newAccNum);
                                    accName.add(newAccName);
                                    balance.add(newBalance);
                                    pin.add(newPin);
                                    status.add(newStatus);

                                    JOptionPane.showMessageDialog(null, "New customer added successfully!\n" +
                                            "Account Number: " + newAccNum + "\n" +
                                            "Account Name: " + newAccName + "\n" +
                                            "Initial Balance: " + newBalance + "\n" +
                                            "Status: " + newStatus, "Group 4 Admin Create Account Success", JOptionPane.INFORMATION_MESSAGE);
                                }

                            } else if (convadput == '4') {
                                String infoChange = JOptionPane.showInputDialog(null, "CHANGE INFORMATION\nInput Name or Account number: ", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);

                                int foundinfoAccIndex = findAccAdmin(infoChange);

                                if (foundinfoAccIndex != -1) {
                                    JOptionPane.showMessageDialog(null, "Found Account!", "Group 4 Admin", JOptionPane.INFORMATION_MESSAGE);

                                    String infochoice = JOptionPane.showInputDialog(null, "[1] -> Change name\n[2] -> Change Account number", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);
                                    char convinfo = infochoice.charAt(0);

                                    if(convinfo == '1') {
                                        String NCchoice = JOptionPane.showInputDialog(null, "Change name to:", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);
                                        accName.set(foundinfoAccIndex, NCchoice);
                                    } else if(convinfo == '2') {
                                        String ANchoice = JOptionPane.showInputDialog(null, "Change Account Number to:", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);
                                        accNum.set(foundinfoAccIndex, ANchoice);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                             else if (convadput == '5')
                             {
                                String pinchange = JOptionPane.showInputDialog(null, "CHANGE PIN\nInput Name or Account number: ", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);

                                int changepinAccIndex = findAccAdmin(pinchange);

                                if(changepinAccIndex != -1)
                                {
                                    String newpin = JOptionPane.showInputDialog(null, "Current pin: " + pin.get(changepinAccIndex) + "\nInput New Pin for " + accName.get(changepinAccIndex) + " : ", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);
                                    pin.set(changepinAccIndex, newpin);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                             else if (convadput == '6')
                             {
                                String admintransfer = JOptionPane.showInputDialog(null, "TRANSFER FUNDS:\nInput Account number or Name: ", "Group 4 Admin Banking Corporation", JOptionPane.QUESTION_MESSAGE);
                                int foundTransferAccIndex = findAccAdmin(admintransfer);

                                if (foundTransferAccIndex != -1)
                                {
                                    JOptionPane.showMessageDialog(null, "Found Account!", "Group 4 Admin", JOptionPane.INFORMATION_MESSAGE);
                                    String admintransferfund = JOptionPane.showInputDialog(null, "Enter amount to transfer:", "Group 4 Admin", JOptionPane.QUESTION_MESSAGE);
                                    int adminparsedtransfer = Integer.parseInt(admintransferfund);

                                    balance.set(foundTransferAccIndex, balance.get(foundTransferAccIndex) + adminparsedtransfer);

                                    JOptionPane.showMessageDialog(null, "Transferred " + adminparsedtransfer + " to " + accName.get(foundTransferAccIndex) +
                                            "\nBalance is now " + balance.get(foundTransferAccIndex), "Group 4 Admin Banking Corporation", JOptionPane.INFORMATION_MESSAGE);

                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Account NOT found!", "Group 4 Admin", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                             else if (convadput == '7')
                             {
                                String adminstatus = JOptionPane.showInputDialog(null, "ACTIVATE/BLOCK/ADMIN\n\nEnter account number or Name:",  "Group 4: Admin", JOptionPane.PLAIN_MESSAGE);

                                int statuschangeIndex = findAccAdmin(adminstatus);

                                  if (statuschangeIndex == -1) {
                                    JOptionPane.showMessageDialog(null, "Account not found!", "Error", JOptionPane.ERROR_MESSAGE);
                                   }
                                  else
                                   {
                                     String[] options = {"Active", "Blocked", "Admin"};
                                    int choice = JOptionPane.showOptionDialog(null,
                                            "Account: " + accName.get(statuschangeIndex) + "\nCurrent status: " + status.get(statuschangeIndex) +
                                                    "\n\nSelect new status:",
                                            "Group 4 Admin Banking Corporation",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null, options, options[0]);

                                      if (choice >= 0)
                                      {
                                        status.set(statuschangeIndex, options[choice]);
                                        JOptionPane.showMessageDialog(null, "Status updated successfully to: " + status.get(statuschangeIndex),
                                                "Group 4 Admin", JOptionPane.INFORMATION_MESSAGE);
                                       }
                                }

                            } else if (convadput == 'x' || convadput == 'X') {
                                JOptionPane.showMessageDialog(null, "Goodbye " + accName.get(foundaccIndex) + "!", "Group 4 Admin Banking Corporation", JOptionPane.PLAIN_MESSAGE);
                                break;
                             }
                        }
                    }

                    // OUTPUT #3 MGA TRANSSACTION
                    if(status.get(foundaccIndex).equals("Active"))
                    {
                        int trloop = 1;
                        while (trloop > 0)
                        {
                            String transact = JOptionPane.showInputDialog(null, "Please select type of transaction: \n[B] -> Balance Inquiry \n[W] -> Withdrawal\n[D] -> Deposit \n[T] -> Transfer Fund \n[C] -> Cancel"
                                    , "Group 4 Banking Corporation", JOptionPane.QUESTION_MESSAGE);

                            char convtrs = transact.charAt(0);

                            // ALL THE OUTPUT #4 BANKING KENEME
                            if (convtrs == 'B' || convtrs == 'b')
                            {

                                JOptionPane.showMessageDialog(null, "Account Number: " + accNum.get(foundaccIndex) + "\n\nAccount Name: " + accName.get(foundaccIndex) + "\n\nAccount Balance: " + balance.get(foundaccIndex), "Group 4 Banking Corporation: Balance Inquiry", JOptionPane.INFORMATION_MESSAGE);

                            }
                            else if (convtrs == 'W' || convtrs == 'w')
                            {
                                while (true) {
                                    String withdrawAmountInput = JOptionPane.showInputDialog(null, "Withdrawn amount should not be lower than 100 pesos and should not be insufficient\nValid amount is 100 denomination." +
                                            "\nExample: 100, 200, 1700" +
                                            "\n\nEnter amount to withdraw:", "Group 4: Banking Corporation Withdrawal", JOptionPane.QUESTION_MESSAGE);

                                    if (withdrawAmountInput == null) {
                                        JOptionPane.showMessageDialog(null, "No Input", "Withdraw Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }

                                    double wdamount = Double.parseDouble(withdrawAmountInput);

                                    if (wdamount <= balance.get(foundaccIndex) && wdamount % 100 == 0) {
                                        balance.set(foundaccIndex, balance.get(foundaccIndex) - wdamount);
                                        JOptionPane.showMessageDialog(null, "Withdrawal successful!\nNew balance: " + balance.get(foundaccIndex), "Group 4: Banking Corporation Withdraw", JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                    } else if (wdamount % 100 != 0) {
                                        JOptionPane.showMessageDialog(null, "Invalid Input only 100 Denomination!", "Withdraw Error", JOptionPane.ERROR_MESSAGE);
                                        break;

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Insufficient amount!", "Withdraw Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                }
                            }
                            else if (convtrs == 'D' || convtrs == 'd')
                            {
                                while(true) {
                                    String depositAmount = JOptionPane.showInputDialog(null, "Deposit should not be lower than 100.\n\nEnter amount to deposit:", "Group 4: Banking Corporation Deposit", JOptionPane.QUESTION_MESSAGE);

                                    if(depositAmount == null)
                                    {
                                        JOptionPane.showMessageDialog(null, "No Input", "Deposit Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                    double depamount = Double.parseDouble(depositAmount);

                                    if (depamount < 100) {
                                        JOptionPane.showMessageDialog(null, "Deposit Amount invalid!\n\n Deposit amount should be higher than 100.", "Deposit Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    } else {
                                        balance.set(foundaccIndex, balance.get(foundaccIndex) + depamount);
                                        JOptionPane.showMessageDialog(null, "Deposit Successful!\n\n Your Balance is now: " + balance.get(foundaccIndex), "Group 4: Banking Corporation Deposit", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }

                            }
                            else if (convtrs == 'T' || convtrs == 't')
                            {
                                String transferAccount = JOptionPane.showInputDialog(null, "Transferring to account number:", "Group 4: Banking Corporation Transfer", JOptionPane.QUESTION_MESSAGE);
                                int targetIndex = findAcc(transferAccount);

                                if(targetIndex != -1 && status.get(targetIndex).equals("Active"))
                                {
                                    String transferAmount = JOptionPane.showInputDialog(null, "Transfer Amount must be 1000 or higher.\n\nEnter amount to transfer:", "Transfer", JOptionPane.QUESTION_MESSAGE);
                                    double amount = Double.parseDouble(transferAmount);

                                    if(amount <= balance.get(foundaccIndex) && amount >= 1000)
                                    {
                                        double temp = amount;
                                        int count = 0;

                                        while (temp >= 1000)
                                        {
                                            count++;
                                            temp -= 1000;
                                        }

                                        double deduct = 25 * count;
                                        double actual = amount - deduct;

                                        balance.set(foundaccIndex, balance.get(foundaccIndex) - actual);
                                        balance.set(targetIndex, balance.get(targetIndex) + actual);
                                        JOptionPane.showMessageDialog(null, "Transfer successful!\nTransferred " + actual + " to " + accName.get(targetIndex) + "\n\nDeduction: " + deduct + "\nYour new balance: " + balance.get(foundaccIndex), "Transfer", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Invalid account!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else if (convtrs == 'C' || convtrs == 'c')
                            {
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Invalid Input!" , "Group 4 Banking Corporation", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }

                    // end of the whole main banking shi
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Account Not Found or Blocked!", "Group 4 Banking Corporation", JOptionPane.ERROR_MESSAGE);
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null, "\t\tInvalid Input", "Group 4 Banking Corporation", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}