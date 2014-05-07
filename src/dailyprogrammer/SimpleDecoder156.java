package dailyprogrammer;

public class SimpleDecoder156 {

	public SimpleDecoder156() {
		char[] encodet ="Etvmp$Jsspw%%%%[e}$xs$ks%$]sy$lezi$wspzih$xli$lmhhir$qiwweki2$Rs{$mx$mw$}syv$xyvr$xs$nsmr-mr$sr$xlmw$tvero2$Hs$rsx$tswx$er}xlmrk$xlex${mpp$kmzi$e{e}$xlmw$qiwweki2$Pixtistpi$higshi$xli$qiwweki$sr$xlimv$s{r$erh$vieh$xlmw$qiwweki2$]sy$ger$tpe}$epsrk".toCharArray();
		char[] decodet = new char[encodet.length];
		for (int i = 0; i < decodet.length; i++) {
			decodet[i] = (char) (encodet[i] -4) ;
		}
		System.out.println(decodet);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SimpleDecoder156();

	}

}
