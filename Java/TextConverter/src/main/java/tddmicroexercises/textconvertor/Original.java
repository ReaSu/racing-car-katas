package tddmicroexercises.textconvertor;

public class Original {
	public String contents;
	public String fullFilenameWithPath;

	public Original(String contents, String fullFilenameWithPath) {
		this.contents = contents;
		this.fullFilenameWithPath = fullFilenameWithPath;
	}

	public Original(String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
	}
}