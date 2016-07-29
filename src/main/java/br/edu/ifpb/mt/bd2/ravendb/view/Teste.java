package br.edu.ifpb.mt.bd2.ravendb.view;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.mt.bd2.ravendb.dao.FornecedorDao;
import br.edu.ifpb.mt.bd2.ravendb.entities.Endereco;
import br.edu.ifpb.mt.bd2.ravendb.entities.Fornecedor;
import br.edu.ifpb.mt.bd2.ravendb.entities.Produto;
import br.edu.ifpb.mt.bd2.ravendb.exception.RavenDBException;

public class Teste {
	
	public static void main(String[] args) {
		
		FornecedorDao dao = new FornecedorDao();
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setNomeFantasia("Americanas");
		fornecedor.setCnpj("1111111111111");
		fornecedor.setEmail("americanas@americanas.com");
		
		
		Endereco endereco = new Endereco();
		endereco.setRua("Rua 1");
		endereco.setNumero(20);
		endereco.setBairro("Bairro 1");
		endereco.setCidade("Cidade 1");
		endereco.setUf("Sp");
		
		List<Produto> produtos = new ArrayList<>();
		
		Produto produto = new Produto();
		produto.setSku("111111111111");
		produto.setNome("Produto 1");
		produto.setDescricao("Descrição do Produto 1");
		produto.setPreco(2000d);
		
		produtos.add(produto);
		
		fornecedor.setEndereco(endereco);
		fornecedor.setProdutosFornecidos(produtos);
		
		try {
			System.out.println(fornecedor);
			dao.salvar(fornecedor);
			System.out.println(fornecedor);
		} catch (RavenDBException e) {
			e.printStackTrace();
		}
		
	}

}
