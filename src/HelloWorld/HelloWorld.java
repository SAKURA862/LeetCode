package HelloWorld;

class Test{
    int a;
    Test(int a){
        this.a = a;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Test)
            return this.a == ((Test)obj).a;
        return false;
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Test test1 = new Test(1);
        Test test2 = new Test(1);
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(test1.equals(test2));
    }
}
