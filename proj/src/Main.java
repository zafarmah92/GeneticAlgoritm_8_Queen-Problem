
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
static int comulative_prob[];
static boolean  one , two ;
static String st_one_tr , st_two_tr;
static int one_tr[][] , two_tr[][] ; 

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
// determine the fitness of the chess board
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


//function for the sort wrt probility
public static void sort_wrt_prob() {
	int[][] temp_arr = new int[8][8];
	String  temp_st;
	int temp_fitnes ;
	int temp_prob;
	
	
	
	
	for (int i = 0 ; i< state ; i++) {
		
		for (int j = 0 ; j<state-1 ; j++) {
			
			if (prob_value[j] < prob_value[j+1] ) {
				// prob value change 
				temp_prob = prob_value[j+1] ;
				prob_value[j+1]= prob_value[j];
				prob_value[j] = temp_prob;
				
				//string change
				temp_st = st[j+1];
				st[j+1] = st[j];
				st[j] =temp_st;
				
				//fitness change 
				temp_fitnes = fitness_value[j+1];
				fitness_value[j+1] = fitness_value[j];
				fitness_value[j]= temp_fitnes ;
				
				//chess board change				
				for (int k = 0 ; k<8 ;k++) {
					for (int m = 0 ; m<8 ; m++) {
							temp_arr[k][m] = arr[j+1][k][m];
							arr[j+1][k][m] = arr[j][k][m];
							arr[j][k][m] = temp_arr[k][m];
					}
				}
			} 
		}
	}
	
	
}

//function for cross over of  pair one and pair two 
public static void cross_over (int pair_1 , int pair_2) {

	int rand_value ;
	int[] tmp_arr = new int[8];
	char t1 ;
	char[] temp_st1 = st[pair_1].toCharArray(); // two char array because strings are immutable in java 
	char[] temp_st2 = st[pair_2].toCharArray();
	
	rand_value = (int)(Math.random()*7);
	
//	for (int i = rand_value+1 ; i<8 ; i++) {
		//chaging string
	//	temp_st = st[pair_1].charAt(i) ;
	//	st[pair_1].s
		
//	}
	
//	System.out.println("Rand value for cross over ::" + rand_value);
	for (int i = rand_value+1 ; i<8 ; i++) {
	
		//changing of array in the // i is column
		for (int j = 0 ; j<8 ; j++) {
			tmp_arr[j]=arr[pair_1][j][i]; 
		}
		
		for (int j = 0 ; j<8 ; j++) {
			arr[pair_1][j][i] = arr[pair_2][j][i];
		}
		
		for (int j=0 ; j<8 ; j++) {
			arr[pair_2][j][i] = tmp_arr[j];
		}
		
		t1 = temp_st1[i];
		temp_st1[i] = temp_st2[i] ;
		temp_st2[i] = t1 ; 
	
	}
	
	st[pair_1] = String.valueOf(temp_st1);
	st[pair_2] = String.valueOf(temp_st2);
	
}


public static void mutate_ideal (int pair) {

	int r1 , r2  , m; 
	char[] tmp;
	m = (int)(Math.random()*100);
	if (m <= 50) {
		r1 = (int)(Math.random()*8); //index of array
		r2 = (int)(Math.random()*8); // location of array
		tmp = st[pair].toCharArray();
		tmp[r1] = (char)('0' +r2);
		st[pair] = String.valueOf(tmp);
		
		for (int i = 0 ; i<8 ; i++) {
			arr[pair][i][r1] = 0 ;
		}
		
		arr[pair][r2][r1] = 1 ;
	}
	
}
 
public static void random_select_and_crossover(){
	//for the selection of pair , loop of two iteration is chosen , first iteration of 1st pair , second iteration for 2nd pair
	int x = total_prob + 1 ;
	int a , b  , pair_1 = 0 , pair_2 = 0;
	one = false ; two = false ;
	for (int i = 0 ; i<2; i++) {
			
		a = (int)(Math.random()*x);
		b = (int)(Math.random()*x);
		
		for (int j = 0 ; j<state ; j++) {
			
			if (j == 0 ) {
				if (a <= comulative_prob[j]) {
				pair_1 = j ;	
				}
				if (b <= comulative_prob[j]) {
					pair_2 = j ;
				}
			}
			else {
				
				if (a > comulative_prob[j-1] && a <= comulative_prob[j]) {
					pair_1 = j ;
				}
				if (b > comulative_prob[j-1] && b <= comulative_prob[j]) {
					pair_2 = j ;
				}
				
			}
		}//end of loop
//		System.out.println(pair_1 + "   "+pair_2);

		//if we have an identical case	
		if(pair_1 == pair_2) {
			//mutate_ideal (pair_1);
		}
		else {
			cross_over(pair_1 , pair_2);
			
		}
		
	}//end if 2 iteration 
}

static void mutation () {
	
	int r1 , r2  , m; 
	char[] tmp;
	for (int i = 0 ; i<state ; i++) {
		m = (int)(Math.random()*100);
		if (m <=50) {
			r1 = (int)(Math.random()*8); //index of array
			r2 = (int)(Math.random()*8); // location of array
			
			tmp = st[i].toCharArray();
			tmp[r1] = (char)('0'+r2);
			st[i] = String.valueOf(tmp);
			
			for (int j = 0 ; j<8 ; j++) {
				arr[i][j][r1] = 0;
			}
			arr[i][r2][r1] = 1;
			
		}
	}
}
public static void main(String[] args) {
		// TODO Auto-generated method stub

	state = 5 ;
	comulative_prob = new int[state];
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
		//setting random values over chess board
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
		
		
	int fit_value =0 ,loop = 0;	;
	
	while (true) {
	
		fitness_function() ;
		//returning backing to orignal chess boad by setting value to 1
		for (int i = 0 ; i<state ; i++) {
			for (int j = 0 ; j<8 ; j++) {
				for (int k = 0 ; k<8 ; k++) {
					if (arr[i][j][k] !=0 ) {
						arr[i][j][k] = 1;
					}
				}
			}
		}
		
		//checking maximum fitness
		for (int i = 0 ; i<state ; i++) {
			if (fitness_value[i]>fit_value ) {
				fit_value = fitness_value[i] ;
			}
			
		}
		
		if (fit_value == 28) {
			break;
		}
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
		
	//calculating commulative probility	
		for (int i = 0 ; i<state ; i++) {				
			if (i == 0 ) {
				comulative_prob[i] = prob_value[i];
			}
			else {
				comulative_prob[i] = comulative_prob[i-1] + prob_value[i];
			}
		}
		
		
		random_select_and_crossover () ;
		
	


		mutation() ;

		loop++;
	}
				

	for (int i = 0 ; i<state ; i++) {
		
		System.out.println("String ::"+st[i]);
		System.out.println("Fitness ::"+fitness_value[i]);
		System.out.println("Porbility ::" + prob_value[i]);
		System.out.println("Cumlative ::" + comulative_prob[i]);
		for (int j = 0 ; j<8 ; j++ ) {
			for (int k = 0 ; k<8 ; k++) {
				
					
				System.out.print(arr[i][j][k] + " ");
				
			}
			System.out.print("\n");
			
		}
		
		System.out.println("\n\n\n");
	}

System.out.println("fit_value " + fit_value + "   Loop ::" + loop );
		
	}


}
