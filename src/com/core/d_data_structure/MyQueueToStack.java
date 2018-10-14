package com.core.d_data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 */
public class MyQueueToStack implements MyStack {


    Queue queueA = new LinkedList();
    Queue queueB = new LinkedList();

    @Override
    public void push(Object item) {
        queueA.add(item);
    }

    @Override
    public Object pop() {
        Object retItem = null;
        if (!empty()) {//如果不为空
            while (queueA.size() != 1) {//当队列A的元素个数大于1（不等于1且不为0）
                queueB.add(queueA.remove());//A出队的元素进入B队中
            }
            retItem = queueA.remove();


            Queue queueTemp;
            queueTemp = queueA;
            queueA = queueB;
            queueB = queueTemp;

        } else {
            System.out.println("队列元素为空,无法执行出队操作");
        }

        return retItem;
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    boolean empty() {

        return queueA.isEmpty() && queueB.isEmpty();

    }


    public static void main(String[] args) {

        MyStack myStack = new MyQueueToStack();


        myStack.push("第一个进来");
        myStack.push("第二个进来");
        myStack.push("第三个进来");
        myStack.push("第四个进来");

        System.out.println("        myStack.pop()=" + myStack.pop());
        System.out.println("        myStack.pop()=" + myStack.pop());
        System.out.println("        myStack.pop()=" + myStack.pop());
        System.out.println("        myStack.pop()=" + myStack.pop());
        System.out.println("        myStack.pop()=" + myStack.pop());

    }

//    172.18.186.15


}
