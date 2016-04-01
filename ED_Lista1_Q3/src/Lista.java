
public class Lista {

	// TAD
	int info;
	Lista next;
	Lista previous;

	// cria lista
	public Lista() {

	}

	public Lista(int val) {
		this.info = val;
	}

	public Lista(int val, Lista next, Lista previous) {
		this.next = next;
		this.info = val;
		this.previous = previous;
	}

}
