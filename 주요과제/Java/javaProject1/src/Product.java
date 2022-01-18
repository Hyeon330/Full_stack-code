public class Product {

    int prdPrice;
    String prdNo, prdName, prdYear, prdMaker;

    Product(String num, String name, int price, String year, String maker) {
        prdNo = num;
        prdName = name;
        prdPrice = price;
        prdYear = year;
        prdMaker = maker;
    }

    @Override
    public String toString() {
        return String.format("%-12s%-" + (11 - hangulCharLength(prdName)) + "s%-10d%-10s%s", prdNo, prdName, prdPrice,
                prdYear, prdMaker);
    }

    int hangulCharLength(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) >= 0xac00 && (int) str.charAt(i) <= 0xd7a3) {
                count++;
            }
        }
        return count;
    }
}