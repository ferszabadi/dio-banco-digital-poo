public class Main {

	public static void main(String[] args) {
		Cliente fernanda = new Cliente();
		fernanda.setNome("Fernanda");
		
		Conta cc = new ContaCorrente(fernanda);
		Conta poupanca = new ContaPoupanca(fernanda);

		cc.depositar(1000);
		cc.transferir(100, poupanca);
		cc.calcularEmprestimo(500, 0.05, 10);
		cc.calcularInvestimento(200, 0.02, 36);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
	}

}
