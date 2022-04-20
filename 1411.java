import java.util.Scanner;
import java.util.ArrayList;
public class Main{
	public static void main(String[] args){
		final int mod = 1000000007;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		long[][] result = new long[n][2];
		//0 abc
		//1 aba

		for(int i = 0; i < 3; i ++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(i != j && j != k && i == k){
						result[0][1] +=1;
					}else if(i != j && j != k && i != k){
						result[0][0] +=1;
					}
				}
			}
		}
		for(int i = 1; i < n; i++){
			result[i][0] = (2 * result[i - 1][1])%mod + (3 * result[i - 1][0])%mod;
			result[i][0] %= mod;
			result[i][1] = (2 * result[i - 1][1])%mod + (2 *result[i - 1][0])%mod;
			result[i][1] %= mod;
		}

		System.out.println((result[n - 1][0] + result[n - 1][1]) % mod);
	}
}

