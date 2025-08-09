package Hotel_Reservation_System;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HotelReservationSystem {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "admin";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully.");
            while (true) {
                System.out.println("Welcome to the Hotel Reservation System");
                System.out.println("1. Reserve a Room");
                System.out.println("2.View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.println("Choose an option : ");
                int choice = sc.nextInt();
                switch (choice) {

                    case 1:
                        reserveRoom(conn, sc);
                        break;
                    case 2:
                        viewReservations(conn);
                        break;
                    case 3:
                        getRoomNumber(conn, sc);
                        break;
                    case 4:
                        updateReservation(conn, sc);
                        break;
                    case 5:
                        deleteReservation(conn, sc);
                        break;
                    case 0:
                        exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failed.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void reserveRoom(Connection conn, Scanner sc) {
        // Implementation for reserving a room
        try {
            System.out.println("Enter guest name : ");
            String guestName = sc.next();
            System.out.println("Enter room number : ");
            int roomNumber = sc.nextInt();
            System.out.println("Enter contact number : ");
            String contactNumber = sc.next();

            String sql = "INSERT INTO reservations (guest_name, room_number , contact_number)" + "VALUES('" + guestName
                    + "', " + roomNumber + ", '" + contactNumber + "');";

            try (Statement stmt = conn.createStatement()) {
                int affectedRows = stmt.executeUpdate(sql);

                if (affectedRows > 0) {
                    System.out.println("Room reserved successfully.");
                } else {
                    System.out.println("Failed to reserve room.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewReservations(Connection conn) {
        // Implementation for viewing reservations
        String sql = "SELECT * FROM reservations;";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Current Reservations:");
            System.out.println(
                    "+----------------+-----------------+---------------+----------------------+-------------------------+");
            System.out.println(
                    "| Reservation ID | Guest           | Room Number   | Contact Number      | Reservation Date        |");
            System.out.println(
                    "+----------------+-----------------+---------------+----------------------+-------------------------+");

            while (rs.next()) {
                int id = rs.getInt("reservation_id");
                String guestName = rs.getString("guest_name");
                int roomNumber = rs.getInt("room_number");
                String contactNumber = rs.getString("contact_number");
                String reservationDate = rs.getString("reservation_date");

                // Format and display the reservation data in a table-like format
                System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-23s |\n", id, guestName, roomNumber,
                        contactNumber, reservationDate);
            }
            System.out.println(
                    "+----------------+-----------------+---------------+----------------------+-------------------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getRoomNumber(Connection conn, Scanner sc) {
        try {
            System.out.println("Enter reservation ID to get room number: ");
            int reservationId = sc.nextInt();
            System.out.println("Enter Guest Name: ");
            String guestName = sc.next();

            String sql = "SELECT room_number FROM reservations WHERE reservation_id = " + reservationId + " AND guest_name = '"
                    + guestName + "';";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    int roomNumber = rs.getInt("room_number");
                    System.out.println("Room number for reservation ID " + reservationId + " is: " + roomNumber);
                } else {
                    System.out.println("No reservation found with ID " + reservationId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateReservation(Connection conn, Scanner sc) {
        try {
            System.out.println("Enter reservation ID to update: ");
            int reservationId = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.println("Enter new guest name: ");
            String newGuestName = sc.next();
            System.out.println("Enter new room number: ");
            int newRoomNumber = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println("Enter new contact number: ");
            String newContactNumber = sc.next();

            String sql = "UPDATE reservations SET guest_name = '" + newGuestName + "', room_number = " + newRoomNumber
                    + ", contact_number = '" + newContactNumber + "' WHERE reservation_id = " + reservationId + ";";
            try (Statement stmt = conn.createStatement()) {
                int affectedRows = stmt.executeUpdate(sql);
                if (affectedRows > 0) {
                    System.out.println("Reservation updated successfully.");
                } else {
                    System.out.println("No reservation found with ID " + reservationId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteReservation(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter reservation ID to delete: ");
            int reservationId = sc.nextInt();

            if (!reservationExists(conn, reservationId)) {
                System.out.println("Reservation not found for the given ID.");
                return;
            }

            String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;

            try (Statement stmt = conn.createStatement()) {
                int affectedRows = stmt.executeUpdate(sql);

                if (affectedRows > 0) {
                    System.out.println("Reservation deleted successfully!");
                } else {
                    System.out.println("Reservation deletion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean reservationExists(Connection conn, int reservationId) {
        try {
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = " + reservationId;

            try (Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(sql)) {

                return resultSet.next(); // If there's a result, the reservation exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle database errors as needed
        }
    }

    public static void exit() throws InterruptedException {
        System.out.print("Exiting System");
        int i = 5;
        while (i != 0) {
            System.out.print(".");
            Thread.sleep(1000);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Hotel Reservation System!!!");
    }

}
