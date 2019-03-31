package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Serializable, Closeable {    //это маркер!
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;

        this.out = new ObjectOutputStream(socket.getOutputStream());
        /// Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
//// Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения. (конвекируем именно в обьект!!!)
        this.in = new ObjectInputStream(socket.getInputStream());

    }

    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
            out.flush();
        }

    }

    public Message receive() throws IOException, ClassNotFoundException {
        Message message;
        synchronized (in) {
            message = (Message) in.readObject();
        }
        return message;
    }
    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }


    @Override
    public void close() throws IOException {
        out.close();
        in.close();
        socket.close();
    }

}
