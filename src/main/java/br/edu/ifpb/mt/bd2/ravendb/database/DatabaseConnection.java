package br.edu.ifpb.mt.bd2.ravendb.database;

import net.ravendb.client.IDocumentStore;
import net.ravendb.client.document.DocumentStore;

public class DatabaseConnection {
	
	private static IDocumentStore store;

	public static IDocumentStore openConnection() {
		store = new DocumentStore("http://desktop-dcll8kb:8080/");
		return store.initialize();
	}
	
	public static void closeConnection() {
		store.close();
	}
}