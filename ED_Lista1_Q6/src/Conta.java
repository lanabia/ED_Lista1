
public class Conta {

	int number;
	float saldo;

	public Conta(int number, float saldo) {
		this.number = number;
		this.saldo = saldo;
	}

	public Conta(int number) {
		this(number, 0);
	}

	public Conta() {
		this(0, 0);
	}

	void efetuarCredito(float valor) {
		this.saldo = this.saldo - valor;
	}

	void efetuarDebito(float valor) {
		this.saldo = this.saldo + valor;
	}

	void showSaldo() {
		System.out.println("Saldo: " + saldo);
	}

}
