
import java.util.ArrayList;

public class Loja {

    private Input input = new Input();
    protected Config configuracoes = new Config();
    private ArrayList<Item> estoque = configuracoes.getEstoqueItens();
    private ArrayList<Pessoa> cadastros = configuracoes.getCadastrados();
    private Cor cor = new Cor();

    public void menuItens() {
        if(estoque.size() > 0){
            System.out.println("\n---------Estoque<>Loja--------");
            for(int indice = 0;indice<estoque.size();indice++){
                System.out.println("\n["+indice+"] - "+estoque.get(indice).getNome()+" | Quantidade: " + estoque.get(indice).getQuantidade() + " | Preço: " + estoque.get(indice).getValor());
            }
        }else{
            throw new SemAlgoCadastrado("Item");
        }
       
    }

    public void menu(){
        System.out.println("\n| ---------RPG<>LOJA--------- |"+
                           "\n| "+cor.ansi_green+"[1] - Comprar Item"+cor.ansi_reset+"          |"+
                           "\n| "+cor.ansi_purple+"[2] - Estoque"+cor.ansi_reset+"               |"+
                           "\n| "+cor.ansi_red+"[0] - Voltar"+cor.ansi_reset+"                |"+"\n| --------------------------- |"+
                           "\nResposta: ");
    }


    public void executaLoja(int resposta){
        if(resposta == 1){
            try {
                mostraPessoas();
                System.out.println("\nResposta: ");
                int pessoa = input.getInt();
                menuItens();
                System.out.println("\nResposta: ");
                int item = input.getInt();

                System.out.println("Quantidade: ");
                int quantidade = input.getInt();

                Item itemEscolhido = estoque.get(item);
                itemEscolhido.calcularTotal(quantidade);
                cadastros.get(pessoa).comprar(itemEscolhido.calcularTotal(quantidade));
                itemEscolhido.retirarQuantidade(quantidade);
                Item ItemAdicionar = new Item(itemEscolhido.getNome(), itemEscolhido.getValor(), itemEscolhido.getTipo(), quantidade);
                cadastros.get(pessoa).adicionarItemBolsa(ItemAdicionar);

           } catch (SemAlgoCadastrado e) {
               System.out.println(e.getMessage());
           } catch (IndexOutOfBoundsException e){
                System.out.println("Item/Pessoa não encontrado");
           } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
        }
        }else if(resposta == 2){
           try {
                menuItens();
           } catch (SemAlgoCadastrado e) {
               System.out.println(e.getMessage());
           }
        }else if(resposta == 0){
            resposta = -1;
        }else{
            throw new IllegalArgumentException("\nEscolha uma das opções mostradas!");  
        }
    }

    public void startLoja(){
        int resposta = -1;
        while (resposta != 0) {
            menu();
            resposta = input.getIntLoop();
            try {
                executaLoja(resposta);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void mostraPessoas(){
        configuracoes.mostrarPessoasCadastradas();
   }

   public void mostraInventario() throws SemAlgoCadastrado{
       mostraPessoas();
       System.out.println("Resposta:  ");
       int indicePessoa = input.getInt();
       configuracoes.mostraInventario(indicePessoa);
   }

}
