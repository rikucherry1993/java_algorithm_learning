package designPatterns.decorator.component;

/**
 * 组件：深焙咖啡
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
