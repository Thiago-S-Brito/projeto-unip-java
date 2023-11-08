import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    private List<Usuario> usuarios;

    public Biblioteca() {
        usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void listarUsuarios() {
        StringBuilder userList = new StringBuilder("Lista de Usuários:\n");
        for (Usuario usuario : usuarios) {
            userList.append("Nome: ").append(usuario.getNome()).append(", ID: ").append(usuario.getId()).append(", Tipo: ");
            if (usuario instanceof Estudante) {
                Estudante estudante = (Estudante) usuario;
                userList.append("Estudante, RA: ").append(estudante.getRa()).append(", Curso: ").append(estudante.getCurso())
                        .append(", Máximo de Empréstimos: ").append(estudante.getMaxEmprestimos()).append("\n");
            } else if (usuario instanceof Professor) {
                userList.append("Professor, Departamento: ").append(((Professor) usuario).getDepartamento())
                        .append(", Titulação: ").append(((Professor) usuario).getTitulacao()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, userList.toString());
    }

    // Método para obter a lista de usuários
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}