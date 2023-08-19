
public class SemAlgoCadastrado extends RuntimeException{
    public SemAlgoCadastrado(String tipo){
        super("\nNenhum cadastro realizado! Por favor Cadastre algum(a) "+ tipo +"!");
    }
}
