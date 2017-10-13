package test;

import exceptions.ShowingFullException;
import exceptions.UnderAgeException;
import model.Movie;
import model.MovieGoer;
import model.Ticket;
import model.TicketKiosk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class MovieGoerTest {

    private Movie m1, m2;
    private MovieGoer mg1, mg2;
    private Ticket t1, t2;
    private TicketKiosk tk;

    @Before
    public void setUp() {
        tk = new TicketKiosk("Scotiabank Theatre");
        mg1 = new MovieGoer("Tom Hanks", 28, tk);
        mg2 = new MovieGoer("Sarah Johnson", 17, tk);
        m1 = new Movie("Arrival", 19, 50);
        m2 = new Movie("Ratatouille", 0, 100);
        t1 = new Ticket(m1);
        t2 = new Ticket(m2);
    }

    @Test
    public void testGetters() {
        assertEquals(mg1.getName(),"Tom Hanks");
        assertEquals(mg2.getName(),"Sarah Johnson");
        assertEquals(mg1.getAge(),28);
        assertEquals(mg2.getAge(),17);
        assertEquals(mg1.getTicketKiosk(), tk);
        assertEquals(mg2.getTicketKiosk(), tk);
    }

    @Test
    public void testBuyTicketNoUnderAgeException() {
        assertEquals(mg1.getTicket(), null); // !!!
        try {
            mg1.buyTicket(m1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Exception should not have been thrown.");
        }
        assertEquals(t1, mg1.getTicket());
    }

    @Test
    public void testBuyTicketUnderAgeException() {
        assertEquals(mg2.getTicket(), null);
        try {
            mg2.buyTicket(m1);
        } catch (UnderAgeException e) {
            System.out.println(e.getMessage()); // this is expected
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Exception should not have been thrown.");
        }
        assertEquals(mg2.getTicket(), null);
    }


    @Test
    public void testBuyTicketNoShowingFullException() {
        assertEquals(mg1.getTicket(), null); // !!!
        try {
            mg1.buyTicket(m1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Exception should not have been thrown.");
        }
        assertEquals(mg1.getTicket(), t1); // !!!

    }

    @Test
    public void testBuyTicketShowingFullException() {
        // Fill up the movie with viewer until all sits are taken
        while (!m1.isFull()) m1.addViewer();
        // Go try buy one more ticket (if you can...)
        try {
            mg1.buyTicket(m1);
        } catch (ShowingFullException e) {
            System.out.println(e.getMessage()); // this is expected
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Exception should not have been thrown.");
        }
        // You shouldn't be able to have bought a ticket
        assertEquals(mg1.getTicket(), null);
    }


}