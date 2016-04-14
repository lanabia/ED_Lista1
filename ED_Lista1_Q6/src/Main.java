/*

	Questão 6 - Lista Encadeada Ordenada de Conta Bancária
	
	Implemente TADs para:
		1. Representar uma conta bancária, onde cada conta bancária possui um número e um
		saldo, além de funções para efetuar crédito e efetuar débito.
		2. Representar uma conta poupança, onde cada conta poupança possui um número e
		um saldo, além de funções para efetuar crédito, efetuar débito e render juros.
		3. Representar uma conta fidelidade, onde cada conta fidelidade possui um número,
		um saldo e um bônus, além de funções para efetuar crédito, efetuar débito e render
		bônus. Em uma conta fidelidade, a cada operação de crédito realizado, 1% do valor
		de creditado é acumulado ao bônus da conta. A função render bônus deve adicionar
		o valor do bônus no saldo da conta e, em seguida, zerar o valor do bônus.
	Implemente um TAD para representar uma lista encadeada ordenada capaz de armazenar
	contas bancárias, contas poupanças ou contas bônus . Esse TAD deverá conter funções
	para:
		1. Criar uma lista vazia;
		2. Inserir elemento no início;
		3. Imprimir os valores armazenados na lista;
		4. Imprimir os valores armazenados na lista usando recursão;
		5. Imprimir os valores armazenados na lista em ordem reversa (da cauda para a cabeça
		da lista);
		6. Verificar se a lista está vazia (retorna 1 se vazia ou 0 se não vazia);
		7. Recuperar/Buscar um determinado elemento da lista;
		8. Remover um determinado elemento da lista;
		9. Remover um determinado elemento da lista usando recursão;
		10. Liberar a lista;
	Implemente um programa que cria uma variável do TAD lista encadeada, criado
	anteriormente, e permite ao usuário realizar as seguintes operações:
		1. Inserir uma conta bancária;
		2. Inserir uma conta poupança;
		3. Inserir uma conta fidelidade;
		4. Realizar crédito em uma determinada conta;
		5. Realizar débito em uma determinada conta;
		6. Consultar o saldo de uma conta;
		7. Consultar o bônus de uma conta fidelidade;
		8. Realizar uma transferência entre duas contas;
		9. Render juros de uma conta poupança;
		10. Render bônus de uma conta fidelidade;
		11. Remover uma conta;
		12. Imprimir número e saldo de todas as contas cadastradas;

*/
public class Main {

	public static int VAZIO = 1;
	public static int NAO_VAZIO = 0;
	public static int CONTA = 5;
	public static int POUPANCA = 7;
	public static int CONTAFIDELIDADE = 15;

	public static void main(String[] args) throws Throwable {

		// cria lista vazia
		Lista lst = new Lista();

		System.out.println("1. Inserir uma conta bancária;");
		Conta conta1 = new Conta(CONTA);
		lst = lst_insere(lst, conta1);
		// lst_imprime(lst);

		System.out.println("2. Inserir uma conta poupança;");
		Poupanca conta2 = new Poupanca(POUPANCA);
		lst = lst_insere(lst, conta2);
		// lst_imprime(lst);

		System.out.println("3. Inserir uma conta fidelidade;");
		ContaFidelidade conta3 = new ContaFidelidade(CONTAFIDELIDADE);
		lst = lst_insere(lst, conta3);
		System.out.println("\nTodas as contas");
		lst_imprime(lst);

		System.out.println("\n4. Realizar crédito em uma determinada conta;");
		lst_busca(lst, CONTA).conta.efetuarCredito(40f);
		lst_imprime(lst);

		System.out.println("\n5. Realizar débito em uma determinada conta;");
		lst_busca(lst, CONTA).conta.efetuarDebito(40f);
		lst_imprime(lst);

		System.out.println("\n6. Consultar o saldo de uma conta;");
		lst_busca(lst, CONTA).conta.showSaldo();

		System.out.println("\n7. Consultar o bônus de uma conta fidelidade;");
		ContaFidelidade conta7 = (ContaFidelidade) lst_busca(lst, CONTAFIDELIDADE).conta;
		conta7.showBonus();

		System.out.println("\n8. Realizar uma transferência entre duas contas;");
		lst_busca(lst, CONTA).conta.efetuarCredito(10);
		lst_busca(lst, POUPANCA).conta.efetuarDebito(10);
		lst_imprime(lst);

		System.out.println("\n9. Render juros de uma conta poupança;");
		Poupanca conta9 = (Poupanca) lst_busca(lst, POUPANCA).conta;
		conta9.renderJuros(5f);
		lst_imprime(lst);

		System.out.println("\n10. Render bônus de uma conta fidelidade;");
		ContaFidelidade conta10 = (ContaFidelidade) lst_busca(lst, CONTAFIDELIDADE).conta;
		conta10.efetuarCredito(500);
		conta10.showBonus();

		System.out.println("\n11. Remover uma conta;");
		System.out.println("Removendo...");
		lst_retira(lst, POUPANCA);
		
		System.out.println("\n12. Imprimir número e saldo de todas as contas cadastradas;");
		lst_imprime(lst);
	}

	public static Lista lst_insere(Lista lst, Conta conta) {

		Lista anterior = null;
		int count = 1;
		Lista atual = lst;

		if (lst_ta_vazia(atual) == VAZIO)
			return new Lista(conta);

		while (atual.conta.number < conta.number) {
			if (atual.next == null) {
				atual.next = new Lista(conta);
				return lst;
			}

			anterior = atual;
			atual = atual.next;
			count = count + 1;
		}

		if (count == 1)
			return new Lista(conta, lst);
		else
			anterior.next = new Lista(conta, atual);

		return lst;
	}

	public static void lst_imprime(Lista lst) {

		Lista aux = lst;

		if (lst_ta_vazia(lst) == VAZIO)
			System.out.println("Nenhuma conta cadstrada!");
		else {
			// System.out.println("Lista:");
			while (lst_ta_vazia(aux) == NAO_VAZIO) {
				System.out.print("conta: " + aux.conta.number + "  saldo: " + aux.conta.saldo + "\n");
				aux = aux.next;
			}
		}
	}

	public static void lst_imprime_recursivo(Lista lst) {

		if (lst_ta_vazia(lst) == NAO_VAZIO) {
			System.out.print("conta: " + lst.conta.number + "  saldo: " + lst.conta.saldo + "\n");
			lst_imprime_recursivo(lst.next);
		}
	}

	public static void lst_imprime_de_tras_pra_frente(Lista lst) {

		if (lst_ta_vazia(lst) == NAO_VAZIO) {
			lst_imprime_de_tras_pra_frente(lst.next);
			System.out.print(lst.conta + " ");
		}
	}

	public static int lst_ta_vazia(Lista lst) {
		if (lst == null)
			return VAZIO;
		else if (lst.next == null && lst.conta == null)
			return VAZIO;

		return NAO_VAZIO;
	}

	public static Lista lst_busca(Lista lst, int numero) {
		Lista aux = lst;

		if (lst_ta_vazia(lst) == VAZIO)
			return null;

		while (lst_ta_vazia(aux) == NAO_VAZIO) {
			if (aux.conta.number == numero)
				return aux;
			aux = aux.next;
		}

		return aux;
	}

	public static Lista lst_retira(Lista lst, int conta) throws Throwable {

		Lista anterior = null;
		int count = 1;
		Lista atual = lst;

		while (lst_ta_vazia(atual) == NAO_VAZIO) {
			if (atual.conta.number == conta) {
				if (count == 1)
					return lst.next;

				anterior.next = atual.next;
			}
			anterior = atual;
			atual = atual.next;
			count = count + 1;

		}

		return lst;
	}

	public static Lista lst_retira_recursivo(Lista lst, int conta) throws Throwable {
		Lista atual = lst;
		Lista anterior = null;

		if (anterior == null && atual.conta.number == conta)
			return atual.next;

		anterior = atual;
		atual = atual.next;

		if (atual.conta.equals(conta)) {
			anterior.next = atual.next;
			atual = null;
		} else
			lst_retira_recursivo(atual, conta);
		return lst;

	}

	public static Lista lst_libera(Lista lst) {
		Lista aux = lst;
		while (lst_ta_vazia(aux) == NAO_VAZIO) {
			aux = aux.next;
			aux = null;
		}
		return null;
	}

	public static boolean lst_compara(Lista lst1, Lista lst2) {
		Lista atual1 = lst1;
		Lista atual2 = lst2;

		if (lst1 == null && lst2 == null)
			return true;

		while (atual1.conta == atual2.conta) {
			atual1 = atual1.next;
			atual2 = atual2.next;
			if (atual1 == null && atual2 == null)
				return true;
		}

		return false;
	}

}
