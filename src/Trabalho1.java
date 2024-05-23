import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Trabalho1 {

	//PROCEDIMENTOS E MÉTODOS UTILIZADOS NA PARTE 1 DO TRABALHO
	
	//Procedimento que reverte o vetor para a sua forma original do arquivo nomes.txt:
	public static void vetorOriginal(String[] vetor, String[] copia, int n) {		
		for(int i = 0; i < n; i++) {
        	vetor[i] = copia[i];
        }
	}
	
	//Bubblesort crescente de nomes:
	public static void bubblesortStringsCresc(String[] vet, int n){
        String temp;
        for (int j = 0; j < n - 1; j++){
            for (int i = j + 1; i < n; i++){
                if (vet[j].compareTo(vet[i]) > 0){
                    temp = vet[j];
                    vet[j] = vet[i];
                    vet[i] = temp;
                }
            }
        }
    }
	
	//Bubblesort decrescente de nomes:
	public static void bubblesortStringsDecresc(String[] vet, int n){
        String temp;
        for (int j = 0; j < n - 1; j++){
            for (int i = j + 1; i < n; i++){
                if (vet[i].compareTo(vet[j]) > 0){
                    temp = vet[j];
                    vet[j] = vet[i];
                    vet[i] = temp;
                }
            }
        }
    }
	
	//Selectionsort crescente de strings:
	public static void selectionSortStringsCresc(String vet[],int n){
	    for(int i = 0; i < n - 1; i++){
	     
	        int min_indice = i;
	        String minString = vet[i];
	        for(int j = i + 1; j < n; j++){
	             	         
	            if(vet[j].compareTo(minString) < 0){
	                minString = vet[j];
	                min_indice = j;
	            }
	        }
	 
		    if(min_indice != i){
		        String temp = vet[min_indice];
		        vet[min_indice] = vet[i];
		        vet[i] = temp;
		    }
	    }
	}
	
	//Selectionsort decrescente de strings:
	public static void selectionSortStringsDecresc(String vet[],int n){
	    for(int i = 0; i < n - 1; i++){
	     
	        int min_indice = i;
	        String minString = vet[i];
	        for(int j = i + 1; j < n; j++){
	             	         
	            if(vet[j].compareTo(minString) > 0){
	                minString = vet[j];
	                min_indice = j;
	            }
	        }
	 
		    if(min_indice != i){
		        String temp = vet[min_indice];
		        vet[min_indice] = vet[i];
		        vet[i] = temp;
		    }
	    }
	}
	
	//Insertionsort crescente de strings:
	public static void insertionSortStringsCresc(String vet[], int n) {
		for(int i = 1; i < n; i++) {
			String tmp = vet[i];
			int j = i - 1;
			
			while((j >= 0) && ((vet[j].toUpperCase()).compareTo(tmp) > 0)) {
				vet[j + 1] = vet[j];
				j--;
			}
			vet[j + 1] = tmp;
		}
	}
	
	//Insertionsort decrescente de strings:
	public static void insertionSortStringsDecresc(String vet[], int n) {
		for(int i = 1; i < n; i++) {
			String tmp = vet[i];
			int j = i - 1;
			
			while((j >= 0) && ((vet[j].toUpperCase()).compareTo(tmp) < 0)) {
				vet[j + 1] = vet[j];
				j--;
			}
			vet[j + 1] = tmp;
		}
	}
	
	//Heapsort crescente de strings:
	public static void heapsortStringsCresc(String vet[]){
        int N = vet.length;
 
        for (int i = N / 2 - 1; i >= 0; i--)
            heapifyStringsCresc(vet, N, i);
 
        for (int i = N - 1; i > 0; i--) {
            String temp = vet[0];
            vet[0] = vet[i];
            vet[i] = temp;
 
            heapifyStringsCresc(vet, i, 0);
        }
    }
	
	//Heapify para heapsort crescente de strings:
	public static void heapifyStringsCresc(String vet[], int N, int i){
        int maior = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        if (l < N && (vet[l].toUpperCase()).compareTo(vet[maior].toUpperCase()) > 0)
            maior = l;
 
        if (r < N && (vet[r].toUpperCase()).compareTo(vet[maior].toUpperCase()) > 0)
            maior = r;
 
        if (maior != i) {
            String swap = vet[i];
            vet[i] = vet[maior];
            vet[maior] = swap;
 
            heapifyStringsCresc(vet, N, maior);
        }
    }
	
	//Heapsort decrescente de strings:
	public static void heapsortStringsDecresc(String vet[]){
        int N = vet.length;
 
        for (int i = N / 2 - 1; i >= 0; i--)
            heapifyStringsDecresc(vet, N, i);
 
        for (int i = N - 1; i > 0; i--) {
            String temp = vet[0];
            vet[0] = vet[i];
            vet[i] = temp;
 
            heapifyStringsDecresc(vet, i, 0);
        }
    }
	
	//Heapify para heapsort crescente de strings:
	public static void heapifyStringsDecresc(String vet[], int N, int i){
        int menor = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        if (l < N && (vet[l].toUpperCase()).compareTo(vet[menor].toUpperCase()) < 0)
            menor = l;
 
        if (r < N && (vet[r].toUpperCase()).compareTo(vet[menor].toUpperCase()) < 0)
            menor = r;
 
        if (menor != i) {
            String swap = vet[i];
            vet[i] = vet[menor];
            vet[menor] = swap;
 
            heapifyStringsDecresc(vet, N, menor);
        }
    }
	
	//Procedimento utilizado para a comparação do mergesort de strings crescente:
	static void mergeStrCresc(String vet[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        String L[] = new String[n1];
        String R[] = new String[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = vet[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = vet[m + 1 + j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if ((L[i].toUpperCase()).compareTo(R[j].toUpperCase()) <= 0) {
                vet[k] = L[i];
                i++;
            }
            else {
                vet[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            vet[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            vet[k] = R[j];
            j++;
            k++;
        }
    }
	
	//Mergesort de strings crescente:
    public static void mergesortStrCresc(String vet[], int l, int r){
        if (l < r) {
            int m = l + (r - l) / 2;
 
            mergesortStrCresc(vet, l, m);
            mergesortStrCresc(vet, m + 1, r);
 
            mergeStrCresc(vet, l, m, r);
        }
    }
    
    //Procedimento utilizado para a comparação do mergesort de strings decrescente:
  	static void mergeStrDecresc(String vet[], int l, int m, int r){
          int n1 = m - l + 1;
          int n2 = r - m;
   
          String L[] = new String[n1];
          String R[] = new String[n2];
   
          for (int i = 0; i < n1; ++i)
              L[i] = vet[l + i];
          for (int j = 0; j < n2; ++j)
              R[j] = vet[m + 1 + j];
   
          int i = 0, j = 0;
   
          int k = l;
          while (i < n1 && j < n2) {
              if ((L[i].toUpperCase()).compareTo(R[j].toUpperCase()) >= 0) {
                  vet[k] = L[i];
                  i++;
              }
              else {
                  vet[k] = R[j];
                  j++;
              }
              k++;
          }
   
          while (i < n1) {
              vet[k] = L[i];
              i++;
              k++;
          }
   
          while (j < n2) {
              vet[k] = R[j];
              j++;
              k++;
          }
  	}
  	
  	//Mergesort de strings decrescente:
    public static void mergesortStrDecresc(String vet[], int l, int r){
    	if (l < r) {
    		int m = l + (r - l) / 2;
   
    		mergesortStrDecresc(vet, l, m);
            mergesortStrDecresc(vet, m + 1, r);
   
            mergeStrDecresc(vet, l, m, r);
        }
    }
    
    //Procedimento para trocar o valor de duas posições de um array:
  	public static void swap(String[] vet, int i, int j){
          String temp = vet[i];
          vet[i] = vet[j];
          vet[j] = temp;
    }
  	
  	//Determinação das trocas em relação ao pivô do quicksort de strings crescente:
  	public static int partitionCresc(String[] vet, int menor, int maior){
    
          String pivot = vet[maior];
    
          int i = (menor - 1);
    
          for (int j = menor; j <= maior - 1; j++) {
    
              if ((vet[j].toUpperCase()).compareTo(pivot.toUpperCase()) < 0) {
    
                  i++;
                  swap(vet, i, j);
              }
          }
          swap(vet, i + 1, maior);
          return (i + 1);
    }
  	
  	//Procedimento que realiza o quicksort de strings crescente:
  	public static void quickSortStringCresc(String[] vet, int menor, int maior){
          if (menor < maior) {
    
              int pi = partitionCresc(vet, menor, maior);
    
              quickSortStringCresc(vet, menor, pi - 1);
              quickSortStringCresc(vet, pi + 1, maior);
          }
    }
  	
  //Determinação das trocas em relação ao pivô do quicksort de strings decrescente:
  	public static int partitionDecresc(String[] vet, int menor, int maior){
    
          String pivot = vet[maior];
    
          int i = (menor - 1);
    
          for (int j = menor; j <= maior - 1; j++) {
    
              if ((vet[j].toUpperCase()).compareTo(pivot.toUpperCase()) > 0) {
    
                  i++;
                  swap(vet, i, j);
              }
          }
          swap(vet, i + 1, maior);
          return (i + 1);
    }
  	
  	//Procedimento que realiza o quicksort de strings decrescente:
  	public static void quickSortStringDecresc(String[] vet, int menor, int maior){
          if (menor < maior) {
    
              int pi = partitionDecresc(vet, menor, maior);
    
              quickSortStringDecresc(vet, menor, pi - 1);
              quickSortStringDecresc(vet, pi + 1, maior);
          }
    }
	
  	//PROCEDIMENTOS E MÉTODOS UTILIZADOS NA SEGUNDA PARTE DO TRABALHO:
  	
  	//Procedimento que copia um vetor de inteiros:
  	public static void vetorCopia(int[] vetor, int[] copia, int n) {		
  		for(int i = 0; i < n; i++) {
          	vetor[i] = copia[i];
        }
  	}
  	
  	//Função para gerar números inteiros aleatórios:
  	public static int[] aleatorio(int tam) {
  		
  		Random r = new Random();
  		
  		int vetor[] = new int[tam];
  		
  		int min = 0, max = 10;
  		
  		for(int i = 0; i < tam; i++) {
  			vetor[i] = r.nextInt((max - min) + min);
  			
  		}  		
  		
  		return vetor;
  	}
  	
  	//Bubblesort crescente de inteiros:
  	public static void bubblesortInt(int[] vet, int n){
  		
  		int tmp;
  		
  		for(int i = (n - 1); i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(vet[j] > vet[j + 1]) {
					tmp = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = tmp;
				}
			}
		}
     }
  	
  	//Selectionsort crescente de inteiros:
  	public static void selectionsortInt(int vet[], int n) {
  		for(int i = 0; i < (n - 1); i++) {
			int menor = i;
			for(int j = (i + 1); j < n; j++) {
				if(vet[menor] > vet[j]) {
					menor = j;
				}
			}
			if(i != menor) {
				int aux = vet[menor];
				vet[menor] = vet[i];
				vet[i] = aux;
			}
		}
  	}
  	
  	//Insertionsort crescente de inteiros:
  	public static void insertionsortInt(int vet[], int n) { 		
  		for(int i = 1; i < n; i++) {
			int tmp = vet[i];
			int j = i - 1;
			
			while((j >= 0) && (vet[j] > tmp)) {
				vet[j + 1] = vet[j];
				j--;
			}
			vet[j + 1] = tmp;
		}
  	}
  	
  	//Heapsort crescente de inteiros:
  	public static void heapsortInt(int vet[]){
          int N = vet.length;
   
          for (int i = N / 2 - 1; i >= 0; i--)
              heapifyInt(vet, N, i);
   
          for (int i = N - 1; i > 0; i--) {
              int temp = vet[0];
              vet[0] = vet[i];
              vet[i] = temp;
   
              heapifyInt(vet, i, 0);
          }
      }
  	
  	//Heapify para heapsort crescente de inteiros:
  	public static void heapifyInt(int vet[], int N, int i){
          int maior = i; 
          int l = 2 * i + 1; 
          int r = 2 * i + 2; 
   
          if (l < N && vet[l] > vet[maior])
              maior = l;
   
          if (r < N && vet[r] > vet[maior])
              maior = r;
   
          if (maior != i) {
              int swap = vet[i];
              vet[i] = vet[maior];
              vet[maior] = swap;
   
              heapifyInt(vet, N, maior);
          }
      }
  	
  	//Procedimento utilizado para a comparação do mergesort de inteiros crescente:
  	static void mergeInt(int vet[], int l, int m, int r){
          int n1 = m - l + 1;
          int n2 = r - m;
   
          int L[] = new int[n1];
          int R[] = new int[n2];
   
          for (int i = 0; i < n1; ++i)
              L[i] = vet[l + i];
          for (int j = 0; j < n2; ++j)
              R[j] = vet[m + 1 + j];
   
          int i = 0, j = 0;
   
          int k = l;
          while (i < n1 && j < n2) {
              if (L[i] <= R[j]) {
                  vet[k] = L[i];
                  i++;
              }
              else {
                  vet[k] = R[j];
                  j++;
              }
              k++;
          }
   
          while (i < n1) {
              vet[k] = L[i];
              i++;
              k++;
          }
   
          while (j < n2) {
              vet[k] = R[j];
              j++;
              k++;
          }
      }
  	
  	//Mergesort de inteiros crescente:
      public static void mergesortInt(int vet[], int l, int r){
          if (l < r) {
              int m = l + (r - l) / 2;
   
              mergesortInt(vet, l, m);
              mergesortInt(vet, m + 1, r);
   
              mergeInt(vet, l, m, r);
          }
      }	
    
      //Procedimento para trocar o valor de duas posições de um array:
      public static void swapInt(int[] vet, int i, int j){
            int temp = vet[i];
            vet[i] = vet[j];
            vet[j] = temp;
      }
    	
      //Determinação das trocas em relação ao pivô do quicksort de inteiros crescente:
      public static int partitionInt(int[] vet, int menor, int maior){
      
            int pivot = vet[maior];
      
            int i = (menor - 1);
      
            for (int j = menor; j <= maior - 1; j++) {
      
                if (vet[j] < pivot) {
      
                    i++;
                    swapInt(vet, i, j);
                }
            }
            swapInt(vet, i + 1, maior);
            return (i + 1);
      }
    	
      //Procedimento que realiza o quicksort de inteiros crescente:
      public static void quickSortInt(int[] vet, int menor, int maior){
            if (menor < maior) {
      
                int pi = partitionInt(vet, menor, maior);
      
                quickSortInt(vet, menor, pi - 1);
                quickSortInt(vet, pi + 1, maior);
            }
      }
      
      //Countingsort crescente:
      public static void countingSort(int[] vet){
          
    	  int max = Arrays.stream(vet).max().getAsInt();
          int min = Arrays.stream(vet).min().getAsInt();
          int tamanho = max - min + 1;
          int cont[] = new int[tamanho];
          int output[] = new int[vet.length];
          for (int i = 0; i < vet.length; i++) {
              cont[vet[i] - min]++;
          }
    
          for (int i = 1; i < cont.length; i++) {
              cont[i] += cont[i - 1];
          }
    
          for (int i = vet.length - 1; i >= 0; i--) {
              output[cont[vet[i] - min] - 1] = vet[i];
              cont[vet[i] - min]--;
          }
    
          for (int i = 0; i < vet.length; i++) {
              vet[i] = output[i];
          }
      }
  	
  	
  	//Função principal do programa:
	public static void main(String[] args) throws IOException {
		
		//PARTE 1 DO TRABALHO:
		
		File arq = new File("nomes.txt");
		
		FileReader arq2 = new FileReader(arq);

        BufferedReader leitor = new BufferedReader(arq2);

        String linha;
        
        //Número de linhas do arquivo:
        int contador = 0;

        try {

          Scanner sc = new Scanner(arq);

          while(sc.hasNextLine()) {
            sc.nextLine();
            contador++;
          }
          System.out.println("Número de linhas: " + contador);

          sc.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        
        int n = contador;
        
        String vetor[] = new String[n];
        String copia[] = new String[n];
        
        for(int i = 0; i < n; i++) {
        		        		        	
        	linha = leitor.readLine();
        	vetor[i] = linha;  	
        }
        System.out.println("PARTE 1: ordenação de nomes");
        System.out.println("Vetor original:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		}
        
        for(int i = 0; i < n; i++) {
        	copia[i] = vetor[i];
        }
        
        leitor.close();
        
        bubblesortStringsCresc(vetor, n);
        
        System.out.println("BUBBLESORT CRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		}
        vetorOriginal(vetor, copia, n);
        
        bubblesortStringsDecresc(vetor, n);
        
        System.out.println("BUBBLESORT DECRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		}
        vetorOriginal(vetor, copia, n);
        
        selectionSortStringsCresc(vetor, n);
        
        System.out.println("SELECTIONSORT CRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		}        
        vetorOriginal(vetor, copia, n);
        
        selectionSortStringsDecresc(vetor, n);
        
        System.out.println("SELECTIONSORT DECRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		}
        vetorOriginal(vetor, copia, n);
        
        insertionSortStringsCresc(vetor, n);
        
        System.out.println("INSERTIONSORT CRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        insertionSortStringsDecresc(vetor, n);
        
        System.out.println("INSERTIONSORT DECRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        heapsortStringsCresc(vetor);
        System.out.println("HEAPSORT CRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        heapsortStringsDecresc(vetor);
        System.out.println("HEAPSORT DECRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        mergesortStrCresc(vetor, 0, n - 1);
        System.out.println("MERGESORT CRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        mergesortStrDecresc(vetor, 0, n - 1);
        System.out.println("MERGESORT DECRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        quickSortStringCresc(vetor, 0, n - 1);
        System.out.println("QUICKSORT CRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        quickSortStringDecresc(vetor, 0, n - 1);
        System.out.println("QUICKSORT DECRESCENTE:");
        for(int j = 0; j < n; j++) {
        	System.out.println(vetor[j]);
		} 
        vetorOriginal(vetor, copia, n);
        
        //PARTE 2 DO TRABALHO:
        
        System.out.println("PARTE 2: ordenação de números");        
         
        int vetCresc1[] = new int[1000];
        int vetCresc2[] = new int[10000];
        int vetCresc3[] = new int[100000];
        int vetCresc4[] = new int[1000000];
        
        int vetDecresc1[] = new int[1000];
        int copDecresc1[] = new int[1000];
        int vetDecresc2[] = new int[10000];
        int copDecresc2[] = new int[10000];
        int vetDecresc3[] = new int[100000];
        int copDecresc3[] = new int[100000];
        int vetDecresc4[] = new int[1000000];
        int copDecresc4[] = new int[1000000];
        
        int vetRand1[] = new int[1000];
        int copRand1[] = new int[1000];
        int vetRand2[] = new int[10000];
        int copRand2[] = new int[10000];
        int vetRand3[] = new int[100000];
        int copRand3[] = new int[100000];
        int vetRand4[] = new int[1000000];
        int copRand4[] = new int[1000000];
        
        //VETORES DE 1000 POSIÇÕES:
        
        for(int i = 0; i < 1000; i++) {
        	vetCresc1[i] = i;
        }
        
        long iniciovetCresc1 = System.currentTimeMillis();
        bubblesortInt(vetCresc1, 1000);
        System.out.println("Bubblesort[1000] crescente: " + (System.currentTimeMillis() - iniciovetCresc1)*1000d + " microssegundos");
        
        long iniciovetSelCresc1 = System.currentTimeMillis();
        selectionsortInt(vetCresc1, 1000);
        System.out.println("Selectionsort[1000] crescente: " + (System.currentTimeMillis() - iniciovetSelCresc1)*1000d + " microssegundos");
        
        long iniciovetInsCresc1 = System.currentTimeMillis();
        insertionsortInt(vetCresc1, 1000);
        System.out.println("Insertionsort[1000] crescente: " + (System.currentTimeMillis() - iniciovetInsCresc1)*1000d + " microssegundos");
        
        long iniciovetHeapCresc1 = System.currentTimeMillis();
        heapsortInt(vetCresc1);
        System.out.println("Heapsort[1000] crescente: " + (System.currentTimeMillis() - iniciovetHeapCresc1)*1000d + " microssegundos");
        
        long iniciovetMergeCresc1 = System.currentTimeMillis();
        mergesortInt(vetCresc1, 0, 999);
        System.out.println("Mergesort[1000] crescente: " + (System.currentTimeMillis() - iniciovetMergeCresc1)*1000d + " microssegundos");
        
        long iniciovetQuickCresc1 = System.currentTimeMillis();
        quickSortInt(vetCresc1, 0, 999);
        System.out.println("Quicksort[1000] crescente: " + (System.currentTimeMillis() - iniciovetQuickCresc1)*1000d + " microssegundos");
        
        long iniciovetCountCresc1 = System.currentTimeMillis();
        countingSort(vetCresc1);
        System.out.println("Countingsort[1000] crescente: " + (System.currentTimeMillis() - iniciovetCountCresc1)*1000d + " microssegundos");
        
        for(int i = 999; i >= 0; i--) {
        	vetDecresc1[i] = i;
        	copDecresc1[i] = vetDecresc1[i];
        }
        
        long iniciovetDecresc1 = System.currentTimeMillis();
        bubblesortInt(vetDecresc1, 1000);
        System.out.println("Bubblesort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        long iniciovetInsDecresc1 = System.currentTimeMillis();
        insertionsortInt(vetDecresc1, 1000);
        System.out.println("Insertionsort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetInsDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        long iniciovetSelDecresc1 = System.currentTimeMillis();
        selectionsortInt(vetDecresc1, 1000);
        System.out.println("Selectionsort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetSelDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        long iniciovetHeapDecresc1 = System.currentTimeMillis();
        heapsortInt(vetDecresc1);
        System.out.println("Heapsort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetHeapDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        long iniciovetMergeDecresc1 = System.currentTimeMillis();
        mergesortInt(vetDecresc1, 0, 999);
        System.out.println("Mergesort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetMergeDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        long iniciovetQuickDecresc1 = System.currentTimeMillis();
        quickSortInt(vetDecresc1, 0, 999);
        System.out.println("Quicksort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetQuickDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        long iniciovetCountDecresc1 = System.currentTimeMillis();
        countingSort(vetDecresc1);
        System.out.println("Countingsort[1000] decrescente: " + (System.currentTimeMillis() - iniciovetCountDecresc1)*1000d + " microssegundos");
        vetorCopia(vetDecresc1, copDecresc1, 1000);
        
        vetRand1 = aleatorio(1000);
        vetorCopia(copRand1, vetRand1, 1000);
        
        long iniciovetRand1 = System.currentTimeMillis();
        bubblesortInt(vetRand1, 1000);
        System.out.println("Bubblesort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetRand1)*1000d + " microssegundos");
        vetorCopia(vetRand1, copRand1, 1000);
        
        long iniciovetSelRand1 = System.currentTimeMillis();
        selectionsortInt(vetRand1, 1000);
        System.out.println("Selectionsort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetSelRand1)*1000d + " microssegundos");
        vetorCopia(vetRand1, copRand1, 1000);
        
        long iniciovetInsRand1 = System.currentTimeMillis();
        insertionsortInt(vetRand1, 1000);
        System.out.println("Insertionsort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetInsRand1)*1000d + " microssegundos");
        vetorCopia(vetRand1, copRand1, 1000);
        
        long iniciovetHeapRand1 = System.currentTimeMillis();
        heapsortInt(vetRand1);
        System.out.println("Heapsort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetHeapRand1)*1000d + " microssegundos");
        vetorCopia(vetRand1, copRand1, 1000);
        
        long iniciovetMergeRand1 = System.currentTimeMillis();
        mergesortInt(vetRand1, 0, 999);
        System.out.println("Mergesort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetMergeRand1)*1000d + " microssegundos");        
        vetorCopia(vetRand1, copRand1, 1000);
        
        long iniciovetQuickRand1 = System.currentTimeMillis();
        quickSortInt(vetRand1, 0, 999);
        System.out.println("Quicksort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetQuickRand1)*1000d + " microssegundos");
        vetorCopia(vetRand1, copRand1, 1000);
        
        long iniciovetCountRand1 = System.currentTimeMillis();
        countingSort(vetRand1);
        System.out.println("Countingsort[1000] aleatório: " + (System.currentTimeMillis() - iniciovetCountRand1)*1000d + " microssegundos");
        vetorCopia(vetRand1, copRand1, 1000);
        
        //VETORES DE 10000 POSIÇÕES:
        
        for(int i = 0; i < 10000; i++) {
        	vetCresc2[i] = i;
        }
        
        long iniciovetCresc2 = System.currentTimeMillis();
        bubblesortInt(vetCresc2, 10000);
        System.out.println("Bubblesort[10000] crescente: " + (System.currentTimeMillis() - iniciovetCresc2)*1000d + " microssegundos");
        
        long iniciovetSelCresc2 = System.currentTimeMillis();
        selectionsortInt(vetCresc2, 10000);
        System.out.println("Selectionsort[10000] crescente: " + (System.currentTimeMillis() - iniciovetSelCresc2)*1000d + " microssegundos");
        
        long iniciovetInsCresc2 = System.currentTimeMillis();
        insertionsortInt(vetCresc2, 10000);
        System.out.println("Insertionsort[10000] crescente: " + (System.currentTimeMillis() - iniciovetInsCresc2)*1000d + " microssegundos");
        
        long iniciovetHeapCresc2 = System.currentTimeMillis();
        heapsortInt(vetCresc2);
        System.out.println("Heapsort[10000] crescente: " + (System.currentTimeMillis() - iniciovetHeapCresc2)*1000d + " microssegundos");
        
        long iniciovetMergeCresc2 = System.currentTimeMillis();
        mergesortInt(vetCresc2, 0, 9999);
        System.out.println("Mergesort[10000] crescente: " + (System.currentTimeMillis() - iniciovetMergeCresc2)*1000d + " microssegundos");
        
        long iniciovetQuickCresc2 = System.currentTimeMillis();
        quickSortInt(vetCresc2, 0, 9999);
        System.out.println("Quicksort[10000] crescente: " + (System.currentTimeMillis() - iniciovetQuickCresc2)*1000d + " microssegundos");
        
        long iniciovetCountCresc2 = System.currentTimeMillis();
        countingSort(vetCresc2);
        System.out.println("Countingsort[10000] crescente: " + (System.currentTimeMillis() - iniciovetCountCresc2)*1000d + " microssegundos");
        
        for(int i = 9999; i >= 0; i--) {
        	vetDecresc2[i] = i;
        	copDecresc2[i] = vetDecresc2[i];
        }
        
        long iniciovetDecresc2 = System.currentTimeMillis();
        bubblesortInt(vetDecresc2, 10000);
        System.out.println("Bubblesort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        long iniciovetSelDecresc2 = System.currentTimeMillis();
        selectionsortInt(vetDecresc2, 10000);
        System.out.println("Selectionsort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetSelDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        long iniciovetInsDecresc2 = System.currentTimeMillis();
        insertionsortInt(vetDecresc2, 10000);
        System.out.println("Insertionsort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetInsDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        long iniciovetHeapDecresc2 = System.currentTimeMillis();
        heapsortInt(vetDecresc2);
        System.out.println("Heapsort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetHeapDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        long iniciovetMergeDecresc2 = System.currentTimeMillis();
        mergesortInt(vetDecresc2, 0, 9999);
        System.out.println("Mergesort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetMergeDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        long iniciovetQuickDecresc2 = System.currentTimeMillis();
        quickSortInt(vetDecresc2, 0, 9999);
        System.out.println("Quicksort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetQuickDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        long iniciovetCountDecresc2 = System.currentTimeMillis();
        countingSort(vetDecresc2);
        System.out.println("Countingsort[10000] decrescente: " + (System.currentTimeMillis() - iniciovetCountDecresc2)*1000d + " microssegundos");
        vetorCopia(vetDecresc2, copDecresc2, 10000);
        
        vetRand2 = aleatorio(10000);
        vetorCopia(copRand2, vetRand2, 10000);
        
        long iniciovetRand2 = System.currentTimeMillis();
        bubblesortInt(vetRand2, 10000);
        System.out.println("Bubblesort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        long iniciovetSelRand2 = System.currentTimeMillis();
        selectionsortInt(vetRand2, 10000);
        System.out.println("Selectionsort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetSelRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        long iniciovetInsRand2 = System.currentTimeMillis();
        insertionsortInt(vetRand2, 10000);
        System.out.println("Insertionsort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetInsRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        long iniciovetHeapRand2 = System.currentTimeMillis();
        heapsortInt(vetRand2);
        System.out.println("Heapsort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetHeapRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        long iniciovetMergeRand2 = System.currentTimeMillis();
        mergesortInt(vetRand2, 0, 9999);
        System.out.println("Mergesort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetMergeRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        long iniciovetQuickRand2 = System.currentTimeMillis();
        quickSortInt(vetRand2, 0, 9999);
        System.out.println("Quicksort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetQuickRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        long iniciovetCountRand2 = System.currentTimeMillis();
        countingSort(vetRand2);
        System.out.println("Countingsort[10000] aleatório: " + (System.currentTimeMillis() - iniciovetCountRand2)*1000d + " microssegundos");
        vetorCopia(vetRand2, copRand2, 10000);
        
        //VETORES DE 100000 POSIÇÕES:
        
        for(int i = 0; i < 100000; i++) {
        	vetCresc3[i] = i;
        }
        
        long iniciovetCresc3 = System.currentTimeMillis();
        bubblesortInt(vetCresc3, 100000);
        System.out.println("Bubblesort[100000] crescente: " + (System.currentTimeMillis() - iniciovetCresc3)*1000d + " microssegundos");        
        
        long iniciovetSelCresc3 = System.currentTimeMillis();
        selectionsortInt(vetCresc3, 100000);
        System.out.println("Seletionsort[100000] crescente: " + (System.currentTimeMillis() - iniciovetSelCresc3)*1000d + " microssegundos");
        
        long iniciovetInsCresc3 = System.currentTimeMillis();
        insertionsortInt(vetCresc3, 100000);
        System.out.println("Insertionsort[100000] crescente: " + (System.currentTimeMillis() - iniciovetInsCresc3)*1000d + " microssegundos");
        
        long iniciovetHeapCresc3 = System.currentTimeMillis();
        heapsortInt(vetCresc3);
        System.out.println("Heapsort[100000] crescente: " + (System.currentTimeMillis() - iniciovetHeapCresc3)*1000d + " microssegundos");
        
        long iniciovetMergeCresc3 = System.currentTimeMillis();
        mergesortInt(vetCresc3, 0, 99999);
        System.out.println("Mergesort[100000] crescente: " + (System.currentTimeMillis() - iniciovetMergeCresc3)*1000d + " microssegundos");
        
        long iniciovetQuickCresc3 = System.currentTimeMillis();
        quickSortInt(vetCresc3, 0, 9999);//99999 não rodou
        System.out.println("Quicksort[100000] crescente: " + (System.currentTimeMillis() - iniciovetQuickCresc3)*1000d + " microssegundos");
        
        long iniciovetCountCresc3 = System.currentTimeMillis();
        countingSort(vetCresc3);
        System.out.println("Countingsort[100000] crescente: " + (System.currentTimeMillis() - iniciovetCountCresc3)*1000d + " microssegundos");
        
        for(int i = 99999; i >= 0; i--) {
        	vetDecresc3[i] = i;
        	copDecresc3[i] = vetDecresc3[i];
        }
        
        long iniciovetDecresc3 = System.currentTimeMillis();
        bubblesortInt(vetDecresc3, 100000);
        System.out.println("Bubblesort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        long iniciovetSelDecresc3 = System.currentTimeMillis();
        selectionsortInt(vetDecresc3, 100000);
        System.out.println("Selectionsort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetSelDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        long iniciovetInsDecresc3 = System.currentTimeMillis();
        insertionsortInt(vetDecresc3, 100000);
        System.out.println("Insertionsort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetInsDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        long iniciovetHeapDecresc3 = System.currentTimeMillis();
        heapsortInt(vetDecresc3);
        System.out.println("Heapsort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetHeapDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        long iniciovetMergeDecresc3 = System.currentTimeMillis();
        mergesortInt(vetDecresc3, 0, 99999);
        System.out.println("Mergesort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetMergeDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        long iniciovetQuickDecresc3 = System.currentTimeMillis();
        quickSortInt(vetDecresc3, 0, 9999);//99999 não rodou
        System.out.println("Quicksort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetQuickDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        long iniciovetCountDecresc3 = System.currentTimeMillis();
        countingSort(vetDecresc3);
        System.out.println("Countingsort[100000] decrescente: " + (System.currentTimeMillis() - iniciovetCountDecresc3)*1000d + " microssegundos");
        vetorCopia(vetDecresc3, copDecresc3, 100000);
        
        vetRand3 = aleatorio(100000);
        vetorCopia(copRand3, vetRand3, 100000);
        
        long iniciovetRand3 = System.currentTimeMillis();
        bubblesortInt(vetRand3, 100000);
        System.out.println("Bubblesort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        long iniciovetSelRand3 = System.currentTimeMillis();
        selectionsortInt(vetRand3, 100000);
        System.out.println("Selectionsort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetSelRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        long iniciovetInsRand3 = System.currentTimeMillis();
        insertionsortInt(vetRand3, 100000);
        System.out.println("Insertionsort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetInsRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        long iniciovetHeapRand3 = System.currentTimeMillis();
        heapsortInt(vetRand3);
        System.out.println("Heapsort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetHeapRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        long iniciovetMergeRand3 = System.currentTimeMillis();
        mergesortInt(vetRand3, 0, 99999);
        System.out.println("Mergesort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetMergeRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        long iniciovetQuickRand3 = System.currentTimeMillis();
        quickSortInt(vetRand3, 0, 99999);
        System.out.println("Quicksort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetQuickRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        long iniciovetCountRand3 = System.currentTimeMillis();
        countingSort(vetRand3);
        System.out.println("Countingsort[100000] aleatório: " + (System.currentTimeMillis() - iniciovetCountRand3)*1000d + " microssegundos");
        vetorCopia(vetRand3, copRand3, 100000);
        
        //VETORES DE 1000000 POSIÇÕES:
        
        for(int i = 0; i < 1000000; i++) {
        	vetCresc4[i] = i;
        }
        
        long iniciovetCresc4 = System.currentTimeMillis();
        bubblesortInt(vetCresc4, 1000000);
        System.out.println("Bubblesort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetCresc4)*1000d + " microssegundos");
        
        long iniciovetSelCresc4 = System.currentTimeMillis();
        selectionsortInt(vetCresc4, 1000000);
        System.out.println("Selectionsort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetSelCresc4)*1000d + " microssegundos");
        
        long iniciovetInsCresc4 = System.currentTimeMillis();
        insertionsortInt(vetCresc4, 1000000);
        System.out.println("Insertionsort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetInsCresc4)*1000d + " microssegundos");
        
        long iniciovetHeapCresc4 = System.currentTimeMillis();
        heapsortInt(vetCresc4);
        System.out.println("Heapsort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetHeapCresc4)*1000d + " microssegundos");
        
        long iniciovetMergeCresc4 = System.currentTimeMillis();
        mergesortInt(vetCresc4, 0, 999999);
        System.out.println("Mergesort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetMergeCresc4)*1000d + " microssegundos");
        
        long iniciovetQuickCresc4 = System.currentTimeMillis();
        quickSortInt(vetCresc4, 0, 9999);//999999 não rodou
        System.out.println("Quicksort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetQuickCresc4)*1000d + " microssegundos");
        
        long iniciovetCountCresc4 = System.currentTimeMillis();
        countingSort(vetCresc4);
        System.out.println("Countingsort[1000000] crescente: " + (System.currentTimeMillis() - iniciovetCountCresc4)*1000d + " microssegundos");
        
        for(int i = 999999; i >= 0; i--) {
        	vetDecresc4[i] = i;
        	copDecresc4[i] = vetDecresc4[i];
        }
        
        long iniciovetDecresc4 = System.currentTimeMillis();
        bubblesortInt(vetDecresc4, 1000000);
        System.out.println("Bubblesort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        long iniciovetSelDecresc4 = System.currentTimeMillis();
        selectionsortInt(vetDecresc4, 1000000);
        System.out.println("Selectionsort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetSelDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        long iniciovetInsDecresc4 = System.currentTimeMillis();
        insertionsortInt(vetDecresc4, 1000000);
        System.out.println("Insertionsort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetInsDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        long iniciovetHeapDecresc4 = System.currentTimeMillis();
        heapsortInt(vetDecresc4);
        System.out.println("Heapsort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetHeapDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        long iniciovetMergeDecresc4 = System.currentTimeMillis();
        mergesortInt(vetDecresc4, 0, 999999);
        System.out.println("Mergesort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetMergeDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        long iniciovetQuickDecresc4 = System.currentTimeMillis();
        quickSortInt(vetDecresc4, 0, 9999);//Não rodou 999999
        System.out.println("Quicksort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetQuickDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        long iniciovetCountDecresc4 = System.currentTimeMillis();
        countingSort(vetDecresc4);
        System.out.println("Countingsort[1000000] decrescente: " + (System.currentTimeMillis() - iniciovetCountDecresc4)*1000d + " microssegundos");
        vetorCopia(vetDecresc4, copDecresc4, 1000000);
        
        vetRand4 = aleatorio(1000000);
        vetorCopia(copRand4, vetRand4, 1000000);
        
        long iniciovetRand4 = System.currentTimeMillis();
        bubblesortInt(vetRand4, 1000000);
        System.out.println("Bubblesort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
        long iniciovetSelRand4 = System.currentTimeMillis();
        selectionsortInt(vetRand4, 1000000);
        System.out.println("Selectionsort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetSelRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
        long iniciovetInsRand4 = System.currentTimeMillis();
        insertionsortInt(vetRand4, 1000000);
        System.out.println("Insertionsort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetInsRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
        long iniciovetHeapRand4 = System.currentTimeMillis();
        heapsortInt(vetRand4);
        System.out.println("Heapsort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetHeapRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
        long iniciovetMergeRand4 = System.currentTimeMillis();
        mergesortInt(vetRand4, 0, 999999);
        System.out.println("Mergesort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetMergeRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
        long iniciovetQuickRand4 = System.currentTimeMillis();
        quickSortInt(vetRand4, 0, 9999);//999999 não rodou
        System.out.println("Quicksort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetQuickRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
        long iniciovetCountRand4 = System.currentTimeMillis();
        countingSort(vetRand4);
        System.out.println("Countingsort[1000000] aleatório: " + (System.currentTimeMillis() - iniciovetCountRand4)*1000d + " microssegundos");
        vetorCopia(vetRand4, copRand4, 1000000);
        
  		System.out.println("Fim.");

	}

}
