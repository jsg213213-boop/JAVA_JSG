package Class_260115;

public class Starbucks {

    String menuName;
    String size;
    boolean isHot;


    public Starbucks(String menuName, String size) {
        this(menuName, size, true);
    }

    public Starbucks(String menuName, String size, boolean isHot) {
        this.menuName = menuName;
        this.size = size;
        this.isHot = isHot;
    }

    public void showMenu() {
        System.out.println("----- Starbucks 주문 내역 -----");
        System.out.println("메뉴 이름 : " + menuName);
        System.out.println("사이즈    : " + size);
        System.out.println("Hot 여부  : " + (isHot ? "Hot" : "Ice")); // true면 Hot, false면 Ice 출력
        System.out.println("------------------------------");
        System.out.println();
    }

    public static void main(String[] args) {

        Starbucks order1 = new Starbucks("아메리카노", "벤티", false);
        Starbucks order2 = new Starbucks("카페라떼", "벤티");
        Starbucks order3 = new Starbucks("초코라떼", "벤티", true);


        order1.showMenu();
        order2.showMenu();
        order3.showMenu();
    }
}
