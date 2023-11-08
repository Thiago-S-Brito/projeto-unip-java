import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        String nome, endereco, telefone;
        int id;
        double renda;
        String tipoUsuario = JOptionPane.showInputDialog("Digite o tipo de usuário (Estudante ou Professor):");

        if (tipoUsuario != null && !tipoUsuario.isEmpty()) {
            nome = JOptionPane.showInputDialog("Nome do " + tipoUsuario + ":");
            id = Integer.parseInt(JOptionPane.showInputDialog("ID do " + tipoUsuario + ":"));
            endereco = JOptionPane.showInputDialog("Endereço do " + tipoUsuario + ":");
            telefone = JOptionPane.showInputDialog("Telefone do " + tipoUsuario + ":");
            renda = Double.parseDouble(JOptionPane.showInputDialog("Renda do " + tipoUsuario + ":"));

            if (tipoUsuario.equalsIgnoreCase("Estudante")) {
                String curso = JOptionPane.showInputDialog("Curso do Estudante:");
                String ra = JOptionPane.showInputDialog("RA do Estudante:");
                int maxEmprestimos = Integer.parseInt(JOptionPane.showInputDialog("Número máximo de empréstimos do Estudante:"));
                Estudante estudante = new Estudante(nome, id, endereco, telefone, renda, curso, ra, maxEmprestimos);

                // Calcula a taxa anual para o estudante
                double taxaAnual = estudante.calcularTaxaAnual();

                // Exibe as informações do estudante e a taxa anual em JOptionPane
                JOptionPane.showMessageDialog(null, "Novo estudante adicionado:\n" +
                        "Nome: " + estudante.getNome() + "\n" +
                        "ID: " + estudante.getId() + "\n" +
                        "Endereço: " + estudante.getEndereco() + "\n" + // Adicione esta linha
                        "Telefone: " + estudante.getTelefone() + "\n" + // Adicione esta linha
                        "Curso: " + estudante.getCurso() + "\n" +
                        "RA: " + estudante.getRa() + "\n" +
                        "Número máximo de empréstimos: " + estudante.getMaxEmprestimos() + "\n" +
                        "Renda: " + estudante.getRenda() + "\n" + // Adicione esta linha
                        "Taxa anual: R$" + String.format("%.2f", taxaAnual));

                biblioteca.adicionarUsuario(estudante);
            } else if (tipoUsuario.equalsIgnoreCase("Professor")) {
                String departamento = JOptionPane.showInputDialog("Departamento do Professor:");
                String titulacao = JOptionPane.showInputDialog("Titulação do Professor:");
                Professor professor = new Professor(nome, id, endereco, telefone, renda, departamento, titulacao);
                biblioteca.adicionarUsuario(professor);
                JOptionPane.showMessageDialog(null, "Novo professor adicionado:\n" +
                        "Nome: " + professor.getNome() + "\n" +
                        "ID: " + professor.getId() + "\n" +
                        "Endereço: " + professor.getEndereco() + "\n" + // Adicione esta linha
                        "Telefone: " + professor.getTelefone() + "\n" + // Adicione esta linha
                        "Departamento: " + professor.getDepartamento() + "\n" +
                        "Titulação: " + professor.getTitulacao() + "\n" +
                        "Renda: " + professor.getRenda() + "\n" + // Adicione esta linha
                        "Taxa anual: R$" + String.format("%.2f", professor.calcularTaxaAnual()));
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido.");
            }
        }

        biblioteca.listarUsuarios();
        int idRemocao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário a ser removido:"));

        // Modifique esta seção para usar o método getUsuarios()
        List<Usuario> usuarios = biblioteca.getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idRemocao) {
                biblioteca.removerUsuario(usuario);
                break;
            }
        }

        biblioteca.listarUsuarios();
    }
}