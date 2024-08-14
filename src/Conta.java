import java.text.DecimalFormat;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		
		if (valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}

		saldo -= valor;
		System.out.println("Transação concluída. Saldo atualizado: " + saldo);
	}

	@Override
	public void depositar(double valor) {

		saldo += valor;
		System.out.println("Transação concluída. Saldo atualizado: " + saldo);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {

		if (valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}

		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void calcularInvestimento(double valorInicial, double rendimentoMensal, int prazoMeses) {
		
		if (valorInicial <= 0 || rendimentoMensal <= 0 || prazoMeses < 0) {
			throw new IllegalArgumentException("Insira valores maiores do que zero.");
		}

		double valorFinal = valorInicial * Math.pow(1 + rendimentoMensal, prazoMeses);
		
		DecimalFormat df = new DecimalFormat("#.00");
		String valorInicialFormatado = df.format(valorInicial);
		String valorFinalFormatado = df.format(valorFinal);

		System.out.println("Valor a ser investido: R$ " + valorInicialFormatado);
		System.out.println("Valor atualizado ao final de " + prazoMeses + " meses: R$ " + valorFinalFormatado);

	}

	@Override
	public void calcularEmprestimo(double valorAEmprestar, double taxaJurosAoMes, int prazoPagamentoEmMeses){

		if (valorAEmprestar <= 0 || taxaJurosAoMes <= 0 || prazoPagamentoEmMeses < 0) {
			throw new IllegalArgumentException("Insira valores maiores do que zero.");
		}

		double valorFinal = valorAEmprestar * Math.pow(1 + taxaJurosAoMes, prazoPagamentoEmMeses);

		DecimalFormat df = new DecimalFormat("#.00");
		String valorAEmprestarFormatado = df.format(valorAEmprestar);
		String valorFinalFormatado = df.format(valorFinal);

		System.out.println("Valor a ser emprestado: R$ " + valorAEmprestarFormatado);
		System.out.println("Valor final a ser pago: R$ " + valorFinalFormatado);

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
