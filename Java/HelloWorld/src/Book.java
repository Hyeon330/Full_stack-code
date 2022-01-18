class ParentBook {
    String name;
    int price;    

    public void print() {
        System.out.println("책의 이름과 가격 : "
         + name + " " + price);
    }



    public static void main(String[] args) {
        ChildBook childBook
         = new ChildBook("나의 라임오렌지 나무", 10000);

    }
}

class ChildBook extends ParentBook {
    ChildBook(String name, int price) {
        this.name = name;
        this.price = price;
    }
}