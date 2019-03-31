package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {


        @Override
        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(address, port);
                  connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                    continue;
                }
                if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());

                }

                if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());

                }

                if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());

                }


                if (message.getType() != MessageType.TEXT &&
                        message.getType() != MessageType.USER_ADDED &&
                        message.getType() != MessageType.USER_REMOVED) {
                    throw new IOException("Unexpected MessageType");
                }

            }
        }


        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("User " + userName + "added to chat");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("User " + userName + "escape chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }


    public void run() {
        Thread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Client was down");
                return;
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Connection was START, enter 'exit' if want STOP.");
        } else {
            ConsoleHelper.writeMessage("Connection not START, try again.");
        }
        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.equals("exit"))
                break;
            if (shouldSendTextFromConsole()) {
                sendTextMessage(text);
            }

        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter address server:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter port server:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter USER_name :");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Some wrong message not GO");
        }
    }
}
