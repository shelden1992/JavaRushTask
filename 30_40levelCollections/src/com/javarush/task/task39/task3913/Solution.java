package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();

        LogParser logParser=new LogParser(Paths.get("/Users/macuser/Documents/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
//        System.out.println(logParser.list.size());
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println(logParser.getAllUsers());
//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser.getIPsForEvent(Event.LOGIN, null, null));
////        System.out.println(logParser.getIPsForStatus(Status.OK, null,  null));
//        System.out.println(logParser.getNumberOfUsers(null, null));
//        System.out.println(logParser.getNumberOfUsers(null, null));
//        System.out.println(logParser.getNumberOfUserEvents("Amigo", null, null));
////        System.out.println(logParser.getUsersForIP("120.120.120.122",null, null));
////        System.out.println(logParser.getLoggedUsers(null,null));
////        System.out.println(logParser.getDownloadedPluginUsers(null,null));
////        System.out.println(logParser.getWroteMessageUsers(null,null));
////        System.out.println(logParser.getSolvedTaskUsers(null,null));
////        System.out.println(logParser.getSolvedTaskUsers(null,null, 18));
////        System.out.println(logParser.getDoneTaskUsers(null,null, 15));
//        System.out.println(logParser.getDatesForUserAndEvent("Amigo", Event.LOGIN, null, null));
//        System.out.println(logParser.getDatesWhenSomethingFailed(null, null));
//        System.out.println(logParser.getDatesWhenErrorHappened(null, null));
//        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", null, null));
//    }
//        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo", 18,null, null));
//        System.out.println(logParser.getDateWhenUserDoneTask("Amigo", 18, null,null));
//}
//        System.out.println(logParser.getDatesWhenUserWroteMessage("Amigo", null,null));
//        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Amigo", null,null));
//        System.out.println(logParser.getNumberOfAllEvents(null,null));
//        System.out.println(logParser.getAllEvents(null,null));
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null,null));  //3
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(0, null,null));  //1
//        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(15, null,null));  //1
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber( null,null));  //1
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber( null,null));  //1

//        System.out.println(logParser.execute("get event"));
//        System.out.println(logParser.execute("get status for date = \"30.08.2012 16:08:13\""));
//        System.out.println(logParser.execute("get event for date = \"30.08.2012 16:08:13\""));
//        System.out.println(logParser.execute("get user for date = \"30.08.2012 16:08:13\""));
//        System.out.println(logParser.execute("get ip for date = \"30.08.2012 16:08:13\""));
//        System.out.println(logParser.execute( "get status for event = \"DONE_TASK\""));
//        System.out.println(logParser.execute( "get event for event = \"DONE_TASK\""));
//        System.out.println(logParser.execute( "get user for event = \"DONE_TASK\""));
        System.out.println( logParser.execute( "get ip for date = \"13.09.2013 5:04:50\" and date between \"11.12.2000 0:00:00\" and \"03.01.2018 23:59:59\"."));
//        System.out.println( logParser.execute( "get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println( logParser.execute( "get event for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2044 23:59:59\"."));
//
    }
}