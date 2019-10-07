/*
 A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
    private InvoiceTester tester = new InvoiceTester();
    private double total;

    public String formatHeader()
    {
        total = 0;
        return "I N V O I C E !\n\n\n";
    }


    public String formatLineItem(LineItem item)
    {
        double hammerPrice = 19.95;
        double bundlePrice = 26.91;
        total = (tester.num_bundle * bundlePrice) + (tester.num_hammer * hammerPrice);
        return (String.format(
                "%s: $%.2f\n",item.toString(),item.getPrice()));
    }

    public String formatFooter()
    {
        return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
    }


}
