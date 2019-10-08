package cn.liuyiyou.refactoring.chapter01_1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: liuyiyou@liuyiyou.cn
 * @date: 2018/10/18
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
public class Customer {
    private String name;
    private Vector<Rental> rentals;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statment() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentalsEnum = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsEnum.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentalsEnum.nextElement();
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaySented() > 2) {
                        thisAmount += (each.getDaySented() - 2) * 1;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaySented() * 3;
                    break;
                case Movie.CHILDRENDS:
                    thisAmount += 1.5;
                    break;
            }
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaySented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent render points";
        return result;
    }
}
