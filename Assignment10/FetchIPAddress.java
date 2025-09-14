package Assignment10;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FetchIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter website URL (e.g., mail.google.com): ");
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
