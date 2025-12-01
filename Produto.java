public class Produto {


        private int id;
        private String nome;
        private String descricao;
        private int quantidade;
        private double precoUnitario;
        private String fornecedor;

        public Produto() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public void setPrecoUnitario(double precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public String getFornecedor() {
            return fornecedor;
        }

        public void setFornecedor(String fornecedor) {
            this.fornecedor = fornecedor;
        }
    }

