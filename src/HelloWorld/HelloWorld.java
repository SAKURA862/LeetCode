package HelloWorld;

public class HelloWorld {
    private static int val = 0;

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (obj1){
                try {
                    Thread.sleep(1000);
                    synchronized (obj2){
                        System.out.println("111");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj2){
                try {
                    Thread.sleep(1000);
                    synchronized (obj1){
                        System.out.println("222");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(val);
    }
}
