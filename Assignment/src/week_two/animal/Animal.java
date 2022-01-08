package week_two.animal;

public class Animal {
    private String name;
    private String location;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        System.out.println("(land, sea, air 중 하나만 입력)");
        if (this.location.equals("land") ||
                this.location.equals("sea") ||
                this.location.equals("air")) {
            this.location = location;
        } else {
            System.out.println("land, sea, air 중 하나만 입력하세요.");
            System.out.println();
        }
    }
}
