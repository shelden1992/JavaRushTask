package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods someInterfaceWithMethodsOriginal;

    public CustomInvocationHandler(SomeInterfaceWithMethods s) {
        this.someInterfaceWithMethodsOriginal =s;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println( method.getName()+" in");
Object object =  method.invoke(someInterfaceWithMethodsOriginal, args);
        System.out.println( method.getName()+" out");
        return object;
    }
}
