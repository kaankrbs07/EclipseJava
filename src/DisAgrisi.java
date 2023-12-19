
public class DisAgrisi extends Disease implements Hastalik
{

	protected String hastalikAdi;

	@Override
	public void hastaligiTanımla(String hastalikAdi) {
this.hastalikAdi = hastalikAdi;
		
	}

	@Override
	public void tedaviYontemi() {
 System.out.println("Diş ağrısı kanal tedavisi veya dolguyla tedavi edilir. ");
		
	}

}
