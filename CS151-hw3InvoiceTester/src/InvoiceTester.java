import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.JTextComponent;


/**
 A program that tests the invoice classes.
 */
public class InvoiceTester
{
    public static int num_hammer = 0;
    public static int num_bundle = 0;
    private static Product newHammer = new Product("Hammer", 19.95);
    private static Product newNails = new Product("Nails", 9.95);
    private static Bundle newBundle = new Bundle();


    public static void main(String[] args)
    {

        final Invoice invoice = new Invoice();
        final InvoiceFormatter htmlFormatter = new HTMLFormatter();         // HTML formatter
        final InvoiceFormatter formatter = new SimpleFormatter();           // Simple formatter


        // This text pane will contain the formatted invoice

        JTextPane jTextPane = new JTextPane();
        jTextPane.setContentType("text/html");
        jTextPane.setText(invoice.format(htmlFormatter));


        // When the invoice changes, update the text area
       invoice.addChangeListener(event ->
               jTextPane.setText(invoice.format(htmlFormatter)));

        // Add line items to a combo box
        final JComboBox combo = new JComboBox();
        Product hammer = new Product("Hammer", 19.95);
        Product nails = new Product("Assorted nails", 9.95);
        combo.addItem(hammer);
        Bundle bundle = new Bundle();
        bundle.add(hammer);
        bundle.add(nails);

        newBundle.add(newHammer);
        newBundle.add(newNails);

        combo.addItem(new DiscountedItem(bundle, 10));

        // Make a button for adding the currently selected
        // item to the invoice
        JButton addButton = new JButton("Add");
        addButton.addActionListener(event ->
        {
            LineItem item = (LineItem) combo.getSelectedItem();
                if(item.toString().startsWith("Hammer")){
                    num_hammer += 1;
                    invoice.add_hammer();
                }
                if(item.toString().startsWith("Bundle")){
                    num_bundle++;
                    invoice.add_bundle();
                }
        });

        // Put the combo box and the add button into a panel
        JPanel panel = new JPanel();
        panel.add(combo);
        panel.add(addButton);

        // Add the text area and panel to the frame
        JFrame frame = new JFrame();

        frame.setPreferredSize(new Dimension(550,550));

        frame.add(new JScrollPane(jTextPane),
                BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
