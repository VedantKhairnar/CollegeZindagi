import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DVR {
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v;
    static int e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the number of Vertices: ");
        v = Integer.parseInt(br.readLine());

        System.out.println("Please enter the number of Edges: ");
        e = Integer.parseInt(br.readLine());

        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 9999;
            }

        for (int i = 0; i < e; i++) {
            System.out.println("Please enter data for Edge " + (i + 1) + ":");
            System.out.print("Source: ");
            int s = Integer.parseInt(br.readLine());
            s--;
            System.out.print("Destination: ");
            int d = Integer.parseInt(br.readLine());
            d--;
            System.out.print("Cost: ");
            int c = Integer.parseInt(br.readLine());
            graph[s][d] = c;
            graph[d][s] = c;
        }

        dvr_calc_disp("The initial Routing Tables are: ");

        System.out.print("Please enter the Source Node for the edge whose cost has changed: ");
        int s = Integer.parseInt(br.readLine());
        s--;
        System.out.print("Please enter the Destination Node for the edge whose cost has changed: ");
        int d = Integer.parseInt(br.readLine());
        d--;
        System.out.print("Please enter the new cost: ");
        int c = Integer.parseInt(br.readLine());
        graph[s][d] = c;
        graph[d][s] = c;

        dvr_calc_disp("The new Routing Tables are: ");
    }

    static void dvr_calc_disp(String message) {
        System.out.println();
        init_tables();
        update_tables();
        System.out.println(message);
        print_tables();
        System.out.println();
    }

    static void update_table(int source) {
        for (int i = 0; i < v; i++) {
            if (graph[source][i] != 9999) {
                int dist = graph[source][i];
                for (int j = 0; j < v; j++) {
                    int inter_dist = rt[i][j];
                    if (via[i][j] == source)
                        inter_dist = 9999;
                    if (dist + inter_dist < rt[source][j]) {
                        rt[source][j] = dist + inter_dist;
                        via[source][j] = i;
                    }
                }
            }
        }
    }

    static void update_tables() {
        int k = 0;
        for (int i = 0; i < 4 * v; i++) {
            update_table(k);
            k++;
            if (k == v)
                k = 0;
        }
    }

    static void init_tables() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j) {
                    rt[i][j] = 0;
                    via[i][j] = i;
                } else {
                    rt[i][j] = 9999;
                    via[i][j] = 100;
                }
            }
        }
    }

    static void print_tables() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print("Dist: " + rt[i][j] + "    ");
            }
            System.out.println();
        }
    }

}



/*

import xlrd

x = [8, 7, 4, 13, 17, 9, 3, 12, 10, 14, 6, 17]
list=[]
wb = xlrd.open_workbook(r'input.xlsx')
data = wb.sheet_by_index(0)
graph = wb.sheet_by_index(1)
router = input("Enter router:")
for i in range(1, 13):
    if data.cell_value(i, 0) == router:
        index = i

for i in range(1, data.nrows):
    min = 999
    for j in range(1, data.ncols):
        if data.cell_value(i,j)+x[j-1]<min and graph.cell_value(index,j)==1:
            min=data.cell_value(i,j)+x[j-1]
            insert=[data.cell_value(i,0),min,data.cell_value(0,j)]
            if data.cell_value(i,0)==router:
                insert =[data.cell_value(i, 0), '-', '-']
    list.append(insert)
print(*list,sep="\n")




*/


/*


package cnprac7b;

import java.util.Random;
import java.util.Scanner;

public class Cnprac7b {

    public static void main(String[] args) {
        
        int node;
        
        Random rand=new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of nodes");
        node=sc.nextInt();
        int[][] dv=new int[node][node];
        int[][] table=new int[node][2];
        int[][] graph=new int[node][node];
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                graph[i][j]=rand.nextInt(2);
            }
        }
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                System.out.print(graph[i][j]+"\t");
            }
            System.out.println("");
        }
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                if(i==j){
                    dv[i][j]=0;
                }
                else{
                    dv[i][j]=rand.nextInt(9)+1;
                }
            }
            
        }
        System.out.println("distance matrix::");
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                System.out.print(dv[i][j]+"\t");
            }
            System.out.println("");
            
        }
        System.out.println("enter the node from the graph");
        int[] cost=new int[node];
        int a =sc.nextInt();
        for(int i=0;i<node;i++){
            if(graph[a][i]==1){
                cost[i]=rand.nextInt(5);
            }
        }
        System.out.println("neighbour Matrix::");
        for(int i=0;i<node;i++){
            System.out.print(cost[i]+"\t");
        }
        System.out.println("");
        int min=999;
        int inter=0,line = 999;
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                
                if(cost[j]!=0){
                    inter=cost[j]+dv[i][j];
                    if(inter<min){
                        min=inter;
                        line=j;
                    }
                }
            }
            table[i][0]=min;
            table[i][1]=line;
            min=999;
            line=999;
        }
        table[a][0]=99;
        table[a][1]=99;
        System.out.println("your distance vector table is::");
        System.out.println("ROUTER   DISTANCE   LINE");
        for(int i=0;i<node;i++){
            System.out.println(i+"    |   "+table[i][0]+"      |   "+table[i][1]);
        }

   }
}
Output
enter the number of nodes
5
0	1	0	1	0	
0	1	0	1	1	
1	1	0	0	1	
0	1	1	0	1	
0	1	1	1	0	
distance matrix::
0	8	6	4	7	
9	0	3	7	6	
1	9	0	5	3	
2	1	9	0	7	
5	6	7	6	0	
enter the node from the graph
3
neighbour Matrix::
0	1	2	0	4	
your distance vector table is::
ROUTER   DISTANCE   LINE
0    |   8      |   2
1    |   1      |   1
2    |   2      |   2
3    |   99      |   99
4    |   4      |   4
BUILD SUCCESSFUL (total time: 13 seconds)

*/