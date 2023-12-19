import javax.swing.SwingUtilities;

public class main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TCHastalikRandevuDoktorSecimi window = new TCHastalikRandevuDoktorSecimi();
				window.setVisible(true);
			}
		});
		AileHekimi doctor1 = new AileHekimi();
		doctor1.doktoruTanımla("Kaan");
		doctor1.tedavi();
		doctor1.ozellikler();

		Kardiyolog doctor2 = new Kardiyolog();
		doctor2.doktoruTanımla("enes");
		doctor2.tedavi();
		doctor2.ozellikler();

		Grip grip = new Grip();
		grip.hastaligiTanımla("grip");
		grip.tedaviYontemi();
 
		DisAgrisi disAgrisi = new DisAgrisi();
		disAgrisi.hastaligiTanımla("Diş ağrısı"); 
		disAgrisi.tedaviYontemi();
	}

}
