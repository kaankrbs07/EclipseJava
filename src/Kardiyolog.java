
public class Kardiyolog extends Doctor implements Doktor{

	@Override
	public void doktoruTanımla(String doktorAdi) {

		super.doktoruTanımla(doktorAdi);
		System.out.println("kardiyaloglar genelde ameliyat yapar.");
	}

	@Override
	public void ozellikler() {
System.out.println("kardiyalog " + doktorAdi + " kalp konusunda uzamandır.");
		
	}

	@Override
	public void tedavi() {

		super.tedavi();
		System.out.println("kardiyaloglar genelde ameliyathanede muayene eder.");
	}

}
