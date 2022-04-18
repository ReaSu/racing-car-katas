package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {
	private Input input;

	public HtmlTextConverter(String fullFilenameWithPath) {
		this.input = new Input(fullFilenameWithPath);
	}

	public HtmlTextConverter(Input input) {
		this.input = input;
	}

	/* should this exception be caught and handled in this class?
	 * or at least replaced by a more specific exception? 
	 */
	public String convertToHtml() throws IOException {
		String[] lines = getLines();
		String html = "";
		for (String line : lines) {
			html += convert(line);
		}
		return html;
	}

	private String[] getLines() throws IOException {
		if (input.contents == "") {
			input.contents = readFile(input.fullFilenameWithPath);
		}
		String[] lines = input.contents.split("\n");
		return lines;
	}

	private String convert(String line) {
		String html = StringEscapeUtils.escapeHtml(line);
		html += "<br />";
		return html;
	}

	private String readFile(String fullFilenameWithPath) throws IOException {
		String contents = "";
		BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
		contents = read(contents, reader);
		reader.close();
		return contents;
	}

	private String read(String contents, BufferedReader reader) throws IOException {
		String line = reader.readLine();
		while (line != null) {
			contents += line;
			contents += '\n';
			line = reader.readLine();
		}
		return contents;
	}

	public String getFilename() {
		return this.input.fullFilenameWithPath;
	}
}
