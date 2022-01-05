package tryTest;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ExceptionEx9 {
    public static void main(String args[]) {
        try {
            Exception e = new Exception("고의로 발생시킴");
            throw e; // 예외를 발생시킴
            // throw new Exception("고의로 발생시킴"); --> 위에 두줄을 한줄로 표현

        } catch (Exception e) {
            System.out.println("예외메세지 : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료되었음.");

    }
}

class ExceptionEx10 {
    public static void main(String args[]) {
        try {
            throw new Exception(); // 고의로 Exception을 발생시킨다.
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ExceptionEx11 {
    public static void main(String args[]) {
        try {
            throw new RuntimeException(); // 고의로 RuntimeException을 발생시킨다.
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ExceptionEx12 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("haha");
        }

    }

    static void method1() throws Exception {
        method2();
    }

    static void method2() throws Exception {
        try {
            throw new Exception("에러 발생하는 연습하기");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

// class ExceptionEx15 {
// public static void main(String[] args) {
// // command line에서 입력받은 값을 이름으로 갖는 파일을 생성한다.
// File f = createFile("");
// System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
// }

// static File createFile(String fileName) {
// try {
// if (fileName == null || fileName.equals(""))
// throw new Exception("파일이름이 유효하지 않습니다.");
// } catch (Exception e) {
// // fileName이 부적절한 경우, 파일 이름을 '제목없음.txt'로 한다.
// fileName = "제목없음.txt";
// } finally {
// File f = new File(fileName);
// createNewFile(f);
// return f;
// }
// } // createFile메서드의 끝

// static void createNewFile(File f) {
// try {
// f.createNewFile(); // 파일을 생성한다.
// } catch (Exception e) {
// }
// }

// }

class ExceptionEx16 {
    public static void main(String[] args) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter("제목없음.txt"));
            out.println("hello");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        // try(FileWriter f = new FileWriter("hello.txt");
        // PrintWriter out = new PrintWriter(f)) {
        // out = new PrintWriter(new FileWriter("제목없음.txt"));
        // out.println("haha");
        // }

        // }
    }
}

class MyException extends Exception {
    private final int ERR_CODE;

    MyException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    MyException(String msg) {
        this(msg, 100);
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}