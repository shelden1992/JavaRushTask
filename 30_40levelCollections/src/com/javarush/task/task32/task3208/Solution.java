package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    private static final String BINDING_NAME1="CAT_SERVER";
    private static final String BINDING_NAME2="DOG_SERVER";
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                registry=LocateRegistry.getRegistry("localhost", 2099);
                for (String bindingName : registry.list()) {
                    Animal service=(Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace(System.err);
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD=new Thread(new Runnable() {
        @Override
        public void run() {


            try {
                final Animal stub1=new Cat("Zefir");
                final Animal stub2=new Dog("Gabrik");
                registry=LocateRegistry.createRegistry(2099);

                Remote stubCat=UnicastRemoteObject.exportObject(stub1, 0);

                Remote stubDog=UnicastRemoteObject.exportObject(stub2, 0);

                registry.bind(BINDING_NAME1, stubCat);
                registry.bind(BINDING_NAME2, stubDog);

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }
            //напишите тут ваш код
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}