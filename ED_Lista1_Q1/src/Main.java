
/*
 * 
Questão 1 - Lista Encadeada

Implemente um TAD para representar uma lista encadeada capaz de armazenar valores
inteiros. Esse TAD deverá conter funções para:
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
anteriormente, e utiliza cada uma de suas funções.

*/

public class Main {

	public static int VAZIO = 1;
	public static int NAO_VAZIO = 0;

	public static Lista lst;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		lst = new Lista();

		System.out.println("Inserindo 5...");
		lst = lst_insere_no_inicio(lst, 5);
		System.out.println("Inserindo 4...");
		lst = lst_insere_no_inicio(lst, 4);
		System.out.println("Inserindo 3...");
		lst = lst_insere_no_inicio(lst, 3);
		System.out.println("Inserindo 2...");
		lst = lst_insere_no_inicio(lst, 2);
		System.out.println("Inserindo 1...");
		lst = lst_insere_no_inicio(lst, 1);
		lst_imprime(lst);

		System.out.println("\n\nLista (imprime recursivo):");
		lst_imprime_recursivo(lst);

		System.out.println("\n\nLista (contrário):");
		lst_imprime_de_tras_pra_frente(lst);

		int elemento = 2;
		System.out.println("\n\nBusca elemento " + elemento + ":");
		if (lst_busca(lst, elemento) == null)
			System.out.println("Não achou! :(");
		else
			System.out.println("ACHOU! Elemento: " + lst_busca(lst, elemento).info);

		elemento = 2;
		System.out.println("\nRetira " + elemento + ":");
		lst = lst_retira(lst, elemento);
		lst_imprime_recursivo(lst);

		elemento = 3;
		System.out.println("\nRetira recursivo " + elemento + ":");
		lst = lst_retira_recursivo(lst, elemento);
		lst_imprime_recursivo(lst);

		System.out.println("\n\nLimpando...");
		lst_imprime(lst_libera(lst));

	}

	public static Lista lst_insere_no_inicio(Lista lst, int val) {
		return new Lista(val, lst);
	}

	public static void lst_imprime(Lista lst) {

		Lista aux = lst;

		if (lst_ta_vazia(lst) == VAZIO)
			System.out.println("Lista vazia");
		else {
			System.out.println("Lista:");
			while (lst_ta_vazia(aux) == NAO_VAZIO) {
				System.out.print(aux.info + " ");
				aux = aux.next;
			}
		}
	}

	public static void lst_imprime_recursivo(Lista lst) {

		if (lst_ta_vazia(lst) == NAO_VAZIO) {
			System.out.print(lst.info + " ");
			lst_imprime_recursivo(lst.next);
		}
	}

	public static void lst_imprime_de_tras_pra_frente(Lista lst) {

		if (lst_ta_vazia(lst) == NAO_VAZIO) {
			lst_imprime_de_tras_pra_frente(lst.next);
			System.out.print(lst.info + " ");
		}
	}

	public static int lst_ta_vazia(Lista lst) {
		if (lst == null)
			return VAZIO;
		else if (lst.next == null && lst.info == 0)
			return VAZIO;

		return NAO_VAZIO;
	}

	public static Lista lst_busca(Lista lst, int val) {
		Lista aux = lst;

		if (lst_ta_vazia(lst) == VAZIO)
			return null;

		while (lst_ta_vazia(aux) == NAO_VAZIO) {
			if (aux.info == val)
				return aux;
			aux = aux.next;
		}

		return aux;
	}

	public static Lista lst_retira(Lista lst, int val) throws Throwable {

		Lista anterior = null;
		int count = 1;
		Lista atual = lst;

		while (lst_ta_vazia(atual) == NAO_VAZIO) {
			if (atual.info == val) {
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
