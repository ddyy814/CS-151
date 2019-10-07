

public class HTMLFormatter implements InvoiceFormatter
{

    public String formatHeader()
    {
        total = 0;
        return "<html><body bgcolor=#ADD8E6><p><center><big><i><b><font color=#9932CC>   I N V O I C E </font><br><br><br>\n\n\n";
    }

    public String formatLineItem(LineItem item)
    {
        double hammerPrice = 19.95;
        double bundlePrice = 26.91;
        total = (tester.num_bundle * bundlePrice) + (tester.num_hammer * hammerPrice);
        return (String.format(
                "<p><center><b><font color=#F08080> %s: $%.2f\n</font><br>",item.toString(),item.getPrice()));
    }

    public String formatFooter()
    {
        return (String.format("<p><center><b><font color=#2F4F4F>\n\n TOTAL DUE: $%.2f\n</font>", total));
    }

    private double total;
    private InvoiceTester tester = new InvoiceTester();

}