package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    private TurnNumberSequence sequence;

	public TicketDispenser(TurnNumberSequence sequence) {
		this.sequence = sequence;
	}

	public TurnTicket getTurnTicket()
    {
    	int newTurnNumber = sequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
