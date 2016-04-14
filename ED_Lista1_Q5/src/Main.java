
/*

Questão 4 - Lista Circular

Implemente um TAD para representar uma lista encadeada circular (simplesmente
encadeada) capaz de armazenar valores inteiros. Esse TAD deverá conter funções para:
1. Criar uma lista vazia;
2. Inserir elemento;
3. Imprimir os valores armazenados na lista;
4. Imprimir os valores armazenados na lista usando recursão;
5. Verificar se a lista está vazia (retorna 1 se vazia ou 0 se não vazia);
6. Recuperar/Buscar um determinado elemento da lista;
7. Remover um determinado elemento da lista;
8. Remover um determinado elemento da lista usando recursão;
9. Liberar a lista;
Implemente um programa que cria uma variável do TAD lista encadeada circular
(simplesmente encadeada), criado anteriormente, e utiliza cada uma de suas funções.

*/

public class Main {

	public static int VAZIO = 1;
	public static int NAO_VAZIO = 0;

	public static void main(String[] args) throws Throwable {

		Lista lst = new Lista();
		lst_imprime(lst);
		System.out.println("\nInserindo 5...");
		lst = lst_insere(lst, 5);
		lst_imprime(lst);
		System.out.println("\nInserindo 4...");
		lst = lst_insere(lst, 4);
		lst_imprime(lst);
		System.out.println("\nInserindo 3...");
		lst = lst_insere(lst, 3);
		lst_imprime(lst);
		System.out.println("\nInserindo 2...");
		lst = lst_insere(lst, 2);
		lst_imprime(lst);
		System.out.println("\nInserindo 1...");
		lst = lst_insere(lst, 1);
		lst_imprime(lst);

		System.out.println("\n\nLista (imprime recursivo):");
		// lst_imprime_recursivo(lst);

		int elemento = 4;
		System.out.println("\n\nBusca elemento " + elemento + ":");
		if (lst_busca(lst, elemento) == null)
			System.out.println("Não achou! :(");
		else
			System.out.println("ACHOU! Elemento: " + lst_busca(lst, elemento).info);

		elemento = 1;
		System.out.println("\nRetira " + elemento + ":");
		lst = lst_retira(lst, elemento);
		lst_imprime(lst);

		elemento = 3;
		System.out.println("\n\nRetira recursivo " + elemento + ":");
		// lst = lst_retira_recursivo(lst, elemento);
		// lst_imprime_recursivo(lst);

		System.out.println("\n\nLimpando...");
		// lst_imprime(lst_libera(lst));

	}

	public static Lista lst_insere(Lista lst, int val) {
		if (lst_ta_vazia(lst) == VAZIO)
			return new Lista(val);

		Lista newLs = new Lista(val, lst);
		Lista aux = lst.next;
		if (aux != null) {
			while (aux.next.info != lst.info)
				aux = aux.next;
		} else
			aux = lst;
		aux.next = newLs;
		return newLs;

	}

	public static void lst_imprime(Lista lst) {

		Lista aux = lst;

		if (lst_ta_vazia(lst) == VAZIO)
			System.out.println("Lista vazia");
		else {
			System.out.println("Lista:");
			if (aux.next == null) // só tem um elemento
				System.out.print(aux.info);

			else
				do {
					System.out.print(aux.info + " ");
					aux = aux.next;
				} while (aux.info != lst.info);
		}
	}

	public static void lst_imprime_recursivo(Lista lst) {
		Lista aux = lst;

		if (lst_ta_vazia(lst) != VAZIO && aux.info != lst.info) {
			System.out.print(aux.info + " ");
			lst_imprime_recursivo(aux.next);
		}

	}

	public static int lst_ta_vazia(Lista lst) {
		if ((lst == null) || (lst.next == null && lst.info == 0))
			return VAZIO;

		return NAO_VAZIO;
	}

	public static Lista lst_busca(Lista lst, int val) {
		Lista aux = lst;

		if (lst_ta_vazia(lst) == VAZIO)
			return null;

		do {
			if (aux.info == val)
				return aux;
			aux = aux.next;
		} while (aux.info != lst.info);

		return null;
	}

	public static Lista lst_retira(Lista lst, int val) throws Throwable {

		Lista anterior = lst;
		Lista atual = lst.next;

		while (lst_ta_vazia(anterior) == NAO_VAZIO && atual.info != lst.info) {
			if (atual.info == val) {
				if (lst.next == null) // lista com um só elemento
					return null;

				anterior.next = atual.next;
			}
			anterior = atual;
			atual = atual.next;

		}
		// se for o primeiro elemento
		if (atual.info == val) {
			anterior.next = atual.next;
			return atual.next;
		}
		return lst;
	}

	public static Lista lst_retira_recursivo(Lista lst, int val) throws Throwable {
		Lista atual = lst;
		Lista anterior = null;

		if (anterior == null && atual.info == val)
			return atual.next;

		anterior = atual;
		atual = atual.next;

		if (atual.info == val) {
			anterior.next = atual.next;
			atual = null;
		} else
			lst_retira_recursivo(atual, val);
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

}
