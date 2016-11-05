
public class TestExit {
	public static void main(String[] args) {
		try {
			System.exit(0);
		} catch (Exception e) {
			System.out.println("catch");
		}finally {
			System.out.println("finally");
		}
	}
}
