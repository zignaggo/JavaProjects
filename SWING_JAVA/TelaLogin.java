import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin  extends JFrame{

    private JLabel txtUsuario;
    private JTextField inputUsuario;
    private JButton botaoEnviar;
    private Container painel;
    private GridLayout layout; 
    private JLabel txtSenha;
    private JPasswordField inputSenha;
    private JButton botaoVoltar;
    private Image image = new ImageIcon("image/logo3.png").getImage(); 

    private Funcionario adm = new Funcionario("admin", "admin");

    public TelaLogin(){

        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        // LAYOUT E PAINEL
        painel = getContentPane();
        layout =  new GridLayout(7, 1, 0, 3); //(rows, cols, gapcols, gapRows)
        
        // COMPONENTES EM SI
        txtUsuario = new JLabel("Usuário");
        inputUsuario = new JTextField();
        txtSenha = new JLabel("Senha");
        inputSenha = new JPasswordField();
        botaoEnviar = new JButton("Entrar");
        botaoVoltar = new JButton("Voltar");

        // FONTE
        Font fonte = new Font("Monospace", Font.BOLD, 12);
        txtUsuario.setFont(fonte);
        txtSenha.setFont(fonte);

        // PADDINGS
        ((JComponent) painel).setBorder(new EmptyBorder(25,25,25,25));
        
        // Configurações padrões da tela
        setSize(400, 350);
        setTitle("Login");
        setVisible(true);
        setResizable(false);
        painel.setLayout(layout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(image);
        setLocationRelativeTo(null);

        // Adicionando componentes
        painel.add(txtUsuario);
        painel.add(inputUsuario);
        painel.add(txtSenha);
        painel.add(inputSenha);
        painel.add(new JLabel(""));
        painel.add(botaoEnviar);
        painel.add(botaoVoltar);
        

        botaoEnviar.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                botaoLogarActionPerformed(e);
              }
            }
          );

        botaoVoltar.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                voltarActionPerformed(e);
              }
            }
          );
    }

    private void voltarActionPerformed(ActionEvent evt){
        JFrame telaLogin = new TelaEscolha();
        this.dispose();
        telaLogin.setVisible(true);
    }

    private void botaoLogarActionPerformed(ActionEvent evt){
        String usuario = inputUsuario.getText();
        String senha = String.valueOf(inputSenha.getPassword());

        if(usuario.equals(adm.usuario) && senha.equals(adm.senha)){
            // JFrame telaLogin = new TelaEscolha();
            // this.dispose();
            // telaLogin.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos");
        }
    }
}
