
import javax.swing.*;
import java.awt.event.*;

public class TCHastalikRandevuDoktorSecimi extends JFrame {
	private JTextField tcTextField;
	private JButton tcKontrolButton;
	private JComboBox<String> diseaseComboBox;
	private JButton selectButton;
	private JButton randevuButton;
	private JFrame randevuFrame;
	private JComboBox<String> dayComboBox;
	private JButton confirmButton;

	private String[] diseases = { "Grip", "Baş ağrısı", "Diş ağrısı", "Tüberküloz", "Kalp rahatsızlığı",
			"Anksiyete bozukluğu", "Diyabet", "Kırık bacak", "Epilepsi", "Römatizma" };
	private String[] doctors = { "Aile hekimi", "Acil", "Diş hekimi", "Göğüs hastalıkları", "Kardiyoloji", "Psikiyatri",
			"Endokrinoloji", "Ortopedi", "Nöroloji", "Dermatoloji" };

	public TCHastalikRandevuDoktorSecimi() {
		setTitle("TC ve Hastalık Randevu ve Doktor Seçimi");
		setSize(400, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		initializeComponents();
		setComponentPositions();
		addActionListeners();
	}

	private void initializeComponents() {
		tcTextField = new JTextField();
		tcKontrolButton = new JButton("TC Kontrol Et");
		add(tcTextField);
		add(tcKontrolButton);

		diseaseComboBox = new JComboBox<>(diseases);
		selectButton = new JButton("Hastalık Seç");
		selectButton.setEnabled(false);
		add(diseaseComboBox);
		add(selectButton);

		randevuButton = new JButton("Randevu İster misiniz?");
		add(randevuButton);

		randevuFrame = new JFrame("Randevu ve Poliklinik Seçimi");
		randevuFrame.setSize(300, 250);
		randevuFrame.setLayout(null);

		dayComboBox = new JComboBox<>(
				new String[] { "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar" });
		confirmButton = new JButton("Randevu Onayla");
		confirmButton.setEnabled(false);
		dayComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButton.setEnabled(true); // Enable the confirmation button when a day is selected
			}
		});
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedDay = (String) dayComboBox.getSelectedItem();
				String selectedDisease = (String) diseaseComboBox.getSelectedItem();
				int selectedIndex = diseaseComboBox.getSelectedIndex();

				if (selectedDay.equals("Cumartesi") || selectedDay.equals("Pazar")) {
					JOptionPane.showMessageDialog(null, "Cumartesi ve Pazar günleri randevu alınamaz.");
				} else if (selectedIndex >= 0 && selectedIndex < diseases.length) {
					String selectedDoctor = doctors[selectedIndex];
					JOptionPane.showMessageDialog(null, "Randevu günü seçildi: " + selectedDay + "\nHastalık: "
							+ selectedDisease + "\nPoliklinik: " + selectedDoctor);
					// Perform any necessary actions with the selected day, disease, and doctor here
					randevuFrame.setVisible(false); // Hide the frame after confirming the selection
				} else {
					JOptionPane.showMessageDialog(null, "Geçersiz seçim.");
				}
			}
		});

		dayComboBox.setBounds(50, 180, 200, 25);
		confirmButton.setBounds(260, 180, 120, 25);
		randevuFrame.add(dayComboBox);
		randevuFrame.add(confirmButton);
	}

	private void setComponentPositions() {
		tcTextField.setBounds(50, 30, 180, 25);
		tcKontrolButton.setBounds(240, 30, 120, 25);

		diseaseComboBox.setBounds(50, 80, 200, 25);
		selectButton.setBounds(260, 80, 100, 25);

		randevuButton.setBounds(100, 130, 200, 30);
	}

	private void addActionListeners() {
		tcKontrolButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc = tcTextField.getText();
				if (isValidTC(tc)) {
					JOptionPane.showMessageDialog(null, "TC Kimlik Numarası Doğrulandı. Hastalık seçebilirsiniz.");
					selectButton.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Geçersiz TC Kimlik Numarası. Lütfen geçerli bir TC girin.");
					selectButton.setEnabled(false);
				}
			}
		});

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = diseaseComboBox.getSelectedIndex();
				if (selectedIndex >= 0 && selectedIndex < diseases.length) {
					String selectedDisease = diseases[selectedIndex];
					String selectedDoctor = doctors[selectedIndex];
					JOptionPane.showMessageDialog(null,
							"Hastalık seçildi: " + selectedDisease + ". Poliklinik: " + selectedDoctor);
					randevuButton.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Geçersiz seçim.");
					randevuButton.setEnabled(false);
				}
			}
		});

		randevuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randevuFrame.setVisible(true);
			}
		});

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedDay = (String) dayComboBox.getSelectedItem();
				JOptionPane.showMessageDialog(null, "Randevu günü seçildi: " + selectedDay);
				randevuFrame.setVisible(false);
			}
		});

		dayComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButton.setEnabled(true);
			}
		});
	}

	private boolean isValidTC(String tc) {
		return tc.matches("^\\d{11}$");
	}
}
