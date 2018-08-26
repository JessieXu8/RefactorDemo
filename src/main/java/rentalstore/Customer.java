package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Vector getRentals() {
        return rentals;
    }

    public void setRentals(Vector rentals) {
        this.rentals = rentals;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        TxtStatement txtStatement = new TxtStatement();
        return txtStatement.getTxtStatement(this);
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getAmount()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe<EM>" + String.valueOf(getTotalAmount()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    double getTotalAmount() {
        double totalAmount = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each.getAmount();
        }
        return totalAmount;
    }

    int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints = each.getFrequentRenterPoints(frequentRenterPoints);

        }
        return frequentRenterPoints;
    }

}
