package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen=HenFactory.getHen(Country.RUSSIA);

        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen=null;
              if (country.equals("Belarus")){

            return hen = new BelarusianHen();}
            else if (country.equals("Moldova"))
                  return hen = new MoldovanHen();
              else if (country.equals("Ukraine"))
                  return hen = new UkrainianHen();
              else return  hen = new RussianHen();

        }
    }
}
      abstract class Hen implements Country{
        abstract int getCountOfEggsPerMonth();
         String getDescription(){
             return "Я - курица.";
         }
    }

      class RussianHen extends  Hen implements Country{
          @Override
          int getCountOfEggsPerMonth() {
              return 1;
          }

          @Override
          String getDescription() {
//              return "Русские свиньи";
              return super.getDescription() + " Моя страна - Russia. " + "Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
          }
      }

      class UkrainianHen extends Hen implements Country{
          @Override
          int getCountOfEggsPerMonth() {
              return 6;
          }
          @Override
          String getDescription() {
              return super.getDescription()+ " Моя страна - Ukraine. " + "Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
          }
      }
      class MoldovanHen extends Hen implements Country{
          @Override
          int getCountOfEggsPerMonth() {
              return 4;
          }

          @Override
          String getDescription() {
              return super.getDescription()+ " Моя страна - Moldova. " + "Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
          }
      }
      class BelarusianHen extends Hen implements Country{
          @Override
          int getCountOfEggsPerMonth() {
              return 3;
          }

          @Override
          String getDescription() {
              return super.getDescription() + " Моя страна - Belarus. " + "Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
          }
      }





