package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.respositorio.RepositorioProduto;

public class AlteracaoDeProduto {

	public static void main(String[] args) {

        RepositorioProduto repProduto = new RepositorioProduto();

        InclusaoDeProduto.main(args);

        Long idProdutoParaAlterar = 2L;
        Produto produtoAlterado = repProduto.obterPorCod(idProdutoParaAlterar);

        if (produtoAlterado != null) {
            System.out.println("Produto antes da alteração:");
            System.out.println("Nome: " + produtoAlterado.getNome());
            System.out.println("Preço: " + produtoAlterado.getPreco());

            // Alterando o preço do produto
            produtoAlterado.setPreco(345.00);
            repProduto.atualizar(produtoAlterado);

            System.out.println("Produto após a alteração:");
            System.out.println("Nome: " + produtoAlterado.getNome());
            System.out.println("Preço: " + produtoAlterado.getPreco());
        } else {
            System.out.println("Produto não encontrado por ID.");
        }

        repProduto.fecharEntityManagerFactory();
    }
}
