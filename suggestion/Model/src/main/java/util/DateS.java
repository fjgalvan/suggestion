package util;

public class DateS {
	private Integer dd;
	private Integer mm;
	private Integer aaaa;
	
	public DateS(Integer dd,Integer mm,Integer aaaa){
		this.dd= dd;
		this.mm= mm;
		this.aaaa= aaaa;
	}

	public Integer getDd() {
		return dd;
	}
	public void setDd(Integer dd) {
		this.dd = dd;
	}
	public Integer getMm() {
		return mm;
	}
	public void setMm(Integer mm) {
		this.mm = mm;
	}
	public Integer getAaaa() {
		return aaaa;
	}
	public void setAaaa(Integer aaaa) {
		this.aaaa = aaaa;
	}
	
	public String getDate(){
		String d= this.dd+"/"+this.mm+"/"+this.aaaa;
		return d;
	}
	
	
}
