package com.javarush.task.task38.task3804;

public class FactoryExeption {


    public static Throwable getExeption(Enum e) throws Exception {

        if (e != null) {

            String message=e.toString().substring(0, 1) + e.toString().substring(1).toLowerCase().replaceAll("_", " ");
//        все знаки подчеркивания замените на пробелы. Сообщение должно быть в нижнем регистре за исключением первого символа.
            if (e.equals(ApplicationExceptionMessage.SOCKET_IS_CLOSED) || e.equals(ApplicationExceptionMessage.UNHANDLED_EXCEPTION)) {
                return new Exception(message);

            } else if (e.equals(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT) || e.equals(DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS)) {
                return new RuntimeException(message);
            } else if (e.equals(UserExceptionMessage.USER_DOES_NOT_EXIST) || e.equals(UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS)) {
                return new Error(message);
            }


        }
        return new IllegalArgumentException();
    }
}
