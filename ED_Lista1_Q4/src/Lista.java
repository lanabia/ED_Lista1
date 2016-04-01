
public class Lista {

	// TAD
	int info;
	Lista next;

	// cria lista
	public Lista() {

	}

	public Lista(int val) {
		this.info = val;
		this.next = this;
	}

	public Lista(int val, Lista next) {
		this.next = next;
		this.info = val;
	}

}
