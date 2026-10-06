import java.util.ArrayList;
import java.util.List;

public class AccountRegister {
    private List<Account> accounts = new ArrayList<>();

    public void createAccount(String name, int balance){
        Account account = new Account(name, balance);
        accounts.add(account);
    }

    public void printAll() {
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            System.out.println("Konto: " + a.getName() + " | Saldo: " + a.getBalance());
        }
    }

    public Account findAccount(String name){
        for (int i = 0; i<accounts.size(); i++){
            Account a = accounts.get(i);
            if (a.getName().equalsIgnoreCase(name)){
                return a;
            }
        }
        return null;
    }
}