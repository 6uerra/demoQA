package Models;

public class Books {
    private static String title;
    private static String author;

    private static String publisher;

    public Books(String title, String author, String publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }


    public static String getTitle(){
        return title;
    }

    public static String getAuthor(){
        return author;
    }

    public static String getPublisher(){
        return publisher;
    }
}
