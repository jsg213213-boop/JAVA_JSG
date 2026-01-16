package Class_260116;

public class BankAccount {
    private final String owner;
    public static int accountCount = 0;
    public static final double INTEREST_RATE = 0.015;

    public BankAccount(String owner) {
        this.owner = owner;
        accountCount++;
    }

    public void info() {
        System.out.println("예금주: " + owner);
    }

    public static void showInfo() {
        System.out.println("총 계좌 수: " + accountCount);
        System.out.println("이자율: " + INTEREST_RATE);
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("철수");
        BankAccount b2 = new BankAccount("영희");
        b1.info();
        BankAccount.showInfo();
    }
}
