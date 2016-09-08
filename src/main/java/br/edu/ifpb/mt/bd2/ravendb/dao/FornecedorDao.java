package br.edu.ifpb.mt.bd2.ravendb.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.mt.bd2.ravendb.database.DatabaseConnection;
import br.edu.ifpb.mt.bd2.ravendb.entities.Fornecedor;
import br.edu.ifpb.mt.bd2.ravendb.exception.RavenDBException;
import net.ravendb.client.IDocumentSession;
import net.ravendb.client.IDocumentStore;

public class FornecedorDao {

	private IDocumentStore store;
	private IDocumentSession session;
	
	public FornecedorDao() {
		store = DatabaseConnection.openConnection();
		session = store.openSession("projeto-bd2");
	}

	public void save(Fornecedor fornecedor) throws RavenDBException {
		try {
			session.store(fornecedor);
			session.saveChanges();
		} catch (Exception e) {
			throw new RavenDBException(e.getMessage(), e.getCause());
		}
	}
	
	public void update(Fornecedor fornecedor) throws RavenDBException {
		try {
			Fornecedor fornecedor1 = session.load(Fornecedor.class, fornecedor.getId());
			delete(fornecedor1);
			save(fornecedor);
		} catch (Exception e) {
			throw new RavenDBException(e.getMessage(), e.getCause());
		} 
	}
	
	
	public void delete(Fornecedor fornecedor) throws RavenDBException {
		try {
			Fornecedor fornecedor1 = session.load(Fornecedor.class, fornecedor.getId());
			if (fornecedor1.equals(fornecedor)) {
				session.delete(fornecedor1);
				session.saveChanges();
			}
		} catch (Exception e) {
			throw new RavenDBException(e.getMessage(), e.getCause());
		} 
	}
	
	
	public List<Fornecedor> getAll() throws RavenDBException {
		List<Fornecedor> fornecedores = new ArrayList<>();
		try {
			fornecedores = session.query(Fornecedor.class).take(Integer.MAX_VALUE).toList();
		} catch (Exception e) {
			throw new RavenDBException(e.getMessage(), e.getCause());
		}
		return fornecedores;
	}
	
	
	public Fornecedor getById(String id) throws RavenDBException {
		Fornecedor fornecedor = null;
		try {
			fornecedor = session.load(Fornecedor.class, id);
		} catch (Exception e) {
			throw new RavenDBException(e.getMessage(), e.getCause());
		}
		return fornecedor;
	}
}
