package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = scan.nextInt();
		System.out.println("Check-In date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.println("Check-Out date (dd/MM/yyyy): " );
		Date checkOut = sdf.parse(scan.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
			
		}else {
			Reservation reservation =new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Check-Out date (dd/MM/yyyy): " );
			checkOut = sdf.parse(scan.next());
			
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: update data must be after for chack-in and check-out");
				
			}else if(!checkOut.after(checkIn)){
				System.out.println("Error in reservation: check-out date must be after check-in date");
			}
			
			else {
				reservation.upDateDates(checkIn, checkOut);
				System.out.println("reservation: " + reservation);
			}
			
		}
	}

}
