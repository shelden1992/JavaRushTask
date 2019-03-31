package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue=queue;
    }

    @Override
    public synchronized void run() {
//
        for (int i=1; i <= 9; i++) {
            try {
                ShareItem shareItem=new ShareItem(i);
                queue.offer(shareItem);

//                System.out.format("Элемент '%s' добавлен \n", shareItem.description);
                System.out.format("Элемент 'ShareItem-%d' добавлен\n", shareItem.itemId);


                Thread.sleep(100);

                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!");
                }

            } catch (InterruptedException e) {
//                    e.printStackTrace();
            }

        }
    }
}
