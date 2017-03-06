//Q1: Sorted Merge
public int sort_merge(int[] A, int[] B){
	int i = A.length-1;
	int j = B.length-1;
	int m = A.length + B.length-1;
	while(i>0 && j>0){
		if(A[i]>=B[j]){
             A[--m]=A[i];
             i--;
		}
		else{A[--m] = B[j];
			j--;}
	}
	while(j>=0){
		A[--m]=B[j];
	}l;
}



