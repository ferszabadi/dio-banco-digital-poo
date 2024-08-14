
public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();

	void calcularInvestimento(double valorInicial, double rendimentoMensal, int prazoMeses);

	void calcularEmprestimo(double valorAEmprestar, double taxaJurosAoMes, int prazoPagamentoEmMeses);
	
}
