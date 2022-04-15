package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AlarmTest {

    @Test
    public void alarmshouldBeOffPerDefault() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }
    
    @ParameterizedTest
    @ValueSource(doubles = {
    		-1.,
    		Alarm.LOWER_BOUND/2,
    		Alarm.LOWER_BOUND-0.001,
    		Alarm.UPPER_BOUND+0.001,
    		Alarm.UPPER_BOUND*2
    		})
    public void alarmShouldBeOnWithPressureTooLow(double pressureValue) {
    	Sensor sensor = mock(Sensor.class);
		Alarm alarm = new Alarm(sensor);
    	when(sensor.popNextPressurePsiValue()).thenReturn(pressureValue);
    	alarm.check();
    	assertTrue(alarm.isAlarmOn());
    }
    
    @ParameterizedTest
    @ValueSource(doubles = {
    		Alarm.LOWER_BOUND,
    		Alarm.LOWER_BOUND+0.0001,
    		Alarm.LOWER_BOUND+(Alarm.UPPER_BOUND-Alarm.LOWER_BOUND)/2,
    		Alarm.UPPER_BOUND-0.001,
    		Alarm.UPPER_BOUND
    		})
    public void alarmShouldBeOffWithValidPressure(double pressureValue) {
    	Sensor sensor = mock(Sensor.class);
		Alarm alarm = new Alarm(sensor);
    	when(sensor.popNextPressurePsiValue()).thenReturn(pressureValue);
    	alarm.check();
    	assertFalse(alarm.isAlarmOn());
    
    }
}
