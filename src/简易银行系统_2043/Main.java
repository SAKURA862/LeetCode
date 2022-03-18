package 简易银行系统_2043;

class Bank {
    private long[] balance;
    private int n;

    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > 0 && account1 <= n && account2 > 0 && account2 <= n){
            if(balance[account1 - 1] >= money){
                balance[account1 - 1] -= money;
                balance[account2 - 1] += money;
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(account > 0 && account <= n){
            balance[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(account > 0 && account <= n){
            if(balance[account - 1] >= money){
                balance[account - 1] -= money;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */

public class Main {
    public static void main(String[] args) {

    }
}
