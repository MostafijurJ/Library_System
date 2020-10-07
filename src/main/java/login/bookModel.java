package login;

public class bookModel {
    private  String BookName, authorName, Version, Price;
    private String username;



    public bookModel(String bookName, String authorName, String version, String price, String Username) {
        BookName = bookName;
        this.authorName = authorName;
        Version = version;
        Price = price;
        this.username = Username;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
