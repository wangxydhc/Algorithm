package sort;

public class SortLib {
	int[] a;

	public void initialize() {
//		a = new int[] { 3, 54, 2, 3, 23, 6, 4, 5, 3, 42, 64, -96, 32, 3, 4, 7,
//				34, -34, -36, 23, 3, 32, 4, 34 };
		a=new int[]{1,2,4,5,3,4,6,4,23,4,2,3,4,5,9,8,7,53,43,7,54,23,38,99};				
		
	}
	public void 
	
	public void countSort(){
		int max=99;
		int n=a.length;
		int []c=new int[max+1];
		int []res=new int[n];
		for(int i=0;i<n;i++){
			c[a[i]]++;			
		}		
		for(int i=1;i<max+1;i++){
			c[i]+=c[i-1];
		}		
		for(int i=0;i<n;i++){
			int value=a[i];
			int pos=c[a[i]];
			res[pos-1]=value;
			c[a[i]]--;
		}
	}
	//合并排序
	public void mergeSort(int[]a,int begin,int end){
		if (begin>=end)
			return;
		int mid=(begin+end)/2;
		mergeSort(a,begin,mid);
		mergeSort(a,mid+1,end);
		merge(a,begin,mid,end);		
	}
	public void merge(int []a,int begin,int mid,int end){  //这个写毁了，非常难以理解
		int len_left=mid-begin+1,len_right=end-mid;
		int midTemp=mid,endTemp=end,len_left_Temp=len_left,len_right_temp=len_right;
		int[]lA=new int[len_left+1];
		int[]rA=new int[len_right+1];
		while (len_left_Temp>0)
			lA[--len_left_Temp]=a[midTemp--];
		while (len_right_temp>0)
			rA[--len_right_temp]=a[endTemp--];
		lA[len_left]=Integer.MAX_VALUE;
		rA[len_right]=Integer.MAX_VALUE;
		int preIndex=0,indexLeft=0,indexRight=0;
		while(preIndex<len_left+len_right){
			if(lA[indexLeft]<rA[indexRight])
				a[preIndex+begin]=lA[indexLeft++];
			else
				a[preIndex+begin]=rA[indexRight++];
		preIndex++;
	
		}
	}
	//选择排序
	public void selectSort(){
		int min;
		for(int i=0;i<a.length;i++){
			min=i;
			int j;
			for(j=i;j<a.length;j++){
				if(a[j]<a[min])
					min=j;
			}
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
	}
	// 冒泡排序
	public void bubbleSort() {
		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			if (flag)
				return;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					flag = false;
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	// 冒泡排序递归版
	public void bubbleRecursion(int[] a) {
		findMinCount(a, a.length);
	}

	public void findMinCount(int[] a, int i) {
		int j = a.length - 1;
		if (i <= 0)
			return;
		findMinCount(a, i - 1);
		while (j - 1 >= i - 1) {
			if (a[j] < a[j - 1]) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
			j--;
		}

	}

	// 插入排序
	public void insertSort() {
		for (int i = 2; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				a[j--] = temp;
			}
		}
	}

	// 递归 插入排序
	public void insertRecurtion(int[] a, int begin, int end) {
		if (begin >= end)
			return;
		insertRecurtion(a, begin, end - 1);
		int temp = a[end];
		while (end - 1 >= 0 && temp < a[end - 1]) {
			a[end] = a[end - 1];
			a[end - 1] = temp;
			end--;
		}
	}

	public void print() {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println("---------------------------------------");
	}

	public static void main(String[] args) {
		System.out.println("test");
		SortLib sl = new SortLib();			

		System.out.println("insertSort");
		sl.initialize();
		sl.insertSort();
		sl.print();
		
		System.out.println("insertRecursion");
		sl.initialize();
		sl.insertRecurtion(sl.a, 0, sl.a.length - 1);
		sl.print();
		
		System.out.println("bubbleSort");
		sl.initialize();
		sl.bubbleSort();
		sl.print();
		
		System.out.println("bubbleRecursion");
		sl.initialize();
		sl.bubbleRecursion(sl.a);
		sl.print();
		
		System.out.println("selectSort");
		sl.initialize();
		sl.selectSort();
		sl.print();
		
		System.out.println("mergeSort");
		sl.initialize();
		sl.mergeSort(sl.a, 0, sl.a.length-1);
		sl.print();
		
		System.out.println("countSort");
		sl.initialize();
		sl.countSort();
		sl.print();
	}
}
