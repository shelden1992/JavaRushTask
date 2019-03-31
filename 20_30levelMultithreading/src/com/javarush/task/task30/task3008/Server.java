package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("ENTER PORT NUMBER");
        int port = ConsoleHelper.readInt();

        try (ServerSocket server = new ServerSocket(port)) {

            System.out.println("Server START");
            while (true) {
                try (Socket client = server.accept();) {
                    Handler handler = new Handler(client);
                    handler.start();
                } catch (Exception e) {
                    return;
                }


            }
        } catch (IOException e) {
            System.out.println("Server error");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();
                if (response.getType() == MessageType.USER_NAME) {
                    if (!response.getData().isEmpty()) {
                        if (!connectionMap.containsKey(response.getData())) {
                            String clientName = response.getData();
                            connectionMap.put(clientName, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return response.getData();
                        }
                    }
                }
            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            connectionMap.forEach((client, Connection) -> {
                try {
                    if (!client.equals(userName)) {
                        connection.send(new Message(MessageType.USER_ADDED, client));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {

                Message clientMsg = connection.receive();
                if (clientMsg.getType() == MessageType.TEXT) {
                    String text = new StringBuilder().append(userName + ": ").append(clientMsg.getData()).toString();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }

            }
        }

        public void run() {

            ConsoleHelper.writeMessage(String.valueOf(socket.getRemoteSocketAddress()));
            String userName = " ";
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);


            } catch (IOException | ClassNotFoundException e) {

                ConsoleHelper.writeMessage("Was some ERROR with connection");
            }

            if (!userName.isEmpty()) {

                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Connection was close");
            }

        }

    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        connectionMap.forEach((client, connection) -> {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Message failed");
            }
        });
    }

}
