package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.respositorio.RepositorioProduto;

public class RemocaoDeProduto {

	public static void main(String[] args) {
		
		RepositorioProduto repProduto = new RepositorioProduto();

		InclusaoDeProduto.main(args);

        repProduto.removerPorCod(1L);

        Produto produto = repProduto.obterPorCod(3L);
        
        if (produto != null) {
            System.out.println("Registro da Tabela Produto a ser Deletado");
            repProduto.removerPorObjeto(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
        
        repProduto.fecharEntityManagerFactory();
	}
}
