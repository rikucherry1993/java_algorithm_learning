package designPatterns.decorator.decorator;

import designPatterns.decorator.component.Beverage;

/**
 * 具体装饰者：豆浆
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage base) {
        beverage = base;
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
