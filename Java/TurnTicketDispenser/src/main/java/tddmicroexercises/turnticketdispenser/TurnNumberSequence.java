package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence
{
    private int turnNumber = 0;

    public TurnNumberSequence() {
    	// default constructor
    }

    public TurnNumberSequence(int sequenceStart) {
		turnNumber = sequenceStart;
	}

	public int getNextTurnNumber()
    {
        return turnNumber++;
    }
}
