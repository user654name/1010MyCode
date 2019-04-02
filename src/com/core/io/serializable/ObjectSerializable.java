package com.core.io.serializable;

import java.io.*;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/2
 * @time 13:07
 * @package com.core.io.serializable
 * @project 1008MyDemo
 * @description
 */
public class ObjectSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("d:/abc.txt");

        Dog dog = new Dog();
        dog.setNum(1);
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
        stream.writeObject(dog);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Dog o = (Dog) in.readObject();
        System.out.println(o);

    }


}

class Dog implements Serializable {
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "num=" + num +
                '}';
    }
}

