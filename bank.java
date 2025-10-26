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
                if(acc.getStatus().equals("Active"))
                {
                    return acc;
                }
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
        accounts acc6 = new accounts("0000-0000-0000", "Zen Admin", 10000, "0000", "Active");

        account.add(acc1);
        account.add(acc2);
        account.add(acc3);
        account.add(acc4);
        account.add(acc5);
        account.add(acc6);


        while(f > 0) {
            String firmenu = jop.showInputDialog(null,
                    "==========================================\n" +
                            "                             [S] -> Start\n                             [Q] -> Quit\n" +
                            "==========================================",
                    "Group 4 Banking Corporation" , jop.PLAIN_MESSAGE);

            char conv = firmenu.charAt(0);

            if (conv == 'Q' || conv == 'q') {
                System.exit(0);
            } else if (conv == 'S' || conv == 's') {

                String secmenu = jop.showInputDialog(null, "                 Input Account Number\n" +
                                "           FORMAT -> xxxx-xxxx-xxxx-xxxx"
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
                            jop.showMessageDialog(null, "PIN VERIFIED! Welcome, " + foundacc.getAccName(), "Group 4 Banking Corporation", jop.INFORMATION_MESSAGE);
                            break;
                        }
                        else
                        {
                            p--;
                            jop.showMessageDialog(null, "INCORRECT PIN " + p + " TRIES REMAINING.", "Group 4 Banking Corporation", jop.WARNING_MESSAGE);
                            if (p == 0)
                            {
                                jop.showMessageDialog(null, "CAPTURED CARD.... PLEASE CALL Me <3 \nTOO MANY FAILED ATTEMPTS, YOUR ACCOUNT IS NOW BLOCKED.", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                                foundacc.status = "Blocked";
                            }
                        }
                    }

                    String transact = jop.showInputDialog(null, "Please select type of transaction: \n [B] -> Balance Inquiry \n[W] -> Withdrawal\n [D] -> Deposit \n[T] -> Transfer Fund \n[C] -> Cancel"
                            , "Group 4 Banking Corporation" , jop.QUESTION_MESSAGE);

                    char convtrs = transact.charAt(0);

                    if(convtrs == 'B'){

                    }
                    else if(convtrs == 'W')
                    {

                    }
                    else if(convtrs == 'W')
                    {

                    }
                    else if(convtrs == 'W')
                    {

                    }
                    else if(convtrs == 'W')
                    {

                    }
                    else if(convtrs == 'W')
                    {

                    }
                    else if(convtrs == 'W')
                    {

                    }




                } else {
                    jop.showMessageDialog(null, "Account Not Found or Blocked!", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
                }

            } else {
                jop.showMessageDialog(null, "\t\tInvalid Input", "Group 4 Banking Corporation", jop.ERROR_MESSAGE);
            }
        }
        // END of while loop nakakainis talaga kanina pato


    }
}