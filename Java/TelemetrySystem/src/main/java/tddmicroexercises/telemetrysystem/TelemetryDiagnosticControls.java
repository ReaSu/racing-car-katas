package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls {
	private static final String CONNECTION_STRING = "*111#";
	private static final String DIAGNOSTIC_MESSAGE = "AT#UD";

	private final TelemetryClient telemetryClient;
	private String diagnosticInfo = "";

	public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
		this.telemetryClient = telemetryClient;
	}

	public TelemetryDiagnosticControls() {
		this.telemetryClient = new TelemetryClient();
	}

	public void checkTransmission() throws Exception {
		prepareTransmission();
		telemetryClient.send(DIAGNOSTIC_MESSAGE);
		diagnosticInfo = telemetryClient.receive();
	}

	private void prepareTransmission() throws Exception {
		resetDiagnosticInfo();
		resetConnection();
		connect();
	}

	private void connect() throws Exception {
		int retryLeft = 3;
		while (notConnected() && retryLeft > 0) {
			telemetryClient.connect(CONNECTION_STRING);
			retryLeft -= 1;
		}
		if (notConnected()) {
			// this Exception could be a bit more specific.
			throw new Exception("Unable to connect.");
		}
	}

	private void resetConnection() {
		telemetryClient.disconnect();
	}

	private void resetDiagnosticInfo() {
		diagnosticInfo = "";
	}

	private boolean notConnected() {
		return telemetryClient.getOnlineStatus() == false;
	}

	public String getDiagnosticInfo() {
		return diagnosticInfo;
	}

	public void setDiagnosticInfo(String diagnosticInfo) {
		this.diagnosticInfo = diagnosticInfo;
	}
}
