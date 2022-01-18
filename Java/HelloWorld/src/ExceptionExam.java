import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionExam {
    public static void main(String[] args) {
        // try {
        // // 예외를 처리할 코드가 들어가는 곳
        // // 예외 처리 대상

        // } catch (FileNotFoundException e) {
        // // FNFE 일 경우에 여기서 잡는다.

        // } catch (IOException e) {
        // // IOE 일 경우에 여기서 잡는다.

        // } catch (Exception e) {
        // // Exception 모두를 여기서 잡는다.

        // } finally {
        // // 무조건 실행
        // }

    }
}

class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            try {
                result = number / (int) (Math.random() * 10);
                System.out.println(result);
            } catch (Throwable e) {
                System.out.println("===>0");
            }
        }
    }
}

class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            // System.out.println(0 / 0);
            System.out.println(4);

        } catch (Exception e) {
            System.out.println(5);
        }
        System.out.println(6);
    }
}

class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4);
        } catch (ArithmeticException ae) {
            if (ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmetcException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(6);
    }
}

class ExceptionEx8 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4);
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
            System.out.println("예외메시지 : " + ae.getMessage());
        }
        System.out.println(6);
    }
}

class ExceptionEx9 {
    public static void main(String[] args) {
        try {
            Exception e = new Exception("고의로 발생시킴");
            throw e;
        } catch (Exception e) {
            System.out.println("예외메시지 : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료되었음.");
    }
}

class ExceptionEx10 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExceptionEx11 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("일부러 에러 발생!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExceptionEx12 {
    public static void main(String[] args) throws Exception {
        method1();
    }

    private static void method1() throws Exception {
        method2();
    }

    private static void method2() throws Exception {
        throw new Exception("에러 발생하는 연습하기");
    }
}

class ExceptionEx15 {
    public static void main(String[] args) {
        File f = createFile("");
        System.out.println(f.getName() + " success!");
    }

    private static File createFile(String fileName) {
        try {
            if (fileName == null || fileName.equals(""))
                throw new Exception("파일이름이 유효하지 않습니다.");
        } catch (Exception e) {
            fileName = "제목없음23.txt";
        } finally {
            File f = new File(fileName);
            createNewFile(f);
            return f;
        }
    }

    private static void createNewFile(File f) {
        try {
            f.createNewFile();
        } catch (Exception e) {
        }
    }
}

class ExceptionEx16 {
    public static void main(String[] args) throws Exception {
        // PrintWriter out = null;
        // try {
        //     out = new PrintWriter(new FileWriter("제목없음3.txt"));
        //     out.println("What is this?");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally {
        //     if (out != null)
        //         out.close();
        // }
        PrintWriter out = null;
        try (FileWriter f = new FileWriter("OutFile.txt");
        PrintWriter out1 = new PrintWriter(f)) {
            out = out1;
            out = new PrintWriter(new FileWriter("제목없음3.txt"));
            out.println("What is this?");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (out != null)
                out.close();
        }
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
