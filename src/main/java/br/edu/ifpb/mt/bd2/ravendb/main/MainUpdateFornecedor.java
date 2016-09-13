package br.edu.ifpb.mt.bd2.ravendb.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpb.mt.bd2.ravendb.dao.FornecedorDao;
import br.edu.ifpb.mt.bd2.ravendb.entities.Endereco;
import br.edu.ifpb.mt.bd2.ravendb.entities.Fornecedor;
import br.edu.ifpb.mt.bd2.ravendb.entities.Produto;

public class MainUpdateFornecedor {

	public static void main(String[] args) {

		FornecedorDao dao = new FornecedorDao();

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId("fornecedors/129");
		fornecedor.setNomeFantasia("Empresa Hyperactive");
		fornecedor.setCnpj("1234567890124567");
		fornecedor.setEmail("empresa@empresa.com");

		Produto produto1 = new Produto();
		produto1.setNome("Produto 01 Alterado");
		produto1.setDescricao("Descrição do produto 01 alterado");
		produto1.setPreco(50d);
		produto1.setSku("PRD22134");

		Produto produto2 = new Produto();
		produto2.setNome("Produto 01");
		produto2.setDescricao("Descrição do produto 02");
		produto2.setPreco(60d);
		produto2.setSku("PRD21456");

		List<Produto> produtos = new ArrayList<>();
		produtos.add(produto1);
		produtos.add(produto2);

		Endereco endereco = new Endereco();
		endereco.setUf("Paraíba");
		endereco.setCidade("Monteiro");
		endereco.setBairro("Centro");
		endereco.setNumero(30);
		endereco.setRua("Rua da Igreja");


		fornecedor.setProdutosFornecidos(produtos);
		fornecedor.setEndereco(endereco);

		try {
			dao.update(fornecedor);
			JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao atualizar fornecedor!");
		}

	}
}
