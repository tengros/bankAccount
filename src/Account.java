public class Account {
    private double balance;
    private String name;

    //Konstruktörer
    public Account() {
        this.balance = 0.0;
    }

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    //Metoder
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Minska balansen med uttagsbeloppet
        }

    }

    public void deposit(double amount) {
        balance += amount;
    }

    //Getters & Setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
            }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        // Använd objektets attribut för att skapa en strängrepresentation
        return "Konto: " + this.name + ", Saldo: " + this.balance;
    }
}