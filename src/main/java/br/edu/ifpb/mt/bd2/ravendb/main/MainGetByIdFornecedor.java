package br.edu.ifpb.mt.bd2.ravendb.main;

import javax.swing.JOptionPane;

import br.edu.ifpb.mt.bd2.ravendb.dao.FornecedorDao;
import br.edu.ifpb.mt.bd2.ravendb.entities.Fornecedor;
import br.edu.ifpb.mt.bd2.ravendb.entities.Produto;

public class MainGetByIdFornecedor {

	public static void main(String[] args) {
		FornecedorDao dao = new FornecedorDao();
		try {
			String id = JOptionPane.showInputDialog("Digite a id do Fornecedor");
			
			Fornecedor f = dao.getById(id);
			
			System.out.println("---------- Informações Básicas ----------");
			System.out.println("Id: " + f.getId());
			System.out.println("Nome fantasia: " +f.getNomeFantasia());
			System.out.println("CNPJ: " +f.getCnpj());
			System.out.println("Email: " +f.getEmail());
			System.out.println("------------ Endereço ------------");
			System.out.println("Rua: " +f.getEndereco().getRua());
			System.out.println("Número: " +f.getEndereco().getNumero());
			System.out.println("Bairro: " +f.getEndereco().getBairro());
			System.out.println("Cidade: " +f.getEndereco().getCidade());
			System.out.println("UF: " +f.getEndereco().getUf());
			System.out.println("---------- Produtos Fornecidos ------------");
			for (Produto produto : f.getProdutosFornecidos()) {
				System.out.println("SKU: " +produto.getSku());
				System.out.println("Nome: " +produto.getNome());
				System.out.println("Descrição: " +produto.getDescricao());
				System.out.println("Preço: " +produto.getPreco());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao buscar fornecedor");
		}
	}
}
