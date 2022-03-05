package controller;
public class SapoCorrendo extends Thread{
	final static int NUM_SAPOS = 5;
	final static int DISTANCIA = 250;
	public static void main (String[] args) {
		for (int i = 1; i <= NUM_SAPOS; i++) {
			new SaposCorrendo("Sapo_" + i, DISTANCIA).start();
		}
	}
}
 class SaposCorrendo extends Thread {
	 String nome;
	 int distanciaPercorrida = 0;
	 int distanciaTotal;
	 int pulo = 0;
     int pulos = 0;
	 static int colocacao = 0;
	 final static int Pulo_Max = 50
			 ;
	
	public SaposCorrendo(String nome, int distanciaTotal) {
		super (nome);
		this.distanciaTotal = distanciaTotal;
		this.nome  = nome;	
	}
	
	public void SapoSituacao() {
		System.out.println("O " + nome + " pulou " + pulo + "cm \t  e já percorreu " + distanciaPercorrida + " cm. ");
		
	}
	public void SapoPulando() {
		pulos++;
		pulo = (int) (Math.random() * Pulo_Max);
		distanciaPercorrida += pulo; 
		if (distanciaPercorrida > distanciaTotal) {
			distanciaPercorrida = distanciaTotal;	
		}		 
	}
	public void SapoPause() {
		Thread.yield();
	}
	public void colocacao () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + "º colocado com " + pulos + " pulos");
		
	}
	
	public void run () {
		while (distanciaPercorrida < distanciaTotal) {
		SapoPulando();
		SapoSituacao();
		SapoPause();
		try {
			sleep (150);	
			}catch (InterruptedException e) {}
			
				try {
				sleep (1500);
			}catch (InterruptedException e) {}
		
		}
		colocacao();
	}
 }
 
 



