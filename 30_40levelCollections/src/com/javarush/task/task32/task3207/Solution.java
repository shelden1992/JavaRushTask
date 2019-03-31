package com.javarush.task.task32.task3207;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME="double.string";
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
//                registry=LocateRegistry.getRegistry("localhost", 2099);

                    DoubleString stub=(DoubleString) registry.lookup(UNIC_BINDING_NAME);

                    System.out.println(stub.doubleString("Бля " + 1 +" "));
                } catch (NotBoundException | RemoteException e) {
                    e.printStackTrace();


            }
        }
    });

    public static void main(String[] args) {
        //pretend we start rmi server as main thread
        final DoubleStringImpl service=new DoubleStringImpl();

        try {

            Remote stub=UnicastRemoteObject.exportObject(service, 0);
            // инкапсулированный в специальном объекте-заглушке (stub), который является представителем серверного объекта
//            Заглушка находится на клиентском компьютере, а не на сервере.

            registry=LocateRegistry.createRegistry(2099); //через реест клиент по имени// и будет получать ссылку на удаленный обьект
            registry.bind(UNIC_BINDING_NAME, stub);//регистрируем нашу заглушку обькта под именем UNIC_BINDING_NAME
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

        CLIENT_THREAD.start();

        try {
            Thread.sleep(10);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}