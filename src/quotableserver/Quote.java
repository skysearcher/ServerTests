package quotableserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Joshua on 4/27/2016.
 */
public class Quote {
    private String author;
    private String quote;
    private List<String> tags;
    public Quote(){
        author = "";
        quote = "";
        tags = new ArrayList<String>();
    }

    public Quote(String givenAuthor, String givenQuote){
        author = givenAuthor;
        quote = givenQuote;
        tags = new ArrayList<String>();
    }

    public Quote(String givenAuthor, String givenQuote, ArrayList<String> givenTags){
        author = givenAuthor;
        quote = givenQuote;
        tags = givenTags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
