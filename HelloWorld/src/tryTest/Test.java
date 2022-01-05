package tryTest;

public class Test {
    public static void main(String args[]) throws Exception {

        // error();

    }

    static void error() throws Exception {
        Exception e = new Exception("고의로 발생시킴");
        throw e; // 예외를 발생시킴
        // throw new Exception("고의로 발생시킴"); --> 위에 두줄을 한줄로 표현
    }
}

// class Exercise8_9 {
// public static void main(String[] args) throws Exception{
// throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100)
// }
// }

class UnsupportedFuctionException extends Exception {
    public static void main(String[] args) throws UnsupportedFuctionException {
        throw new UnsupportedFuctionException("지원하지 않는 기능입니다", 100);
    }

    UnsupportedFuctionException(String s, int x) {
        super("[" + x + "] " + s);
    }
}
