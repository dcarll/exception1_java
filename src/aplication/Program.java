package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import nodel.exception.DomainException;

public class Program {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = scan.nextInt();
			System.out.println("Check-In date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
	
			reservation.upDateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
		}catch (ParseException e) {
			System.out.println("Vc digitou uma data como formato inválido");
		}catch (DomainException e) {
			System.out.println("Erro na reserva" + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Error inesperado");
		}

	}

}
