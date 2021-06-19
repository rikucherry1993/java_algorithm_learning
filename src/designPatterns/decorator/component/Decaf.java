package designPatterns.decorator.component;

/**
 * 组件：低咖啡因咖啡
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
