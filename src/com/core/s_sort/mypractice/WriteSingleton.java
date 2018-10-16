package com.core.s_sort.mypractice;
public class WriteSingleton {


    private WriteSingleton() {
    }



    private static  class SingletonHolder{

        private static final WriteSingleton INSTANCE =new WriteSingleton();

    }

    public static WriteSingleton getInstance (){
        return SingletonHolder.INSTANCE;
    }





}
