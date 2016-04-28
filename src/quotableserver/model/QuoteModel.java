package quotableserver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Joshua on 4/27/2016.
 */
public class QuoteModel {
    private List<Quote> quotes;
    private List<String> tags;
    private Map<String, List<Quote>> tagIndex;
    private Map<String, List<Quote>> authorIndex;

    public QuoteModel(){
        quotes = new ArrayList<Quote>();
    }

    public List<Quote> searchByAuthor(String author){
        return authorIndex.get(author);
    }

    public List<Quote> searchByTag(String tag){
        return tagIndex.get(tag);
    }

    public void addQuote(Quote quote){
        quotes.add(quote);
    }
}
