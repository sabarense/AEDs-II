package TT01.Recursividade;

class exc5 {

	public static void main(String[] args) {
		int valor = fibonacci(4);
		System.out.println(valor);
	}

    public static int fibonacci(int n) {
        int resp;

        if (n == 0 || n == 1) {
            resp = 1;
        } else {
            resp = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return resp;
    }
}
