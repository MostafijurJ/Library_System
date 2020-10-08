package model;

public class ViewBookModel {
     private  int book_id, user_id;
    private  String Book_name, author_name, version, price;

    public ViewBookModel(int book_id, String book_name, String author_name, String version, String price,int user_id) {
        this.book_id = book_id;
        Book_name = book_name;
        this.author_name = author_name;
        this.version = version;
        this.price = price;
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_name() {
        return Book_name;
    }

    public void setBook_name(String book_name) {
        Book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
