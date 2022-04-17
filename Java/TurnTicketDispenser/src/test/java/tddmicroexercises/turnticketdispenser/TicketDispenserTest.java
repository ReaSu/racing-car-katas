package tddmicroexercises.turnticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TicketDispenserTest {
	
	private TurnNumberSequence sequence;

	@BeforeEach
	void setUp() {
    	sequence = new TurnNumberSequence();
	}

    @Test
    void singleTestShouldStartAtZero() {
        TicketDispenser dispenser = new TicketDispenser(sequence);
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(0, ticket.getTurnNumber());
    }
    
    @Test
    void secondTestShouldAlsoStartAtZero() {
        TicketDispenser dispenser = new TicketDispenser(sequence);
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(0, ticket.getTurnNumber());
    }
    
    @Test
    void twoDispensersShouldReturnSequentialNumbers() {
    	TicketDispenser dispenser1 = new TicketDispenser(sequence);
    	TicketDispenser dispenser2 = new TicketDispenser(sequence);
        TurnTicket ticket1 = dispenser1.getTurnTicket();
        TurnTicket ticket2 = dispenser2.getTurnTicket();
        assertEquals(0, ticket1.getTurnNumber());
        assertEquals(1, ticket2.getTurnNumber());
    }

}
