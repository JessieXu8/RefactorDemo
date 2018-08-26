package rentalstore;

import java.util.Enumeration;

public class HtmlStatement extends Statement{

    protected String getFooterString(Customer customer) {
        return "<P>You owe<EM>" + String.valueOf(customer.getTotalAmount())
                + "</EM><P>\n"+"On this rental you earned <EM>"
                + String.valueOf(customer.getFrequentRenterPoints())
                + "</EM> frequent renter points<P>";
    }

    protected String getEachString(Rental each) {
        return each.getMovie().getTitle() + ": " + String.valueOf(each.getAmount()) + "<BR>\n";
    }

    protected String getHeaderString(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
