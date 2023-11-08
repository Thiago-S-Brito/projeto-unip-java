class Usuario {
    private String nome;
    private int id;
    private String endereco;
    private String telefone;
    private double renda;

    public Usuario(String nome, int id, String endereco, String telefone, double renda) {
        this.nome = nome;
        this.id = id;
        this.endereco = endereco;
        this.telefone = telefone;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getRenda() {
        return renda;
    }

    // Método para calcular a taxa anual
    public double calcularTaxaAnual() {
        // O valor mínimo da taxa é R$100
        return Math.max(100.0, 0.01 * renda);
    }
}