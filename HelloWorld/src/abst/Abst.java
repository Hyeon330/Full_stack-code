package abst;

public class Abst {
    public static void main(String[] args) {

    }
}

abstract class Player {
    int currentPos;

    Player() {
        currentPos = 0;
    }

    abstract void play(int Pos);

    abstract void stop();

    void play() {
        play(currentPos);
    }
}

class MP3Player extends Player {
    @Override
    void play(int Pos) {
        // TODO Auto-generated method stub

    }

    @Override
    void stop() {
        // TODO Auto-generated method stub

    }
}

abstract class Pokemon {
    String name;

    abstract void skill1();

    abstract void skill2();

    abstract void skill3();

    abstract void skill4();
}

class Pikachu extends Pokemon {
    @Override
    void skill1() {
        System.out.println("10만볼트");
    }

    @Override
    void skill2() {
        System.out.println("번개");
    }

    @Override
    void skill3() {
        System.out.println("볼트태클");
    }

    @Override
    void skill4() {
        System.out.println("전광석화");
    }
}

class Eevee extends Pokemon {
    @Override
    void skill1() {
        System.out.println("꼬리흔들기");
    }

    @Override
    void skill2() {
        System.out.println("울음소리");
    }

    @Override
    void skill3() {
        System.out.println("몸통박치기");
    }

    @Override
    void skill4() {
        System.out.println("애교부리기");
    }
}

interface InterName {
    String HELLO = "hello";
}

class inter implements InterName {
    public static void main(String[] args) {
    }
}