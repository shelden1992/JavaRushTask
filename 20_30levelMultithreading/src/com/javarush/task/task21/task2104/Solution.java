package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    @Override
    public boolean equals(Object o) {
        if (!( o instanceof Solution )) {//является ли данный обькт обьект класса Solution
            return false;
        }
        if (this == o) return true; //если наш обьект ==   переданому обьекту
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution=(Solution) o; // приводим переданный обькт к данному обьекту?

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false; //
        if (last != null ? !last.equals(solution.last) : solution.last != null) return false;

        return true;
    }

    public Solution(String first, String last) {

        this.first=first;
        this.last=last;

    }


    public int hashCode() {
        int result=1;
        result=31 * result + ( first != null && last != null ? ( first.hashCode() + last.hashCode() ) : 0 );
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s=new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
//        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println( new Solution(null, "Duck").equals(new Solution("D", "Duck")));
    }
}