
public class Poupanca extends Conta {
	
	public Poupanca(int number, float saldo) {
		super(number,saldo);
	}

	public Poupanca(int number) {
		super(number, 0);
	}

	public Poupanca() {
		super(0, 0);
	}

	public void renderJuros(float porcentagem) {
		this.saldo = this.saldo + (porcentagem / 100) * this.saldo;
	}

}
