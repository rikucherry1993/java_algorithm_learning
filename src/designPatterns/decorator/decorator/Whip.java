package designPatterns.decorator.decorator;

import designPatterns.decorator.component.Beverage;

/**
 * 具体装饰者：奶泡
 */
public class Whip extends CondimentDecorator {

    public Whip(Beverage base) {
        beverage = base;
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
