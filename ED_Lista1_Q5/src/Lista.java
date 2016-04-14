
public class Lista {

	// TAD
	int info;
	Lista next;

	// cria lista
	public Lista() {

	}

	public Lista(int val) {
		this.info = val;
		this.next = null;
	}

	/*public Lista(int val, Lista lista) {
		this.info = val;
		Lista nextLista = lista.next;
		lista.next = this;
		this.next = nextLista;
	}*/
	
	public Lista(int val, Lista next) {
		this.info = val;
		this.next = next;
	}
	
	

}
