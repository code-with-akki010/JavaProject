/* 
 Class to fetch the IP Address of a given website.
 It takes a website URL as input, uses InetAddress class 
 to resolve the domain, and prints the corresponding IP address.

 It handles exceptions if the host cannot be resolved
 and ensures proper closing of Scanner object.

 Author: Akshay Basak
 Date: 10-09-2025
*/
package Assignment10;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FetchIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter website URL : ");
        String website = sc.nextLine();

        try {
            // get InetAddress object for the given website
            InetAddress ip = InetAddress.getByName(website);

            // print IP address
            System.out.println("IP Address of " + website + " is: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host: " + website);
        }

        sc.close();
    }
}
