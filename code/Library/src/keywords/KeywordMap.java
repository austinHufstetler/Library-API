package keywords;

public class KeywordMap{
	
	private int bookId;

	private int keywordId;

	public KeywordMap(int bookId, int keywordId){
		this.bookId = bookId;
		this.keywordId = keywordId;
	}

	public void setBookId(int bookId){
		this.bookId = bookId;
	}

	public int getBookId(){
		return this.bookId;
	}

	public void setKeywordId(int keywordId){
		this.keywordId = keywordId;
	}

	public int getKeywordId(){
		return this.keywordId;
	}

}