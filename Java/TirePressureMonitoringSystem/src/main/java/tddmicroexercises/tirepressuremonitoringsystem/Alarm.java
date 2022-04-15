package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
	static final double LOWER_BOUND = 17.;
	static final double UPPER_BOUND = 21.;
    private final double LowPressureThreshold = LOWER_BOUND;
    private final double HighPressureThreshold = UPPER_BOUND;

    protected Sensor sensor = new Sensor();

    protected boolean alarmOn = false;

    public Alarm(Sensor sensor) {
    	this.sensor = sensor;
	}

	public Alarm() {}

	public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
