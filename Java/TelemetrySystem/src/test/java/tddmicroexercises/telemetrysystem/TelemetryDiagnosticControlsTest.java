package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TelemetryDiagnosticControlsTest
{
    
	TelemetryClient telemetryClient;
	TelemetryDiagnosticControls tdc;
	
	@BeforeEach
    public void setUp() {
    	telemetryClient = mock(TelemetryClient.class);
		tdc = new TelemetryDiagnosticControls(telemetryClient);

    }

	@Test
	public void checkTransmissionShouldNotConnectAndThrowException() {
		when(telemetryClient.getOnlineStatus()).thenReturn(false);
		
		assertThrows(Exception.class, () -> {
			tdc.checkTransmission();
		});
	}
	
	@Test 
	public void checkTransmissionShouldConnectAndNotThrowException() {
		when(telemetryClient.getOnlineStatus()).thenReturn(true);
		
		assertDoesNotThrow( () -> {
			tdc.checkTransmission();
		});
	}
    
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {
		String diagnosticInfo = 
				"LAST TX rate................ 100 MBPS\r\n"
                + "HIGHEST TX rate............. 100 MBPS\r\n"
                + "LAST RX rate................ 100 MBPS\r\n"
                + "HIGHEST RX rate............. 100 MBPS\r\n"
                + "BIT RATE.................... 100000000\r\n"
                + "WORD LEN.................... 16\r\n"
                + "WORD/FRAME.................. 511\r\n"
                + "BITS/FRAME.................. 8192\r\n"
                + "MODULATION TYPE............. PCM/FM\r\n"
                + "TX Digital Los.............. 0.75\r\n"
                + "RX Digital Los.............. 0.10\r\n"
                + "BEP Test.................... -5\r\n"
                + "Local Rtrn Count............ 00\r\n"
                + "Remote Rtrn Count........... 00";
		
		when(telemetryClient.getOnlineStatus()).thenReturn(true);
		when(telemetryClient.receive()).thenReturn(diagnosticInfo);
		
		assertDoesNotThrow(() -> {
			tdc.checkTransmission();
		});
		
		assertEquals(tdc.getDiagnosticInfo(), diagnosticInfo);
    }
}
