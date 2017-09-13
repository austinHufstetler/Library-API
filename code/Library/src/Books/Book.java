package Books;

public class Book {
	
	String author;
	String isbn;
	String title;

	public Book(String author, String isbn, String title) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
