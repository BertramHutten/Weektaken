/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bertram
 */
import java.util.Scanner;
public class HelloWorldNaam {
    
    public static void main(String[] args) {
            System.out.print("Hello " + args[0]);
    }
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name:");
        String username = scanner.next();
        System.out.println(String.format("Hello %s", username));



    }

}
