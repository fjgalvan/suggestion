package twitter;


public class TwitterValidatorDateS {
	DateUtil f;
	String ts;
	public TwitterValidatorDateS(String twitterString){
		this.f= new DateUtil();
		this.ts= twitterString;
	}
	
	public boolean VigenciaPromoValida(){
		boolean vigencia= false;
		ParsearTweetToSuggestion c= new ParsearTweetToSuggestion(this.ts);
		c.convertirFecha();
		c.getDate();
		
		if(c.getDate().getAaaa()<this.f.getAnnioActual()){
			vigencia= false;
		}
		
		if(c.getDate().getAaaa().equals(this.f.getAnnioActual())){
			if(c.getDate().getMm().equals(this.f.getMesActual())){
				if(c.getDate().getDd()>=this.f.getDiaActual()){
					vigencia= true;
				}if(c.getDate().getDd()<this.f.getDiaActual()){
					vigencia= false;
				}
			}
			if(c.getDate().getMm()>this.f.getMesActual()){
				vigencia= true;
			}
			if(c.getDate().getMm()<this.f.getMesActual()){
				vigencia= false;
			}
		}
		
		if(c.getDate().getAaaa()>this.f.getAnnioActual()){
			vigencia= true;
		}
		return vigencia;
	}
	
}
