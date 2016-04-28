package quotableserver.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 4/27/2016.
 */
public class QuoteModel {
    private List<Quote> quotes;

    public QuoteModel(){
        quotes = new ArrayList<Quote>();
    }

    public void addQuote(Quote quote){
        quotes.add(quote);
    }



}
