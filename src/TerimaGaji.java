import java.util.InputMismatchException;

public class TerimaGaji extends Gaji{
    public boolean kondisi;

	public void jadwalGaji(){
        System.out.println("Gaji diterima pada tanggal 1 setiap bulannya" + "\n");
    }

    public void prosesMulai(){
        System.out.println("---------- PROGRAM PENERIMAAN GAJI ----------");
    }

	@Override
	public void NoPegawai(){
		boolean kondisi=true;
		do{	
		try{
		System.out.print("\n" + "Masukkan nomor pegawai : ");
		noPegawai=keyboard.nextInt();
		kondisi=false;
		}
		catch(InputMismatchException ex){
			System.out.println("Inputan anda salah! Nomor pegawai hanya bisa diisi angka" + "\n");
			keyboard.nextLine();
		}
		finally{
			System.out.print("Nomor pegawai sudah di cek" + "\n");
		}
		}while(kondisi);
	}

	@Override
	public void Jabatan(){
		boolean kondisi=true;
		do{	
		try{
			System.out.print("\n" +"Masukkan Jabatan       : ");
			jabatan=keyboard.nextInt();
			if (jabatan<=0|| jabatan>5) throw new Exception();
			kondisi=false;
			}
		catch(InputMismatchException e){
				System.out.print("Inputan anda salah! Jabatan hanya bisa diisi angka" + "\n");
				keyboard.nextLine();
		}
		catch(Exception e){
			System.out.print("Inputan anda salah! Jabatan harus hanya bisa diisi angka 1-5" + "\n");
			keyboard.nextLine();
		}
		finally{
			System.out.print("Jabatan sudah di cek" + "\n");
		}
		}while(kondisi);
	}

	@Override
	public void JumlahHariMasuk(){
		boolean kondisi=true;
		do{	
		try{
			System.out.print("\n" + "Jumlah hari bekerja (1 bulan = 30 hari) : ");
			jumlahHariMasuk=keyboard.nextInt();
			if (jumlahHariMasuk<=0 || jumlahHariMasuk>30) throw new Exception();
			kondisi=false;
		}
		catch(InputMismatchException e){
			System.out.print("Inputan anda salah! Jumlah hari masuk hanya bisa diisi angka" + "\n");
			keyboard.nextLine();
		}
		catch(Exception e){
			System.out.print("Inputan anda salah! Jabatan harus hanya bisa diisi angka 1-30" + "\n");
			keyboard.nextLine();
		}
		finally{
			System.out.print("Jumlah hari masuk sudah di cek" + "\n");
		}
		}while(kondisi);
	}
}
