package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class StartServer {

	public static void main(String[] args) {
		try {
			StockServerImpl stockServerImpl = new StockServerImpl();
			
			Naming.rebind("rmi://localhost:1099/QuoteService", stockServerImpl);
			
			System.out.println("<QuoteService> Server is ready!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
