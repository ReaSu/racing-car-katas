package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {
	private String fullFilenameWithPath;
	private String contents = "";

	public HtmlTextConverter(String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
	}

	public HtmlTextConverter(String contents, String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
		this.contents = contents;
	}

	public String convertToHtml() throws IOException {
		if (contents == "") {
			contents = readFile();
		}
		String[] lines = contents.split("\n");
		String html = "";
		for (String line : lines) {
			html += convert(line);
		}
		return html;
	}

	private String convert(String line) {
		String html = StringEscapeUtils.escapeHtml(line);
		html += "<br />";
		return html;
	}

	private String readFile() throws IOException {
		String contents = "";
		BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
		String line = reader.readLine();
		while (line != null) {
			contents += line;
			contents += '\n';
			line = reader.readLine();
		}
		reader.close();
		return contents;
	}

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}
