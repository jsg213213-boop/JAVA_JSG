package Class_260115;

class Book2 {
    String name;
    int price;
    String writer;


    public Book2(String name, int price, String writer) {
        this.name = name;
        this.price = price;
        this.writer = writer;
    }


    public void introduceBook() {
        System.out.println("--- 책 소개 ---");
        System.out.println("책 제목 : " + name);
        System.out.println("가격    : " + price + "원");
        System.out.println("저자    : " + writer);
        System.out.println(); // 줄바꿈으로 구분
    }
}

public class Book_2_2_ex {
    public static void main(String[] args) {
        // 1. 매개변수가 있는 생성자를 이용하여 3권의 객체 생성
        Book book1 = new Book("장마", 15000, "윤홍길");
        Book book2 = new Book("청춘의덫", 12000, "김수현");
        Book book3 = new Book("펜트하우스", 13000, "김순옥");

        // 2. 각 객체의 소개 기능(메서드) 호출
        book1.introduceBook();
        book2.introduceBook();
        book3.introduceBook();
    }
}