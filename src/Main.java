import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        ArrayList<Account> accounts = new ArrayList<>();

        System.out.println("Välkommen till Sparbössans folkbank!");
        do {
            System.out.println("Vad vill du göra idag?");
            System.out.println("1. Öppna ett nytt konto");
            System.out.println("2. Se saldot på mina konton");
            System.out.println("3. Sätta in pengar på mitt konto");
            System.out.println("4. Ta ut pengar från mitt konto");
            System.out.println("5. Flytta pengar mellan mina konton");
            System.out.println("6. Avsluta");
            choice = sc.nextInt();
            sc.nextLine();

            String input = "";
            switch (choice) {
                case 1: {

                    System.out.println("Skriv namnet på kontot du vill öppna:");
                    input = sc.nextLine();

                    Account newAccount = new Account(0, input);
                    accounts.add(newAccount);

                    System.out.println("Skapat konto:");
                    Account latestAccount = accounts.get(accounts.size() - 1);
                    System.out.println("Kontonamn: " + latestAccount.getName() + ", Saldo: " + latestAccount.getBalance());
                    System.out.println();
                    break;

                }
                case 2: {
                    System.out.println("Aktuella konton:");
                    for (Account account : accounts) {
                        System.out.println("Kontonamn: " + account.getName() + ", " + " Saldo: " + account.getBalance());
                        System.out.println();
                    }
                    break;

                }

                case 3: {
                    System.out.println("Vilket konto vill du sätta in pengar på?");
                    System.out.println("Tillgängliga konton:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).getName());
                    }

                    System.out.print("Välj ett konto (1-" + accounts.size() + "): ");
                    int accountChoice = sc.nextInt();

                    if (accountChoice < 1 || accountChoice > accounts.size()) {
                        System.out.println("Ogiltigt val.");
                        return;
                    }
                    System.out.print("Ange belopp du vill sätta in: ");
                    double userDeposit = sc.nextDouble();
                    accounts.get(accountChoice - 1).deposit(userDeposit);

                    System.out.println("Uppdaterat saldo för " + accounts.get(accountChoice - 1).getName() + ": " + accounts.get(accountChoice - 1).getBalance());
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("Vilket konto vill du ta ut pengar ifrån?");
                    System.out.println("Tillgängliga konton:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).getName() + " Saldo: " + accounts.get(i).getBalance());
                        ;
                    }
                    System.out.print("Välj ett konto (1-" + accounts.size() + "): ");
                    int accountChoice = sc.nextInt();

                    if (accountChoice < 1 || accountChoice > accounts.size()) {
                        System.out.println("Ogiltigt val.");
                        return;
                    }
                    System.out.print("Ange belopp du vill ta ut: ");
                    double userWithdraw = sc.nextDouble();
                    accounts.get(accountChoice - 1).withdraw(userWithdraw);

                    System.out.println("Uppdaterat saldo för " + accounts.get(accountChoice - 1).getName() + ": " + accounts.get(accountChoice - 1).getBalance());
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("Vilket konto vill du flytta pengar ifrån?");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).getName() + " Saldo: " + accounts.get(i).getBalance());
                        ;
                    }
                    System.out.print("Välj ett konto (1-" + accounts.size() + "): ");
                    int accountChoice = sc.nextInt();


                    System.out.println("Vilket konto vill du flytta pengar till?");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).getName() + " Saldo: " + accounts.get(i).getBalance());
                        ;
                    }
                    System.out.print("Välj ett konto (1-" + accounts.size() + "): ");
                    int accountChoice2 = sc.nextInt();

                    System.out.print("Ange belopp att flytta: ");
                    double userWithdraw = sc.nextDouble();
                    accounts.get(accountChoice - 1).withdraw(userWithdraw);

                    double userDeposit = userWithdraw;
                    accounts.get(accountChoice2 - 1).deposit(userDeposit);

                    System.out.println("Uppdaterat saldo för " + accounts.get(accountChoice - 1).getName() + ": " + accounts.get(accountChoice - 1).getBalance());
                    System.out.println("Uppdaterat saldo för " + accounts.get(accountChoice2 - 1).getName() + ": " + accounts.get(accountChoice2 - 1).getBalance());
                    System.out.println();
                    break;

                }


            }


        } while (choice != 6);
    }
}