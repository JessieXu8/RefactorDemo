package rentalstore;

import java.util.Enumeration;

public abstract class Statement {
    public String getStatement(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += getEachString(each);
        }
        result += getFooterString(customer);
        return result;
    }

    protected abstract String getFooterString(Customer customer);

    protected abstract String getEachString(Rental each);

    protected abstract String getHeaderString(Customer customer);


}
