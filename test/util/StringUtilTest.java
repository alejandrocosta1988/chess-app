package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testAddNewLine() {
		
		String message = 
				"Some text in first line." + 
	            StringUtil.addNewLine() + 
				"Some text in second line.";
		
		assertEquals("Some text in first line.\nSome text in second line.", message);
		
	}

}
