package tddmicroexercises.textconvertor;

public class Input {
	public String fullFilenameWithPath;
	public String contents;

	public Input(String contents, String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
		this.contents = contents;
	}

	public Input(String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
		this.contents = "";
	}
}