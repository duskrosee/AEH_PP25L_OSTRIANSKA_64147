package pl.pp;

public class mojaOsmaAplikacja {

    static class Konto {
        private String accountNumber;
        private double balance;
        private String ownerName;
        private String email;
        private String phoneNumber;

        Konto() {
        }

        Konto(String accountNumber, double balance, String ownerName, String email, String phoneNumber) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.ownerName = ownerName;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        String getAccountNumber() {
            return accountNumber;
        }

        void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        double getBalance() {
            return balance;
        }

        void setBalance(double balance) {
            this.balance = balance;
        }

        String getOwnerName() {
            return ownerName;
        }

        void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        String getEmail() {
            return email;
        }

        void setEmail(String email) {
            this.email = email;
        }

        String getPhoneNumber() {
            return phoneNumber;
        }

        void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        void deposit(double amount) {
            balance += amount;
            System.out.println("Wpłata PLN " + amount + " została wykonana. Nowe saldo PLN " + balance);
        }

        void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Pobrano PLN " + amount + " z konta, Pozostałe saldo = PLN " + balance);
            } else {
                System.out.println("Brak środków. Masz PLN " + balance + " na koncie.");
            }
        }
    }

    public static void main(String[] args) {
        Konto konto = new Konto("123456789", 1000.0, "Jan Kowalski", "jan@example.com", "123456789");
        konto.withdraw(900.0);
        konto.deposit(250.0);
        konto.withdraw(50.0);
        konto.withdraw(500.0);
    }
}