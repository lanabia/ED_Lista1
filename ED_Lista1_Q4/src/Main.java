
/*

Quest�o 4 - Lista Circular

Implemente um TAD para representar uma lista encadeada circular (simplesmente
encadeada) capaz de armazenar valores inteiros. Esse TAD dever� conter fun��es para:
1. Criar uma lista vazia;
2. Inserir elemento;
3. Imprimir os valores armazenados na lista;
4. Imprimir os valores armazenados na lista usando recurs�o;
5. Verificar se a lista est� vazia (retorna 1 se vazia ou 0 se n�o vazia);
6. Recuperar/Buscar um determinado elemento da lista;
7. Remover um determinado elemento da lista;
8. Remover um determinado elemento da lista usando recurs�o;
9. Liberar a lista;
Implemente um programa que cria uma vari�vel do TAD lista encadeada circular
(simplesmente encadeada), criado anteriormente, e utiliza cada uma de suas fun��es.

*/

public class Main {

	public static int VAZIO = 1;
	public static int NAO_VAZIO = 0;
	public static int count1 = 0;
	public static int count2 = 0;

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
			System.out.println("N�o achou! :(");
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
			lst = new Lista(val);
		else if (lst.cursor.next == null) // s� tem um elemento
		{
			No novoNo = new No(val, lst.cursor);
			lst.cursor.next = novoNo;
		} else {
			No novoNo = new No(val, lst.cursor);
			for (int i = 1; i <= lst.size; i++)
				lst.next();
			lst.cursor.next = novoNo;
			lst.next();
			lst.size = lst.size + 1;
		}
		return lst;

	}

	public static void lst_imprime(Lista lst) {

		if (lst_ta_vazia(lst) == VAZIO)
			System.out.println("Lista vazia");
		else {
			System.out.println("Lista:");
			for (int i = 1; i <= lst.size; i++) {
				System.out.print(lst.getInfo() + " ");
				lst.next();
			}
		}
	}

	public static void lst_imprime_recursivo(Lista lst) {
		if (lst_ta_vazia(lst) != VAZIO && count1 <= lst.size) {
			System.out.print(lst.getInfo() + " ");
			lst.next();
			count1 = count1 + 1;
			lst_imprime_recursivo(lst);
		}

	}

	public static int lst_ta_vazia(Lista lst) {
		if ((lst == null) || (lst.size == 0))
			return VAZIO;

		return NAO_VAZIO;
	}

	public static No lst_busca(Lista lst, int val) {

		if (lst_ta_vazia(lst) == VAZIO)
			System.out.println("Lista vazia");
		else {
			for (int i = 1; i <= lst.size; i++) {
				if (lst.getInfo() == val)
					return lst.cursor;
				lst.next();
			}
		}
		return null;
	}

	public static Lista lst_retira(Lista lst, int val) {

		No anterior = lst.cursor;
		lst.next(); // avan�a um elemento

		if (lst_ta_vazia(lst) != VAZIO) {
			for (int i = 1; i <= lst.size; i++) {
				if (lst.getInfo() == val) {
					anterior.next = lst.cursor.next;
				}
				anterior = lst.cursor;
				lst.next();
			}
		}
		return lst;
	}

	public static Lista lst_retira_recursivo(Lista lst, int val) {
		No anterior = lst.cursor;
		lst.next();
		if (lst_ta_vazia(lst) != VAZIO && count2 <= lst.size) {
			if (lst.getInfo() == val) {
				anterior.next = lst.cursor.next;
			}
			lst.next();
			count2 = count2 + 1;
			lst_retira_recursivo(lst, val);
		}

		return lst;

	}

	public static Lista lst_libera(Lista lst) {
		No aux = lst.cursor;
		for (int i = 1; i <= lst.size; i++) {
			aux = aux.next;
			lst.cursor = null;
		}
		return null;
	}

}
