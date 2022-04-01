package lab.demand;

import java.util.ArrayList;
import java.util.List;

public class ManageDemand {

    private Tax tax;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }

    public double calculateTaxes(List<Order> orders) {
        double taxes = 0.0;
        for (Order order : orders) {
            double tax = this.tax.calculateTax(order.getCountry());
            taxes += tax;
        }
        return taxes;
    }

    public double calculateQuantity(List<Order> orders) {
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }
        return quantities;
    }

    public double calculateTotal(List<Order> orders){
        return calculateTaxes(orders) * calculateQuantity(orders);
    }
    
    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, ArrayList<Double> additional){
        // Calculate additionals by country
        double taxes = 0.0;
        for (Order order : orders) {
            String currCountry = order.getCountry();
            if (currCountry.equals("PE")) {
                taxes += additional.get(0);
            } else if (currCountry.equals("BR")) {
                taxes += additional.get(1);
            } else {
                taxes += additional.get(2);
            }
        }
        return calculateQuantity(orders) * taxes;
    }

}
