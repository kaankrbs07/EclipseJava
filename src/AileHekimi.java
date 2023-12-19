
public class AileHekimi extends Doctor implements Doktor {

	@Override
	public void ozellikler() {
		System.out.println("Aile hekimi  " + doktorAdi + " genel sağlık konuların da uzmandır");

	}

	@Override
	public void doktoruTanımla(String doktorAdi) {
		super.doktoruTanımla(doktorAdi);
		System.out.println("Aile hekimleri genelde ilaç yazar.");
	}

	@Override
	public void tedavi() {
		System.out.println("aile hekimi sağlık ocağında tedavi eder.");
	}

}
