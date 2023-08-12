package br.com.cursopcv.testes;

import java.util.List;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.respositorio.RepositorioProduto;

public class ListaTodosProdutos {

	public static void main(String[] args) {

		RepositorioProduto repProduto = new RepositorioProduto();
		
		InclusaoDeProduto.main(args);
		
		Long idProdutoParaConsultar = 3L;
        Produto produtoConsultado = repProduto.obterPorCod(idProdutoParaConsultar);
        
        if (produtoConsultado != null) {
            System.out.printf("Produto encontrado por ID %d: ", produtoConsultado.getCod());
            System.out.println(produtoConsultado.getNome());
        } else {
            System.out.println("Produto não encontrado por ID.");
        }
		
		List<Produto> produtos = repProduto.listarTodos();
		
		System.out.println("Lista de todos os produtos:");
        for (Produto produto : produtos) {
            System.out.println("[" + produto.getCod() + "] " + produto.getNome());
        }

        repProduto.fecharEntityManagerFactory();
	}
}
