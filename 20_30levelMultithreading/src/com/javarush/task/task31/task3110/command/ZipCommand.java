package com.javarush.task.task31.task3110.command;

public abstract class ZipCommand implements Command {
    @Override
    public void execute() throws Exception {

    }  //команды, которые работают непосредственно с архивом
//    Все команды, которые работают с архивом, должны быть унаследованы от класса ZipCommand
}
