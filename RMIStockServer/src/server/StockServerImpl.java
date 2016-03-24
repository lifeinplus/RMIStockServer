package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StockServerImpl extends UnicastRemoteObject implements StockServer {

	private static final long serialVersionUID = 1L;

	private ArrayList<String> nasdaqSymbols = new ArrayList<>();
	
	private String price = null;

	public StockServerImpl() throws RemoteException {
		super();
		
		LocateRegistry.createRegistry(1099);
		
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
	}

	@Override
	public String getQuote(String symbol) throws RemoteException {
		
		if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {
			
			price = (new Double(Math.random() * 100)).toString();
		}
		
		return price;
	}

	@Override
	public ArrayList<String> getNasdaqSymbols() throws RemoteException {
		return nasdaqSymbols;
	}

}
