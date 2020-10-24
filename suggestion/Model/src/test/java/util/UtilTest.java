package util;

import org.junit.Test;

public class UtilTest {
	@Test
    public void utilTest(){
		DateS date= new DateS(20,9,2021);
		date.getAaaa();
		date.getDate();
		date.getDd();
		date.getMm();
		date.setAaaa(2020);
		date.setDd(26);
		date.setMm(10);
	}
}
