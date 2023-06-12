import java.io.*;

// Write a cash register class.
public class cashRegister
{
    private static int numCashRegistersCreated = 0;
    private static int numTransactionsReceived = 0;
    private static double sumTransactionsAmount = 0.0;
    
    public cashRegister() {
        ++ numCashRegistersCreated;
    }

    // add an amount to a running total and increments the number of transactions
    public void AddTransaction(double amount) {
        sumTransactionsAmount += amount;
        ++ numTransactionsReceived;
    }

    // sets the total amount and transaction count to 0
    public void ResetTransactions() {
        sumTransactionsAmount = 0.0;
        numTransactionsReceived = 0;
    }
    
    // returns the number of cash registers created
    public static int RegisterCount() {
        return numCashRegistersCreated;
    }

    // returns the number of transactions received
    public static int TransactionCount() {
        return numTransactionsReceived;
    }

    // returns the sum of the amounts of the transactions
    public static double Total() {
        return sumTransactionsAmount;
    }

// Next, write an application that instantiates at least two cash register objects to prove that your class works.
// P.S.: Don't worry about storing each individual transaction, and we are dealing only with totals. No need to handle individual orders/items per transaction
    public static void main(String[] argv) 
        throws IOException
    {
        cashRegister McDonalds = new cashRegister();
        McDonalds.AddTransaction(11.0);
        McDonalds.AddTransaction(12.0);

        cashRegister BurgerKing = new cashRegister();
        BurgerKing.AddTransaction(13.0);

        System.out.println("The number of registers is " + RegisterCount());
        System.out.println("The total number of transactions is " + TransactionCount());
        System.out.println("The total amount for all of the transactions is $" + Total());
    }
}
