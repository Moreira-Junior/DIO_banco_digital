
public class Main {

	public static void main(String[] args) {
		Banco bb = new Banco();
		
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		
		Conta cc = new ContaCorrente(cliente,bb);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Maria");
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Pedro");
		
		Conta cp2 = new ContaPoupanca(cliente2, bb);
		Conta cp3 = new ContaPoupanca(cliente3, bb);
		
		//depositando 100 reais na conta de joao
		cc.depositar(100);
		//joao transfere 10 reais para maria
		cc.transferir(10, cp2);
		//joao transfere 10 reais para pedro
		cc.transferir(20, cp3);
		//extrato de joao
		cc.imprimirExtrato();
		//historico de transferencias de joao
		cc.historico();
		//lista dos clientes do banco
		bb.listaClientes();
	}

}
