package model;

public class BookModel {
    private  String BookName, authorName, Version, Price;
    int  UserId;



    public BookModel(String bookName, String authorName, String version, String price, int useid) {
        BookName = bookName;
        this.authorName = authorName;
        Version = version;
        Price = price;
        this.UserId = useid;

    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
