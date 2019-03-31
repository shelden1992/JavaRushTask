package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Message;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();

    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String name = "date_bot_";
        int x = (int) (Math.random() * 100);
        return name + String.valueOf(x);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
//            Date date = null;
            SimpleDateFormat simpleDateFormat = null;
            super.processIncomingMessage(message);
            if (message.contains(": ")) {
                String[] arg = message.split(": ");
                if (arg.length == 2) {
                    String userQuestion = arg[1];
                    String userName = arg[0];
                    switch (userQuestion) {
                        case ("дата"):
                            simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                            break;
                        case ("день"):
                            simpleDateFormat = new SimpleDateFormat("d");
                            break;
                        case ("месяц"):
                            simpleDateFormat = new SimpleDateFormat("MMMM");
                            break;
                        case ("год"):
                            simpleDateFormat = new SimpleDateFormat("YYYY");
                            break;
                        case ("время"):
                            simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                            break;
                        case ("час"):
                            simpleDateFormat = new SimpleDateFormat("H");
                            break;
                        case ("минуты"):
                            simpleDateFormat = new SimpleDateFormat("m");
                            break;

                        case ("секунды"):
                            simpleDateFormat = new SimpleDateFormat("s");
                            break;


                    }
                    if (simpleDateFormat != null) {
                        String dateString = simpleDateFormat.format(Calendar.getInstance().getTime());
                        String botAnswer = String.format("Информация для %s: %s", userName, dateString);
                        sendTextMessage(botAnswer);
                    }
                }

            }
        }
    }
}


