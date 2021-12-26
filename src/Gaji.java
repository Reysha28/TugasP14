import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Gaji implements PTABC{
	public int noPegawai;
    public String namaPegawai;
    public Integer jabatan;
    public Integer gajiPokok;
    public Integer jumlahHariMasuk;
    public Integer potongan;
    public Integer totalGaji;
	public String kodeJenis;
	public String tanggal;
	public String waktu;
	public String stringNama;
	public String stringJenis;
    public String stringGaji;
	public String stringPotongan;
	public String stringTotal;
	public Object kursIndo;
	public Boolean stringHadir;

	Scanner keyboard= new Scanner(System.in);
	Scanner you=new Scanner(System.in);

	public void NoPegawai(){
		System.out.print("Masukkan nomor pegawai : ");
		noPegawai=keyboard.nextInt();
	}

	public void NamaPegawai(){
		System.out.print("\n" + "Masukkan nama pegawai  : ");
		namaPegawai=you.nextLine();
		System.out.print("Nama pegawai sudah di cek" + "\n");
	}

	public String rincianJabatan(){
        return "\n" + "Rincian Jabatan" + "\n"+
        "1. Direktur" + "\n"+
        "2. Manager" + "\n" +
        "3. Kabag" + "\n" +
        "4. Kasub" + "\n" +
        "5. Karyawan" ;
    }
	
	public void Jabatan(){
		System.out.print("\n" +"Masukkan Jabatan       : ");
		jabatan=keyboard.nextInt();
	}

	public String jenis(){
        if(jabatan==1){
			kodeJenis="Direktur";
		}
		else if(jabatan==2){
			kodeJenis="Manager";
		}
		else if(jabatan==3){
			kodeJenis="Kabag";
		}
		else if(jabatan==4){
			kodeJenis="Kasub";
		}
		else if(jabatan==5){
			kodeJenis="Karyawan";
		}
		return kodeJenis;
	}

	public void GajiPokok(){
        if(jabatan==1){
			gajiPokok=10000000;
		}
		else if(jabatan==2){
			gajiPokok=8000000;
		}
		else if(jabatan==3){
			gajiPokok=5000000;
		}
		else if(jabatan==4){
			gajiPokok=3000000;
		}
		else if(jabatan==5){
			gajiPokok=2500000;
		}
	}

	public void JumlahHariMasuk(){
		System.out.print("\n" + "Jumlah hari bekerja (1 bulan = 30 hari) : ");
		jumlahHariMasuk=keyboard.nextInt();
	}

	public void Potongan(){
		potongan=(30-jumlahHariMasuk)*10000;		
	}

	public void TotalGaji(){
		totalGaji=gajiPokok-potongan;
	}

	public String Tanggal(){
		LocalDate date = LocalDate.now();
		DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		this.tanggal = date.format(frmt);
		return this.tanggal;
	}

	public String Waktu(){
		LocalTime date = LocalTime.now();
	    DateTimeFormatter frmt1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.waktu = date.format(frmt1);
		return this.waktu;
	}

	public String FormatNama(){
		return this.stringNama = namaPegawai.toUpperCase(); 
	}

	public String FormatJenis(){
		return this.kodeJenis = jenis().toLowerCase(); 
	}

	public String FormatGaji(){
		DecimalFormat kursIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();   
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndo.setDecimalFormatSymbols(formatRp);
		return this.stringGaji = kursIndo.format(gajiPokok);
	}

	public String FormatPotongan(){
		DecimalFormat kursIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();   
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndo.setDecimalFormatSymbols(formatRp);
		return this.stringPotongan = kursIndo.format(potongan);
	}

	public String FormatTotalGaji(){
		DecimalFormat kursIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();   
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndo.setDecimalFormatSymbols(formatRp);
		return this.stringTotal = kursIndo.format(totalGaji);
	}

	public Boolean Kehadiran(){
		return this.stringHadir= gajiPokok.equals(totalGaji);
	}

    public String tampil(){
        return "\n\n" +
        "-------------------------------------------" + "\n" +
        "           Bukti Pemberian Gaji            " + "\n" +
        "-------------------------------------------" + "\n" +
		"Tanggal           : " + Tanggal() + "\n" +
		"Waktu             : " + Waktu() + "\n" +
        "Nomor Pegawai     : " + this.noPegawai + "\n" +
        "Nama Pegawai      : " + FormatNama() + "\n" +
        "Jabatan           : " + FormatJenis() + "\n" +
        "Gaji Pokok        : " + FormatGaji() + "\n" +
        "Jumlah Hari Masuk : " + this.jumlahHariMasuk + " hari"+ "\n" +
        "Potongan          : " + FormatPotongan() + "\n" +
        "Total Gaji        : " + FormatTotalGaji() + "\n"+
        "-------------------------------------------" + "\n\n" +

		"Data Penilaian" + "\n" +
		"Kehadiran 100%    : " + Kehadiran() + "\n";
    }

	public void status(){
		System.out.println("Selamat Gaji Anda Berhasil Diterima" + "\n");
	}

}
