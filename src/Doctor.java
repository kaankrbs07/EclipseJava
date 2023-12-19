
public abstract class Doctor {
	protected String doktorAdi;

	public void doktoruTanımla(String doktorAdi) {
		this.doktorAdi = doktorAdi;
	}

	public abstract void ozellikler();

	public void tedavi() {
		System.out.println("Doktorlar genellikle hastanede tedavi eder.");
	}

}
