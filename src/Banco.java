import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	
	private List<Conta> contas = new ArrayList<>();
	
	
	public void addConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public void listaClientes() {
		System.out.println("==========================");
		System.out.println("Lista de clientes: ");
		for(Conta conta: contas) {
			System.out.println(conta.getCliente());
		}
	}
	
	
}
