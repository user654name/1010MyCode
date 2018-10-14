package com.core.d_data_structure;

import java.util.Stack;

public class MyStackToQueue implements MyQueue {

    //准备好两个栈
    Stack stackA = new Stack();
    Stack stackB = new Stack();


    //入队
    @Override
    public void in(Object object) {
        stackA.push(object);
    }

    //出队
    @Override
    public Object out() {
        Object ret = null;

        if (!isEmpty()) {//元素不空 可以出队
            if (stackB.empty()) {//若栈B是空的
                //将A的元素转移到栈B
                while (!stackA.empty()) {
                    stackB.push(stackA.pop());
                }
                ret = stackB.pop();
            } else {//若栈B有元素
                ret = stackB.pop();
            }

        } else {
            System.out.println("队列空了 不能在出队");
            //当前队列没有元素,不能出队
        }

        return ret;
    }

    public boolean isEmpty() {
        return stackA.empty() && stackB.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyStackToQueue();
        myQueue.in(1);
        myQueue.in(2);
        myQueue.in(3);
        myQueue.in(4);
        myQueue.in(5);

        System.out.println("myQueue.out()"+myQueue.out());
        System.out.println("myQueue.out()"+myQueue.out());
        System.out.println("myQueue.out()"+myQueue.out());
        System.out.println("myQueue.out()"+myQueue.out());

        myQueue.in(6);
        System.out.println("myQueue.out()"+myQueue.out());
        System.out.println("myQueue.out()"+myQueue.out());
        System.out.println("myQueue.out()"+myQueue.out());
        System.out.println("myQueue.out()"+myQueue.out());


    }
}
