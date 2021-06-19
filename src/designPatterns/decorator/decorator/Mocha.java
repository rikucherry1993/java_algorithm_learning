package designPatterns.decorator.decorator;

import designPatterns.decorator.component.Beverage;

/**
 * 具体装饰者：摩卡
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage base) {
        beverage = base;
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
