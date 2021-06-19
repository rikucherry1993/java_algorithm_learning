package designPatterns.decorator.decorator;

import designPatterns.decorator.component.Beverage;

/**
 * 具体装饰者：牛奶
 */
public class Milk extends CondimentDecorator {

    public Milk(Beverage base) {
        beverage = base;
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
