package designPatterns.decorator;

import designPatterns.decorator.component.Beverage;
import designPatterns.decorator.component.HouseBlend;
import designPatterns.decorator.decorator.Mocha;
import designPatterns.decorator.decorator.Soy;
import designPatterns.decorator.decorator.Whip;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class OrderMain {

    public static void main(String args[]) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);

        Beverage order = new HouseBlend();
        order = new Soy(order);
        order = new Mocha(order);
        order = new Whip(order);

        System.out.println(order.getDescription() + " $" + df.format(order.cost()));
    }
}

