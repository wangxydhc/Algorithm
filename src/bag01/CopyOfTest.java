package bag01;

import java.util.concurrent.TimeUnit;

public class CopyOfTest {
	int[] weight = new int[] { 0, 5, 4,4,6,2,9,8,5,2,3,7,9,7,3,2,12,12,3,6,4,3,7, 2, 6 };
	int[] value = new int[] { 0, 12,8,9,15,4,6,3,10,24,33,2,3,4,5,2,3,5,3,2,3,5,6, 3, 6 };
	int n = weight.length-15;
	int m=value.length-15;
	int limit = 15;
	int[][] res = new int[n + 1][limit + 1];
	public void initialize(){
		for(int i=1;i<=n;i++)
			for(int j=0;j<=limit;j++)
				res[i][j]=-1;
	}
	public int method2(int i, int j) {
		if (res[i][j] == -1) {
			if (j - weight[i] >= 0)
				res[i][j] = Math.max(method2(i - 1, j),
						method2(i - 1, j - weight[i]) + value[i]);
			else
				res[i][j] = method2(i - 1, j);
//			System.out.print(res[i][j]+" ");
			return res[i][j];
		}
		else
			return res[i][j];
	}

	public void printRes() {
		System.out.print("                        背包容量           ");
		for (int i = 0; i <= limit; i++)
			System.out.printf("%4d", i);
		System.out.println();
		System.out.print("   物品数量");
		for (int i = n; i >= 1; i--) {
			System.out.println();
			System.out.printf(" " + "%2d个物品                             ",i);
			for (int j = 0; j <= limit; j++) {
				System.out.printf("%4d", res[i][j]);
			}
		}
	}

	public void method1(int m,int n) {
		for (int i = 1; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				if (j - weight[i] >= 0)
					res[i][j] = Math.max(res[i - 1][j], res[i - 1][j
							- weight[i]]
							+ value[i]);
				else
					res[i][j] = res[i - 1][j];
			}
	}

	public static void main(String[] args) {
		
		CopyOfTest t = new CopyOfTest();	
		t.method1(t.n,t.limit);
		t.printRes();
//		t.initialize();
//		t.method2(t.n, t.limit);
//		t.printRes();
	
	}
}
