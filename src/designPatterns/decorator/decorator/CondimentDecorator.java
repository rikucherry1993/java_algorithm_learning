package designPatterns.decorator.decorator;

import designPatterns.decorator.component.Beverage;

/**
 * 抽象装饰者：所有装饰者的基类
 */
public abstract class CondimentDecorator extends Beverage {
    //点单时传入的base饮
    Beverage beverage;

    /**
     * 强制每个装饰者必须重写此方法，以保证描述得以打印
     * @return 饮料描述
     */
    @Override
    public abstract String getDescription();
}
