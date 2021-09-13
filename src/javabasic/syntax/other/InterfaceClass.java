package javabasic.syntax.other;

@FunctionalInterface
public interface InterfaceClass {

    void printIdentity();

    default void defaultMethod(){System.out.println("super default");}


}
