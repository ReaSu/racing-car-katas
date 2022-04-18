package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class HtmlTextConverterTest {

    @Test
    public void readFromFileShouldReturnCorrectFilename() {
        String fullFilenameWithPath = "/home/reasu/dev/katas/Racing-Car-Katas/Java/TextConverter/src/main/java/resources/textfile.txt";
		HtmlTextConverter converter = new HtmlTextConverter(fullFilenameWithPath);
        assertEquals(fullFilenameWithPath, converter.getFilename());
    }
    
    @Test
    public void passContentsShouldReturnCorrectFileName() {
    	String contents = "some \"text\" contents\na < b && b > a\n";
    	String filename = "randomFileName.txt";
    	
    	HtmlTextConverter converter = new HtmlTextConverter(new Original(contents, filename));
    	assertEquals(filename, converter.getFilename());
    }
    
    @Test
    public void passContentsShouldConvertCorrectly() {
    	String contents = "some \"text\" contents\na < b && b > a\n";
    	String filename = "randomFileName.txt";
    	String expected = "some &quot;text&quot; contents<br />a &lt; b &amp;&amp; b &gt; a<br />";
    	HtmlTextConverter converter = new HtmlTextConverter(new Original(contents, filename));
    	String html = "";
    	try {
			html = converter.convertToHtml();
		} catch (IOException e) {
			e.getMessage();
		}
    	assertEquals(html, expected);
    }

}
