import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ThreadExam {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1();
        ThreadEx1_3 t3 = new ThreadEx1_3();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);

        // t1.start();
        // t2.start();
        // t3.start();

        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.printf("소요시간1:" + (System.currentTimeMillis() - ThreadExam.startTime));
    }
}

// 예제 13-1
class ThreadEx1_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println(getName());
        }
    }
}

class ThreadEx1_2 implements Runnable {
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class ThreadEx1_3 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println(getName());
        }
    }
}

// 예제 13-5 페이지 733
class ThreadEx5_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.printf("소요시간2:" + (System.currentTimeMillis() - ThreadExam.startTime));
    }
}

// 예제 13-6
class ThreadEx6 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

// 예제 13-7
class ThreadEx7 {
    public static void main(String[] args) {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}

class ThreadEx7_1 extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

// 예제 13-8
class ThreadEx8 {
    public static void main(String[] args) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();

        th2.setPriority(7);

        System.out.println("Priority of th1(-) :" + th1.getPriority());
        System.out.println("Priority of th2(|) :" + th2.getPriority());

        th1.start();
        th2.start();
    }
}

class ThreadEx8_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++)
                ;
        }
    }
}

class ThreadEx8_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++)
                ;
        }
    }
}

// 예제 13-13
class ThreadEx13 {
    public static void main(String[] args) {
        Thread13_1 th1 = new Thread13_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();
        th1.stop();
        System.out.println("isInterrupted():" + th1.isInterrupted());
    }
}

class Thread13_1 extends Thread {
    public void run() {
        int i = 10;

        while (i != 0 && isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 2500000000l; x++)
                ;
        }
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

// 예제 13-15
class ThreadEx15 {
    public static void main(String[] args) {
        RunImplEx15 r = new RunImplEx15();

        Thread th1 = new Thread(r, "*");
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

class RunImplEx15 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (Exception e) {

            }
        }
    }

}

// 예제 13-20
class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;
        for (int i = 0; i < 200; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20;
            if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt();
            }
            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory:" + gc.usedMemory);
        }
    }
}

class ThreadEx20_1 extends Thread {
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    public void run() {
        while (true) {
            try {
                Thread.sleep(10 * 1000);
            } catch (Exception e) {
                System.out.println("Awaken by interrupt().");
            }

            gc();
            System.out.println("Garbage Collected. Free Memory : " + freeMemory());
        }
    }

    public void gc() {
        usedMemory -= 300;
        if (usedMemory < 0)
            usedMemory = 0;
    }

    public int totalMemory() {
        return MAX_MEMORY;
    }

    public int freeMemory() {
        return MAX_MEMORY - usedMemory;
    }
}

class ThreadEx21 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            balance -= money;
        }
    }
}

class RunnableEx21 implements Runnable {
    Account acc = new Account();

    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance :" + acc.getBalance() + ", money:" + money);
        }
    }
}

// 예제 13-23
class ThreadWaitEx1 {
    public static void main(String[] args) {
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

class ThreadWaitEx2 {
    public static void main(String[] args) {
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

class ThreadWaitEx3 {
    public static void main(String[] args) {
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;

    public Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            String name = Thread.currentThread().getName();
            if (eatFood())
                System.out.println(name + " ate a " + food);
            else
                System.out.println(name + " failed to eat. : :(");
        }
    }

    boolean eatFood() {
        return table.remove(food);
    }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            // 임의의 요리를 꺼내서 테이블에 추가한다.
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

class Table {
    String[] dishNames = { "donut", "donut", "burger" };
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) { // 동기화 추가
        while(dishes.size() >= MAX_FOOD){
            String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    wait();// COOK 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (Exception e) {
                    
                }
        }

        dishes.add(dish);
        notify();
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean remove(String dishName) {
        synchronized(this) {
            String name = Thread.currentThread().getName();

            while(dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    wait();
                    Thread.sleep(500);
                } catch (Exception e) {
                    
                }
            }
            while(true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return true;
                    }
                }

                try {
                    System.out.println(name + " is waiting.");
                    wait(); // 음식이 없는 CUST 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}