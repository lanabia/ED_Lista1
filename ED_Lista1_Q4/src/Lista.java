
public class Lista {

	// TAD Lista Circular
	No cursor;
	int size;

	// cria lista
	public Lista() {
		this.size = 0;
	}

	public Lista(int val) {
		this.cursor = new No(val);
		this.size = this.size + 1;
	}

	public int getInfo() {
		return cursor.info;
	}

	public No next() {
		this.cursor = this.cursor.next;
		return this.cursor;
	}

}
