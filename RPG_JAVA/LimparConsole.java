
public class LimparConsole {

    public void limpar() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
            
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}