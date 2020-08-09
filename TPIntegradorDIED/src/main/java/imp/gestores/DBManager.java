package imp.gestores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
	private static final String URL = "jdbc:mysql://db4free.net:3306/tpdied2020";
	private static final String USER = "died2020";
	private static final String PASS = "tpdied2020";
	
	private static Connection conn;
	
	private static DBManager DBM;
	
	private DBManager() {
		DBManager.conn = DBManager.getConn();
		
	}
	
	public static DBManager getInstance() { // Patron Singleton -- Devuelve la instancia, si no existe la crea
		if ( DBM == null) {
			DBM = new DBManager();
		}
		
		try {
			
			if (conn.isClosed()) {
				
				conn = getConn();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DBM;
	}
	

//	public static Connection getConn() {
//		return conn;
//	}

	public static Connection getConn(){
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(URL, USER, PASS);
	    }catch(Exception ex){
	        System.out.println(ex.getMessage());
	        System.out.println("couldn't connect!");
	        throw new RuntimeException(ex);
	    }
	}
//	private static Connection crearConexion() throws ClassNotFoundException, SQLException{
//
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		Connection conexion = DriverManager.getConnection(URL, USER, PASS);
//		if (conexion != null){
//			System.out.print("Conexion establecida...");
//			return conexion;
//
//		}
//		return null;
//
//	}

}
