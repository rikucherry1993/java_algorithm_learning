package com.company;

import other.InterfaceClass;
import other.SubClass;

import java.util.*;
import java.util.function.Function;

/**
 * Prepare for JAVA SE 8 Gold test
 * <p>Each method stands for a study point</p>
 *
 * @author Cherry
 * @since 2020.5
 */
public class Main {

    // Method identifier
    enum Identifier {
        /*------ Basics ----------*/
        INSTANCE_ASSIGNMENT,FALL_THROUGH,CALL_METHOD_FROM_OTHER_PACKAGE,
        FUNCTIONAL_INTERFACE,DATA_STRUCTURE_COLLECTION,
        /*-----Algorithm --------*/
        TEST_392
    }


    // Entry point.
    public static void main(String[] args) {

        /*-------- Set identifier to decide witch method to go ---------- */
        Identifier id = Identifier.TEST_392;

        switch (id) {
            case INSTANCE_ASSIGNMENT :
                instanceAssignment();
                break;
            case FALL_THROUGH:
                doFallThrough();
                break;
            case CALL_METHOD_FROM_OTHER_PACKAGE:
                callMethodFromOtherPackage();
                break;
            case FUNCTIONAL_INTERFACE:
                functionalInterface();
                break;
            case DATA_STRUCTURE_COLLECTION:
                operateCollection();
                break;
            case TEST_392:
                execute_392();
            default:
                break;
        }

        /*-------- */

    }


    /**
     * 1-1
     */
    private static void instanceAssignment() {

        Item a = new Item();
        Item b = new Item();
        a.name = "apple";
        b.price = 100;
        a.price = 200;
        b.name = "banana";
        a = b;

        a.printInfo();
    }


    /**
     * 1-2
     */
    private static void doFallThrough() {
        int msg = 1;
        // fall through
        switch (msg) {
            case 1:
                msg++;
            case 3:
                msg++;
        }

        System.out.println(msg);

    }


    /**
     * 1-3
     */
    private static void callMethodFromOtherPackage(){

//        SubClass sub = new SubClass(); // compile error caused by default constructor didn't exist.

        SubClass sub = new SubClass("I am main class.");
        boolean flagInAbstractClass = sub.getFlagFromOutside();
        System.out.println(flagInAbstractClass);

        sub.printIdentity();

        //test for System.Out.Println
        System.out.println(sub);
        System.out.println(sub.getFlagFromOutside());


    }


    /**
     * 1-4 lambda & anonymous function
     */
    private static void functionalInterface(){

        // function interface 可以用下面两种方式
         new InterfaceClass(){
             @Override
             public void printIdentity() {
                 System.out.println("I am from function interface1 ");
             }
         }.printIdentity();

        // Lambda
        ((InterfaceClass) () -> System.out.println("I am from function interface2 ")).printIdentity();

        // another way to write lambda
        InterfaceClass ifClass = () -> System.out.println("I am from function interface3 ");
        ifClass.printIdentity();

        Function<List<String>, String> fuc = strings -> strings.get(0);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(fuc.apply(list));

    }


    /**
     * 2-1 collection queue&deque
     */
    private static void operateCollection(){
        //collection queue&deque
        //FIFO
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println(queue);
        System.out.println("peek(): " + queue.peek());//1

        //FIFO
        Deque<String> deque = new ArrayDeque<String>();
        deque.offer("3");
        deque.add("1");
        deque.add("2");
        System.out.println(deque);
        System.out.println("peek(): " + deque.peekLast());//2
        System.out.println("element(): " + deque.element());//3
        deque.poll();
        System.out.println(deque);
        System.out.println("element(): " + deque.element());//1

        //LIFO
        for (; 0 < deque.size(); ) {
            deque.remove();
        }
        deque.push("3");
        deque.push("1");
        deque.push("2");
        System.out.println(deque);
        System.out.println("peek(): " + deque.peek());//2
        deque.pop();
        System.out.println(deque);
    }


    /**
     * #392
     */
    private static void execute_392(){
        boolean result = Algorithm.isSubsequence(Algorithm.s_392,Algorithm.t_392);
        System.out.println("执行结果是：" + result);
        System.out.println("期待结果是：true");
    }

}

