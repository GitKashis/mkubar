package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Mikhail Kubar
* @version 1.0
* @since 25.08.2017
*/
public class CalculateTest {
/**
 * Test echo.
 * Метод echo из класса Calculate
 */  
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Mikhail Kubar";
		String expect = "Echo, echo, echo : Mikhail Kubar"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}