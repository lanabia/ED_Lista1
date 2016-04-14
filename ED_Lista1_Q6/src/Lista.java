
public class Lista {

	// TAD
	Conta conta;
	Lista next;
	
	//cria lista
	public Lista(){
		
	}
		
	public Lista(Conta conta) {
		this.conta = conta;
	}
	
	public Lista(Conta conta,Lista next) {
		this.next = next;
		this.conta = conta;
	}

	
}
