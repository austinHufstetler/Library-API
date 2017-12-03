package keywords;

import common.*;

public class Keyword extends LibraryObject{

	private String key;

	public Keyword(String key){
		this.key = key;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return this.key;
	}
}