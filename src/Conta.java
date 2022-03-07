import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int CONTADOR = 1;
	
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	protected Map<String,Double> historico = new HashMap<>();
		
	public Conta(Cliente cliente, Banco banco) {
		
		this.agencia = AGENCIA_PADRAO;
		this.numeroConta = CONTADOR++;
		this.cliente = cliente;
		banco.addConta(this);
	}
	
	public void sacar(double valor) {
		this.saldo -= valor;
		
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void transferir(double valor, Conta conta) {
		this.sacar(valor);
		conta.depositar(valor);
		String temp = conta.cliente.getNome();
		this.historico.put(temp, valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getCliente() {
		return this.cliente.getNome();
	}
	
	protected void historico() {
		System.out.println("==========================");
		for(Entry<String, Double> registro: historico.entrySet()) {
			System.out.println(this.getCliente()+" transferiu para "
		    + registro.getKey() + " R$ "+registro.getValue());
			System.out.println();
			
		}
	
	}
	
	protected void imprimirExtrato() {
		System.out.println("==========================");
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numeroConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("==========================");
		System.out.println();
	}
	
	
	
}
