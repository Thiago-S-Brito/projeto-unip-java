class Professor extends Usuario {
    private String departamento;
    private String titulacao;

    public Professor(String nome, int id, String endereco, String telefone, double renda, String departamento, String titulacao) {
        super(nome, id, endereco, telefone, renda);
        this.departamento = departamento;
        this.titulacao = titulacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getTitulacao() {
        return titulacao;
    }

    // Método para calcular a taxa anual específica para professores
    @Override
    public double calcularTaxaAnual() {
        double renda = getRenda();
        double taxa = 0.02 * renda;
        return Math.max(taxa, 100.0);
    }
}