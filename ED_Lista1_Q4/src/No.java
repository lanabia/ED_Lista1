
public class No {

	int info;
	No next;

	public No() {
		this.info = 0;
		this.next = null;
	}

	public No(int info) {
		this.info = info;
		this.next = null;
	}

	public No(int info, No next) {
		this.info = info;
		this.next = next;
	}

}
