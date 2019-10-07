import java.util.*;
import javax.swing.event.*;

/**
 An invoice for a sale, consisting of line items.
 */
public class Invoice
{
    /**
     Constructs a blank invoice.
     */
    public Invoice()
    {
        items = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public void add_hammer(){
        if(tester.num_bundle == 0){
            items.removeAll(items);
        }else{
            items.removeAll(items);
            items = addItems;
        }
        Product newHammer = new Product("Hammer", 19.95);
        newHammer.ChangeString("Hammer" + "("+ "*" +tester.num_hammer+")");
        items.add(newHammer);
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);
        item1 = items;
    }

    public void add_bundle(){
        items = item1;
        Product newHammer = new Product("Hammer", 19.95);
        Product newNail = new Product("Nail", 9.95);
        Bundle bundle = new Bundle();
        bundle.add(newHammer);
        bundle.add(newNail);
        DiscountedItem newDiscountedItem = new DiscountedItem(bundle, 10);
        if(tester.num_bundle < 2) {
            items.add(newDiscountedItem);
        }
            ChangeEvent event = new ChangeEvent(this);
            for (ChangeListener listener : listeners)
                listener.stateChanged(event);
            addItems = items;
    }

    /**
     Adds a change listener to the invoice.
     @param listener the change listener to add
     */
    public void addChangeListener(ChangeListener listener)
    {
        listeners.add(listener);
    }

    /**
     Gets an iterator that iterates through the items.
     @return an iterator for the items
     */
    public Iterator<LineItem> getItems()
    {
        return new
                Iterator<LineItem>()
                {
                    public boolean hasNext()
                    {
                        return current < items.size();
                    }

                    public LineItem next()
                    {
                        return items.get(current++);
                    }

                    public void remove()
                    {
                        throw new UnsupportedOperationException();
                    }

                    private int current = 0;
                };
    }

    public String format(InvoiceFormatter formatter)
    {
        String r = formatter.formatHeader();
        Iterator<LineItem> iter = getItems();
        while (iter.hasNext())
            r += formatter.formatLineItem(iter.next());
        return r + formatter.formatFooter();
    }

    private ArrayList<LineItem> items;
    private ArrayList<LineItem> item1;
    private ArrayList<LineItem> addItems;
    private ArrayList<ChangeListener> listeners;
    private InvoiceTester tester = new InvoiceTester();

}
