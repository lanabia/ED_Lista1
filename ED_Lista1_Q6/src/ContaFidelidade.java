
public class ContaFidelidade extends Conta {

	float bonus;

	public ContaFidelidade(int number, float saldo) {
		super.number = number;
		super.saldo = saldo;
	}

	public ContaFidelidade(int number) {
		super(number, 0);
	}

	public ContaFidelidade() {
		super(0, 0);
	}

	private void renderBonus(float bonus) {
		this.bonus = this.bonus + bonus;
	}

	void efetuarCredito(float valor) {
		this.saldo = this.saldo - valor;
		renderBonus(new Float(valor * 0.01));
	}

	public void showBonus() {
		System.out.println("Bonus: " + bonus);
	}

}
