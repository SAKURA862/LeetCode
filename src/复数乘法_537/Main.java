package 复数乘法_537;

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        num1 = num1.substring(0, num1.length() - 1);
        num2 = num2.substring(0, num2.length() - 1);
        String[] n1 = num1.split("\\+");
        String[] n2 = num2.split("\\+");
        return Complex.mul(
                new Complex(Integer.parseInt(n1[0]), Integer.parseInt(n1[1])),
                new Complex(Integer.parseInt(n2[0]), Integer.parseInt(n2[1]))
        ).toString();
    }

    private static class Complex{
        int rea;
        int ima;

        public Complex(){}

        public Complex(int rea, int ima) {
            this.rea = rea;
            this.ima = ima;
        }

        public static Complex mul(Complex n1, Complex n2){
            return new Complex(n1.rea * n2.rea - n1.ima * n2.ima, n1.rea * n2.ima + n1.ima * n2.rea);
        }

        @Override
        public String toString() {
            return rea + "+" + ima + "i";
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
