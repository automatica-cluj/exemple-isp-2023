package utcluj.isp.curs3.simpleapps.eventticketsystem;

import com.google.zxing.NotFoundException;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //Create ticket

        TicketsManager tm = new TicketsManager();
        PurchasedTicket ticket1 = tm.createTicket("Dan1 Dan1","a@b.c","1234567890","Concert", LocalDateTime.now(),"VIP",100,"2020-12-12");

        tm.generateElectronicTicket(ticket1);

        //validate ticket

        try {
            tm.checkinTicket("C:\\Tickets\\ticket_John Doe.png", "1234567890");
            //System.out.println("QR Code data: " + qrCodeData);
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }

    }
}
