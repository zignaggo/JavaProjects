
public class Master {

    private Input input = new Input();
    private Cor cor = new Cor();
    private Loja loja = new Loja();

   
    public void menuPrincipal(){
        System.out.println(
                           "\n| -----------|Principal|----------- |"+
                         "\n| "+cor.ansi_green+"[1] - Abrir Loja de Itens"+cor.ansi_reset+"         |"+
                         "\n| "+cor.ansi_purple+"[2] - Configurações"+cor.ansi_reset+"               |"+
                         "\n| "+cor.ansi_cyan+"[3] - Inventário"+cor.ansi_reset+"                  |"+
                         "\n| "+cor.ansi_red+"[0] - Sair"+cor.ansi_reset+"                        |"+
                         "\n| --------------------------------- |"+
                         "\nResposta: "
                         );
    }

    public void executaPrincipal(int resposta){
        if(resposta == 1){
            try {
                loja.startLoja();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            }
        }else if(resposta == 2){
            loja.configuracoes.startConfig();
        }else if(resposta == 3){
            try {
                loja.mostraInventario();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e){
                System.out.println("Pessoa não encontrada");
            }
        }else if(resposta == 0){

        }else{
            throw new IllegalArgumentException("\nEscolha uma das opções do menu!");
        }
    }
   



    public void start() {
        int resposta = -1;
        while (resposta != 0) {
            menuPrincipal();
            resposta = input.getIntLoop();
            try {
                executaPrincipal(resposta);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }



    }

    public static void main(String[] args) {
        Master master = new Master();

        master.start();
    }
}
