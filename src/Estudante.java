class Estudante extends Usuario {
    private String curso;
    private String ra; // Adicione o campo RA aqui
    private int maxEmprestimos;

    public Estudante(String nome, int id, String endereco, String telefone, double renda, String curso, String ra, int maxEmprestimos) {
        super(nome, id, endereco, telefone, renda);
        this.curso = curso;
        this.ra = ra;
        this.maxEmprestimos = maxEmprestimos;
    }

    public String getCurso() {
        return curso;
    }

    public String getRa() {
        return ra;
    }

    public int getMaxEmprestimos() {
        return maxEmprestimos;
    }

    public double calcularTaxaAnual() {
        double renda = getRenda();
        return Math.min(0.01 * renda, 100.0);
    }
}