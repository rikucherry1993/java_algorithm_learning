package designPatterns.decorator.component;

/**
 * 饮料类：所有被装饰者和装饰者的基类
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    /**
     * 获取饮料描述
     * @return 饮料描述
     */
    public String getDescription(){
        return description;
    }

    /**
     * 价格计算
     * @return 价格
     */
    public abstract double cost();
}
