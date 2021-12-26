import java.util.InputMismatchException;
import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;
import java.util.Scanner;

public class Program {
    static Connection conn;
	public static int noPegawai;
    public static String namaPegawai;
	public static int gajiPokok;
    public static int potongan;
    public static int totalGaji;
    public static int jumlahHariMasuk;
	public static String tanggal;
	public static String waktu;
	public static String kodeJenis;

	public static void main(String[] args) throws Exception {
        Scanner input = new Scanner (System.in);
        String pilihan;
        boolean lanjut = true;
                        
        String url = "jdbc:mysql://localhost:3306/gajidb";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
            System.out.println("Class Driver sudah ditemukan");  

            while (lanjut) {
                System.out.print("\n-------------------------------------");
                System.out.print("\n    PROGRAM DB DATA GAJI PEGAWAI     ");
                System.out.print("\n-------------------------------------\n");
                System.out.println("1. Lihat Data Gaji Pegawai           ");
                System.out.println("2. Tambah Data Gaji Pegawai          ");
                System.out.println("3. Ubah Data Gaji Pegawai            ");
                System.out.println("4. Hapus Data Gaji Pegawai           ");
                System.out.println("5. Cari Data Gaji Pegawai            ");
                System.out.print("\nInputkan pilihan anda (1/2/3/4/5):   ");
                pilihan = input.next();
                
                switch (pilihan) {
                case "1":
                    lihatData();
                    break;
                case "2":
                    tambahData();
                    break;
                case "3":
                    ubahData();
                    break;
                case "4":
                    hapusData();
                    break;
                case "5":
                    cariData();
                    break;
                default:
                    System.err.println("\nMaaf pilihan Anda tidak tersedia\nSilakan pilih kembali (1-5)");
                }
                System.out.print("\nApakah Anda ingin melanjutkan (y/n)? ");
                pilihan = input.next();
                lanjut = pilihan.equalsIgnoreCase("y");
            }
            System.out.println("\nProgram selesai");
        }
        catch(ClassNotFoundException ex) {
            System.err.println("Warning! driver error");
            System.exit(0);
        }
        catch(SQLException e){
            System.err.println("Warning! Tidak berhasil melakukan koneksi");
        }
    }

    private static void lihatData() throws SQLException {
        System.out.print("\n-------------------------------------");
        System.out.print("\n        RINCIAN DATA GAJI PEGAWAI      ");
        System.out.print("\n-------------------------------------");
        
        String sql ="SELECT * FROM gaji";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int no=1;
        
        while(result.next()){
            System.out.print("\n-------------------------------------");
            System.out.print("\n         DATA GAJI PEGAWAI " + no);
            System.out.print("\n-------------------------------------");
            System.out.print("\nTanggal            : ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nWaktu              : ");
            System.out.print(result.getString("waktu"));
			System.out.print("\nNo Pegawai         : ");
            System.out.print(result.getInt("noPegawai"));
            System.out.print("\nNama Pegawai       : ");
            System.out.print(result.getString("namaPegawai"));
            System.out.print("\nJabatan            : ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nNo Gaji Pokok      : Rp.");
            System.out.print(result.getInt("gajiPokok"));
			System.out.print("\nJumlah Hari Masuk  : ");
            System.out.print(result.getInt("jumlahHariMasuk"));
			System.out.print("\nPotongan           : Rp.");
            System.out.print(result.getInt("potongan"));
			System.out.print("\nTotal Gaji         : Rp.");
            System.out.print(result.getInt("totalGaji"));
            System.out.print("\n-------------------------------------");
            no++;
        }
    }

	private static void tambahData() throws SQLException{
        try {
        System.out.print("\n-------------------------------------");
        System.out.print("\n         TAMBAH DATA GAJI PEGAWAI      ");
        System.out.print("\n-------------------------------------\n");
        
        TerimaGaji pegawaiB=new TerimaGaji();  
		
        pegawaiB.Tanggal();
        pegawaiB.Waktu();
		pegawaiB.NoPegawai();
		pegawaiB.NamaPegawai();
        System.out.println(pegawaiB.rincianJabatan());
		pegawaiB.Jabatan();
        pegawaiB.jenis();
		pegawaiB.GajiPokok();
		pegawaiB.JumlahHariMasuk();
        pegawaiB.Potongan();
        pegawaiB.TotalGaji();

        String tanggal=pegawaiB.tanggal;
		String waktu=pegawaiB.waktu;
		int noPegawai=pegawaiB.noPegawai;
        String namaPegawai=pegawaiB.namaPegawai;
		String kodeJenis=pegawaiB.kodeJenis;
		int gajiPokok=pegawaiB.gajiPokok;
		int jumlahHariMasuk=pegawaiB.jumlahHariMasuk;
		int potongan=pegawaiB.potongan;
		int totalGaji=pegawaiB.totalGaji;

		String sql = "INSERT INTO gaji (tanggal, waktu, noPegawai, namaPegawai, jabatan, gajiPokok, jumlahHariMasuk, potongan, totalGaji) VALUES ('%s','%s','%d','%s','%s','%d','%d','%d','%d')";
        sql = String.format(sql,tanggal,waktu,noPegawai,namaPegawai,kodeJenis,gajiPokok,jumlahHariMasuk,potongan,totalGaji);

        Statement statement = conn.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil menambahkan data gaji pegawai");
        }
		catch (SQLException e) {
            System.err.println("Warning! Terjadi kesalahan input data gaji pegawai");
        }
		catch (InputMismatchException e) {
            System.err.println("Warning! Inputan hanya angka");
        }
    }

    private static void ubahData() throws SQLException{
        System.out.print("\n-------------------------------------");
        System.out.print("\n        UPDATE DATA GAJI PEGAWAI       ");
        System.out.print("\n-------------------------------------\n");
        
        try {
            lihatData();
            Scanner terimaInput = new Scanner (System.in);  
            System.out.print("Masukkan nomor pegawai yang akan di update: ");
		    Integer noPegawai=Integer.parseInt(terimaInput.nextLine());
            
            String sql= "SELECT * FROM gaji WHERE noPegawai = " +noPegawai;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                TerimaGaji pegawaiB=new TerimaGaji();  
                pegawaiB.Tanggal();
                pegawaiB.Waktu();
                pegawaiB.NamaPegawai();
                System.out.println(pegawaiB.rincianJabatan());
                pegawaiB.Jabatan();
                pegawaiB.jenis();
                pegawaiB.GajiPokok();
                pegawaiB.JumlahHariMasuk();
                pegawaiB.Potongan();
                pegawaiB.TotalGaji();

                String tanggal=pegawaiB.tanggal;
                String waktu=pegawaiB.waktu;
                String namaPegawai=pegawaiB.namaPegawai;
                String kodeJenis=pegawaiB.kodeJenis;
                int gajiPokok=pegawaiB.gajiPokok;
                int jumlahHariMasuk=pegawaiB.jumlahHariMasuk;
                int potongan=pegawaiB.potongan;
                int totalGaji=pegawaiB.totalGaji;

                sql = "UPDATE gaji SET tanggal='"+tanggal+"',waktu='"+waktu+"',namaPegawai='"+namaPegawai+"',jabatan='"+kodeJenis+"', gajiPokok='"+gajiPokok+"', jumlahHariMasuk='"+jumlahHariMasuk+"',potongan='"+potongan+"',totalGaji='"+totalGaji+"' WHERE noPegawai ='"+noPegawai+"'";
                
                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data gaji pegawai dengan nomor pegawai "+noPegawai+"");
                }
            }
            statement.close();        
        } catch (SQLException e) {
            System.err.println("Warning! Terjadi kesalahan dalam mengupdate data gaji pegawai");
            System.err.println(e.getMessage());
        }
    }


	private static void hapusData() {
        System.out.print("\n-------------------------------------");
        System.out.print("\n         HAPUS DATA GAJI PEGAWAI       ");
        System.out.print("\n-------------------------------------\n");
        
        Scanner terimaInput = new Scanner (System.in);
        
        try{
            lihatData();
            System.out.print("\n\nInputkan nomor pegawai : ");
            Integer noPegawai= Integer.parseInt(terimaInput.nextLine());
            
            String sql = "DELETE FROM gaji WHERE noPegawai = "+ noPegawai;
            Statement statement = conn.createStatement();
            
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil menghapus data gaji pegawai dengan nomor pegawai "+noPegawai+"");
            }
       	}
		catch(SQLException e){
            System.out.println("Warning! Terjadi kesalahan dalam menghapus data gaji pegawai");
        }
    }

    private static void cariData () throws SQLException {
        System.out.print("\n-------------------------------------");
        System.out.print("\n         CARI DATA GAJI PEGAWAI      ");
        System.out.print("\n-------------------------------------\n");
        
        Scanner terimaInput = new Scanner (System.in); 
        System.out.print("\nInputkan nama pegawai : ");
        String keyword = terimaInput.nextLine();
        
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM gaji WHERE namaPegawai LIKE '%"+keyword+"%'";
        ResultSet result = statement.executeQuery(sql);  
        
        while(result.next()){
            System.out.print("\n-------------------------------------");
            System.out.print("\n          DATA GAJI PEGAWAI          ");
            System.out.print("\n-------------------------------------");
            System.out.print("\nTanggal            : ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nWaktu              : ");
            System.out.print(result.getString("waktu"));
			System.out.print("\nNo Pegawai         : ");
            System.out.print(result.getInt("noPegawai"));
            System.out.print("\nNama Pegawai       : ");
            System.out.print(result.getString("namaPegawai"));
            System.out.print("\nJabatan            : ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nNo Gaji Pokok      : Rp.");
            System.out.print(result.getInt("gajiPokok"));
			System.out.print("\nJumlah Hari Masuk  : ");
            System.out.print(result.getInt("jumlahHariMasuk"));
			System.out.print("\nPotongan           : Rp.");
            System.out.print(result.getInt("potongan"));
			System.out.print("\nTotal Gaji         : Rp.");
            System.out.print(result.getInt("totalGaji"));
            System.out.print("\n-------------------------------------");
            System.out.print("\n");
        }
    }
}
