
import java.util.Random;
public class Main {

static int prob_value[];
static int fitness_value[] ;
static int arr[][][];
static String st[];
static String _st;
static int state ;
static int attacking_pair;
static int total_prob;

public static void check_1 (int i, int j , int k) {	
	if (k>7) {			
	}
	else {	
		if (arr[i][j][k] == 1) {				
			attacking_pair ++ ;
		} 		
		check_1 (i,j,k+1);
	}
	
} 

public static void check_2 (int i , int j , int k) {
	
		if (j<0 || j>7 || k<0 || k>7) {
		
		
		}
		else {
		
			if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
			check_2 (i,j+1,k+1);
		}
	
}

public static void check_3 (int i , int j , int k ) {
		
	
if (j<0 || j>7 || k<0 || k>7) {
		
		
	}
	else {
		
		if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
		check_3 (i,j+1,k);
	}
}

public static void check_4 (int i , int j , int k) {
		
	if (j<0 || j>7 || k<0 || k>7) {
		
		
	}
	else {
		
		if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
		check_4 (i,j+1,k-1);
	}
	
}

public static void check_5 (int i , int j , int k ) {
	
if (j<0 || j>7 || k<0 || k>7) {
		
		
	}
	else {
		
		if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
		check_5 (i,j,k-1);
	}
	
}
public static void check_6 (int i , int j , int k) {
	if (j<0 || j>7 || k<0 || k>7) {
		
		
	}
	else {
		
		if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
		check_6 (i,j-1,k-1);
	}
	
	
}
public static void check_7 (int i , int j , int k ) {
	
if (j<0 || j>7 || k<0 || k>7) {
		
		
	}
	else {
		
		if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
		check_7 (i,j-1,k);
	}
	
	
}
public static void check_8 (int i , int j , int k) {
if (j<0 || j>7 || k<0 || k>7) {
		
		
	}
	else {
		
		if (arr[i][j][k] == 1) {
				
			attacking_pair ++ ;
		} 
		
		check_8 (i,j-1,k+1);
	}
	
	
	
}
public static void check_all_8 (int i , int j , int k) {
	int a , b , c ;
	a = i ; b = j ; c = k ;
	check_1 (a,b,c+1);
	check_2 (a, b+1,c+1);
	check_3 (a,b+1,c);
	check_4 (a,b+1,c-1);
	check_5 (a,b,c-1);
	check_6 (a,b-1,c-1);
	check_7 (a,b-1,c);
	check_8 (a,b-1,c+1);
}

public static void fitness_function () {
	
	for (int i = 0 ; i<state ; i++) {
		attacking_pair = 0 ;
		for (int j = 0 ; j<8 ; j++) {
			for (int k = 0 ; k<8 ; k++) {
					
				if (arr[i][j][k]==1) {
					
					check_all_8(i,j,k);
					arr[i][j][k] = 2 ;
				}
				
			}
			
		}
		fitness_value[i] = 28 - attacking_pair;
	}
		
	
}

public static void sort_wrt_prob() {
	int[][] temp_arr = new int[8][8];
	String  temp_st;
	int temp_fitnes ;
	int temp_prob;
	
	
	
	
	for (int i = 0 ; i< state ; i++) {
		
		for (int j = 0 ; j<state-1 ; j++) {
			if ()
		}
	}
	
	
}

public static void main(String[] args) {
		// TODO Auto-generated method stub

	state = 4 ;
	fitness_value = new int[state]; 
	prob_value = new int[state] ;

		arr = new int[state][8][8];
		
		st = new String[state];
		for (int i = 0 ; i<state ; i++) {
			for (int j = 0 ; j<8 ; j++ ) {
				for (int k = 0 ; k<8 ; k++) {
						
					arr[i][j][k] = 0 ;				
				}
				
			}
			
		}
		
int rand ;
		String s ;
		for (int j = 0 ; j<state ; j++) {
			st[j] = "";

			for (int i = 0 ; i<8 ; i++) {
			
			rand = (int) (Math.random() * 8);
		
			arr[j][rand][i] = 1;
			s = Integer.toString(rand);
			st[j] = st[j] + s;
		
			}

		}
		
		
		
		
		fitness_function() ;
		
		
		total_prob = 0;
		int total=0 ;
		for (int i = 0 ; i<state ; i++ ) {			
			total = total + fitness_value[i];			
		}
		double x ;
		for (int i = 0 ; i < state ; i++) {
				x = (fitness_value[i] * 100)/total;
				prob_value[i]=(int)(Math.round(x));
				total_prob = total_prob + prob_value[i];
		}
		
		
		sort_wrt_prob() ;
		
		
		
for (int i = 0 ; i<state ; i++) {
			
			System.out.println("String ::"+st[i]);
			System.out.println("Fitness ::"+fitness_value[i]);
			System.out.println("Porbility ::" + prob_value[i]);
			for (int j = 0 ; j<8 ; j++ ) {
				for (int k = 0 ; k<8 ; k++) {
					if (arr[i][j][k] != 0) {
						arr[i][j][k]=1;
					}
						
					System.out.print(arr[i][j][k] + " ");
					
				}
				System.out.print("\n");
				
			}
			
			System.out.println("\n\n\n");
		}



System.out.println("Total value :: " + total_prob);
		
	}


}
