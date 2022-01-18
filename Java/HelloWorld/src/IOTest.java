import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class IOTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            // BufferedOutputStream의 버퍼 크기를 5로 한다.
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

            // 파일 123.txt에 1 부터 9까지 출력한다.
            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }

            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FileReaderEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "123.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;

            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            fis.close();

            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
