package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {
	private Original original;

	public HtmlTextConverter(String fullFilenameWithPath) {
		this.original = new Original(fullFilenameWithPath);
	}

	public HtmlTextConverter(Original original) {
		this.original = original;
	}

	public String convertToHtml() throws IOException {
		/*
		 * should this decision be made where the file is actually read? The text
		 * converter could then be agnostic towards the kind of input it gets.
		 */
		String contents = original.contents == "" ? readFile(original.fullFilenameWithPath) : original.contents;
		// do I pass the whole object, and return the whole object?
		// do I pass just the file name and return just the contents?
		// should the method be void, with no parameters and use the object's original?
		// or something else entirely?
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

	private String readFile(String fullFilenameWithPath) throws IOException {
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
		return this.original.fullFilenameWithPath;
	}
}
