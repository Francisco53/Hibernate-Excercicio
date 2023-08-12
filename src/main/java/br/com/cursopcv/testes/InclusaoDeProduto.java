package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.respositorio.RepositorioProduto;

public class InclusaoDeProduto {

    public static void main(String[] args){

        RepositorioProduto repProduto = new RepositorioProduto();

        Produto prop = new Produto();

        //Salvando produto

        prop.setNome("Panela");
        prop.setDescricao("Panela de Pressão 10 Litros");
        prop.setPreco(56.80);

        Produto prop2 = new Produto();
        prop2.setNome("Cama");
        prop2.setDescricao("Cama de casal Big");
        prop2.setPreco(450.68);

        Produto prop3 = new Produto();
        prop3.setNome("Caixa Som");
        prop3.setDescricao("Caixa de Som JBL");
        prop3.setPreco(160.00);

        repProduto.salvar(prop);
        repProduto.salvar(prop2);
        repProduto.salvar(prop3);

        //Removendo produto

        Produto produto = repProduto.obterPorCod(3L);

        if (produto != null) {
            System.out.println("Registro da Tabela Produto a ser Deletado");
            repProduto.remove(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }

        repProduto.fecharEntityManager();
    }
}
