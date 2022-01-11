import java.util.ArrayList;

public class ProductTest {
    public static void main(String[] args) {

        System.out.printf("%-8s%-8s%-8s%-8s%s\n", "상품번호", "상품명", "가격", "연도", "제조사");
        System.out.println("-------------------------------------------------");

        ArrayList<Product> products = new ArrayList<Product>();

        products.add(new Product("001", "노트북", 1200000, "2021", "삼성"));
        products.add(new Product("002", "모니터", 300000, "2021", "LG"));
        products.add(new Product("003", "마우스", 30000, "2020", "로지텍"));

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
