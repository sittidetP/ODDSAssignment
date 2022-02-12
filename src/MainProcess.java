
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teale
 */
public class MainProcess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        ForwardProcess fwp = new ForwardProcess(num);
        fwp.StartForwardProcess(num);
    }
}
