package utils;

import java.util.Scanner;

public class ConsoleManager {
    private final Scanner in;

    public ConsoleManager(){
        in = new Scanner(System.in);
    }

    public String read(){
        return in.nextLine().trim();
    }

    public void print(String str){
        System.out.print(str);
    }

    public void println(String str){
        System.out.println(str);
    }
}
