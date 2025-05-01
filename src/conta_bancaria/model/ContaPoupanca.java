package conta_bancaria.model;

public class ContaPoupanca extends Conta {

    private int diaRendimento;
    private float taxaDeJuros;

    public ContaPoupanca(int numero, int agencia, int tipo, String titular, double saldo, int aniversario, float juros) {
        super(numero, agencia, tipo, titular, saldo);
        this.diaRendimento = aniversario;
        this.taxaDeJuros = juros;
    }

 
	

	public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    public float getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(float taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public void aplicarRendimento(int diaAtual) {
        if (diaAtual == this.diaRendimento) {
            float rendimento = this.saldo * this.taxaDeJuros;
            this.saldo += rendimento;
            System.out.printf("Rendimento aplicado: R$ %.2f\n", rendimento);
        } else {
            System.out.println("Hoje não é o dia de rendimento.");
        }
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Dia do Rendimento: " + this.diaRendimento);
        System.out.println("Taxa de Juros: " + (this.taxaDeJuros * 100) + "% ao mês");
    }
}
