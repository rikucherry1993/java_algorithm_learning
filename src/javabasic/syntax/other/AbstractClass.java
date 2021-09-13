package javabasic.syntax.other;

public abstract class AbstractClass {

    private boolean flag = false;

    protected boolean getFlag(){
        return this.flag;
    }

    abstract boolean getFlagFromOutside();
}
