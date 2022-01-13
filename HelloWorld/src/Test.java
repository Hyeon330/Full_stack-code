import java.util.HashMap;

import javax.activity.InvalidActivityException;

public class Test {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("홍길동", new Integer(90));
        map.put("홍길동", new Integer(100));

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }
    }
}
