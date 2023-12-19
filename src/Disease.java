
public abstract class Disease {
	protected String hastalikAdi;

	public void hastaligiTanımla(String hastalikAdi) {
		this.hastalikAdi = hastalikAdi;
	}

	public abstract void tedaviYontemi();
}
