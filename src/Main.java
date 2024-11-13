abstract class BankTransaction {
    abstract void acceptanceMessage();
    abstract void checkAccountBalance();
    abstract void confirmWithdrawal();
}

class Bank extends BankTransaction {
    @Override
    void acceptanceMessage() {
        System.out.println("Bank: Prośba o wypłatę została przyjęta.");
    }

    @Override
    void checkAccountBalance() {
        System.out.println("Bank: Sprawdzanie stanu konta.");
    }

    @Override
    void confirmWithdrawal() {
        System.out.println("Bank: Potwierdzenie, że wypłata jest możliwa.");
    }
}

class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    void insertCard() {
        System.out.println("Bankomat: Proszę wprowadzić kartę.");
    }

    void enterPIN() {
        System.out.println("Bankomat: Proszę wprowadzić kod PIN.");
    }

    void enterAmount() {
        System.out.println("Bankomat: Proszę wprowadzić kwotę do wypłaty.");
    }

    void dispenseCash() {
        System.out.println("Bankomat: Wypłacanie gotówki.");
    }

    void thankYouMessage() {
        System.out.println("Bankomat: Dziękujemy za skorzystanie z usług banku.");
    }

    void executeTransaction() {
        insertCard();
        enterPIN();
        enterAmount();

        bank.acceptanceMessage();
        bank.checkAccountBalance();
        bank.confirmWithdrawal();

        dispenseCash();
        thankYouMessage();
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);

        atm.executeTransaction();
    }
}
