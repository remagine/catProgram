package org.example.test;

public class Test {
    Test(){
        System.out.println("test constructor");
    }

    {
        System.out.println("test instant init");
    }
    public static void main(String[] args) {
        System.out.println("hello world");
        Test test = new Test();
    }
}
