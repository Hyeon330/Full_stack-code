enum Direction {
    // EAST(1, ">"), SOUTH(5, "V"), WEST(-1, "<"), NORTH(10, "^");
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private static final Direction[] DIR_ARR = Direction.values();
    private final int value;
    private final String symbol;

    // enum 생성자는 묵시적으로 private 이므로 외부에서 호출할 수 없다.
    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction of(int dir) {
        if(dir<1 || dir>4) {
            throw new IllegalArgumentException("Invalid value :" + dir);
        }

        return DIR_ARR[dir - 1];
    }

    public Direction rotate(int num) {
        num = num % 4;
        if(num < 0) num += 4;
        return DIR_ARR[(value-1+num) % 4];
    }

    public String toString() {
        return name() + getSymbol();
    }
}

public class EnumExam {
    public static void main(String[] args) {
        // Direction d1 = Direction.EAST;
        // Direction d2 = Direction.valueOf("WEST");
        // Direction d3 = Enum.valueOf(Direction.class, "EAST");
        // // Direction d4 = new Direction(1);

        // System.out.println("d1=" + d1);
        // System.out.println("d2=" + d2);
        // System.out.println("d3=" + d3);

        // System.out.println("d1==d2 ? " + (d1 == d2));
        // System.out.println("d1==d3 ? " + (d1 == d3));
        // System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        // // System.out.println("(d1 > d3) ? " + (d1 > d3)); // 에러
        // System.out.println("d1.compareTo(d3)" + (d1.compareTo(d3)));
        // System.out.println("d1.compareTo(d2)" + (d1.compareTo(d2)));

        // switch (d1) {
        //     case EAST:
        //         System.out.println("The direction is EAST.");
        //         break;
        //     case SOUTH:
        //         System.out.println("The direction is SOUTH.");
        //         break;
        //     case WEST:
        //         System.out.println("The direction is WEST.");
        //         break;
        //     case NORTH:
        //         System.out.println("The direction is NORTH.");
        //         break;
        //     default:
        //         System.out.println("Invalid direction.");
        //         break;
        // }

        Direction[] dArr = Direction.values();

        for (Direction d : dArr) {
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());

        System.out.println(Direction.EAST.rotate(1));
        System.out.println(Direction.EAST.rotate(2));
        System.out.println(Direction.EAST.rotate(-1));
        System.out.println(Direction.EAST.rotate(-2));
    }
}

class Card {
    // static final int CLOVER = 0;
    // static final int HEART = 1;
    // static final int DIAMOND = 2;
    // static final int SPADE = 3;

    // static final int TWO = 0;
    // static final int THREE = 1;
    // static final int FOUR = 2;

    // final int kind;
    // final int num;

    enum Kind {
        CLOVER, HEART, DIAMOND, SPADE
    }

    enum Value {
        TWO, THREE, FOUR
    }

    // final Kind kind;
    // final Value value;
}

class Unit {
    int x, y;
    Direction dir;

    void init() {
        dir = Direction.EAST;
    }
}

enum Transpotation {
    BUS(100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    },
    TRAIN(150) {
        int fare(int distance) { return distance * BASIC_FARE; }
    },
    SHIP(100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    },
    AIRPLANE(300) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    
    abstract int fare(int distance);

    protected final int BASIC_FARE;

    Transpotation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() {
        return BASIC_FARE;
    }
}

class EnumEx3 {
    public static void main(String[] args) {
        System.out.println("bus fare=" + Transpotation.BUS.fare(100));
        System.out.println("train fare=" + Transpotation.TRAIN.fare(100));
        System.out.println("ship fare=" + Transpotation.SHIP.fare(100));
        System.out.println("airplane fare=" + Transpotation.AIRPLANE.fare(100));
    }
}

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    int ordinal;
    String name = "";

    public int ordinal(){return ordinal;}

    MyEnum(String name) {
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t) {
        return ordinal - t.ordinal();
    }
}

abstract class MyTransportation extends MyEnum {
    static final MyTransportation BUS = new MyTransportation("BUS", 100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };

    abstract int fare(int distance);

    protected final int BASIC_FARE;

    private MyTransportation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public String name() {return name;}
    public String toString() {return name;}
}

class EnumEx4 {
    public static void main(String[] args) {
        MyTransportation t1 = MyTransportation.BUS;
        MyTransportation t2 = MyTransportation.BUS;
        MyTransportation t3 = MyTransportation.TRAIN;
        MyTransportation t4 = MyTransportation.SHIP;
        MyTransportation t5 = MyTransportation.AIRPLANE;

        System.out.printf("%s,%d%n", t1.name(), t1.ordinal());
        System.out.printf("%s,%d%n", t2.name(), t2.ordinal());
        System.out.printf("%s,%d%n", t3.name(), t3.ordinal());
        System.out.printf("%s,%d%n", t4.name(), t4.ordinal());
        System.out.printf("%s,%d%n", t5.name(), t5.ordinal());

        System.out.println("t1==t2" + (t1==t2));
        System.out.println("t1.compareTo(t3)" + t1.compareTo(t3));
        
    }
}