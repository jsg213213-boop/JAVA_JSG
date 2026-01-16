package Class_260116;

public class Book2 {
    String title;


    Book2(String title) {
        this.title = title;
    }

    public static void main(String[] args) {

        Book2 b1 = createBook("자바 입문");
        Book2 b2 = createBook("AI 시대 코딩");
        Book2 b3 = createBook("클린 코드");


        Book2[] books = {b1, b2, b3};


        System.out.println("--- 도서 목록 출력 ---");
        for (Book2 book : books) {
            printBook(book);
        }
    }


    static void printBook(Book2 b) {
        System.out.println("제목: " + b.title);
    }


    static Book2 createBook(String title) {
        return new Book2(title);
    }
}
