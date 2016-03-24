package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.StockServer;

public class Client {

	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("\nUsage: java -Djava.security.policy=security.policy Client AAPL");
			System.exit(0);
		}
		
		try {
			StockServer stockServer =
					(StockServer) Naming.lookup("rmi://localhost:1099/QuoteService");
			
			String price = stockServer.getQuote(args[0]);
			
			if (price != null) {
				System.out.println("The price of " + args[0] + " is: $" + price);
			} else {
				String nasdaqSymbols = stockServer.getNasdaqSymbols().toString();
				System.out.println("Invalid Nasdaq symbol! Please use one of these: " + nasdaqSymbols);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
