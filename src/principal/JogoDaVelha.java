package principal;

import java.util.Iterator;

public class JogoDaVelha {
	private int dimensao;
	
	private char[][] tabuleiro;
	
	private Jogador jogador1; 
	private Jogador jogador2;
	
	public JogoDaVelha(int dimensao) {
		this.dimensao = dimensao;
		
		//inicia tabuleiro
		this.criaTabuleiro();
	}
	
	public void criaTabuleiro() {
		this.tabuleiro = new char[this.dimensao][this.dimensao];
	}
	
	public boolean verificaGanhador() {
		boolean ganhador = false;
		
		boolean ganhadorVerticalX = false;
		ganhadorVerticalX = verificaVertical('X');
		if(ganhadorVerticalX) {
			return true;
		}
		
		boolean ganhadorVerticalO = false;
		ganhadorVerticalO = verificaVertical('O');
		if(ganhadorVerticalO) {
			return true;
		}
		
		
		boolean ganhadorHorizontalX = false;
		ganhadorHorizontalX = verificaHorizontal('X');
		if(ganhadorHorizontalX) {
			return true;
		}
		
		boolean ganhadorHorizontalO = false;
		ganhadorHorizontalO = verificaHorizontal('O');
		if(ganhadorHorizontalO) {
			return true;
		}
		
		boolean ganhadorDiagonalX = false;
		ganhadorDiagonalX = verificaDiagonal('X');
		if(ganhadorDiagonalX) {
			return true;
		}
		
		boolean ganhadorDiagonalO = false;
		ganhadorDiagonalO = verificaDiagonal('O');
		if(ganhadorDiagonalO) {
			return true;
		}
		
		return false;
	}
	
	public boolean verificaDiagonal(char jogada) {
		//se o contador for igual a dimensao da vertical com as mesmas peças
		//é uma vitoria
		int contador = 0; 
		
		//diagonal
		for(int i = 0; i < this.dimensao ; i++) {
			if(this.tabuleiro[i][i] == jogada) {
				contador++;
			}
			
			//ao final da linha ele verifica se o contador das jogadas é
			//igual a quantidade da linha
			if(contador == this.dimensao) {
				return true;
			}
		}
		
		contador = 0; 
		
		//diagonal oposta
		int x = 0;
		for(int i = this.dimensao-1; i >= 0 ; i--) {
			if(this.tabuleiro[x][i] == jogada) {
				contador++;
			}
			
			//ao final da linha ele verifica se o contador das jogadas é
			//igual a quantidade da linha
			if(contador == this.dimensao) {
				return true;
			}
			
			x++;
		}
		
		return false;
	}
	
	public boolean verificaHorizontal(char jogada) {
		//se o contador for igual a dimensao da vertical com as mesmas peças
		//é uma vitoria
		int contador = 0; 
		
		for(int i = 0; i < this.dimensao ; i++) {
			for(int j = 0; j < this.dimensao ; j++) {
				if(this.tabuleiro[i][j] == jogada) {
					contador++;
				}
				
				//ao final da linha ele verifica se o contador das jogadas é
				//igual a quantidade da linha
				if(contador == this.dimensao) {
					return true;
				}
			}
			contador = 0; 
		}
		
		return false;
	}
	
	public boolean verificaVertical(char jogada) {
		//se o contador for igual a dimensao da vertical com as mesmas peças
		//é uma vitoria
		int contador = 0; 
		
		for(int i = 0; i < this.dimensao ; i++) {
			for(int j = 0; j < this.dimensao ; j++) {
				if(this.tabuleiro[j][i] == jogada) {
					contador++;
				}
				
				//ao final da linha ele verifica se o contador das jogadas é
				//igual a quantidade da linha
				if(contador == this.dimensao) {
					return true;
				}
			}
			contador = 0; 
		}
		
		return false;
	}
	
	public boolean realizaJogada(int x, int y, char jogada) {
		//valores proibidos maior que a dimensao
		//e menor que zero 
		if(x < 0 || y < 0 || x > this.dimensao-1 || y > this.dimensao-1) {
			return false;
		}
		
		//varifica se ja fizeram a jogada
		if(this.tabuleiro[x][y] == 0) {
			//registra a jogada
			this.tabuleiro[x][y] = jogada; //X ou O
			return true;
		}

		return false;
	}
	
	public String toString() {
		String tabuleiro = "";
		//varre array 
		for(int i = 0; i < this.dimensao ; i++) {
			for(int j = 0; j < this.dimensao ; j++) {
				//se nao tiver valor na posição ele mostra um _
				if(this.tabuleiro[i][j] == 0) {
					tabuleiro += "_";
				}else {
					//se tiver ele pega o valor atual
					tabuleiro += this.tabuleiro[i][j];
				}
				//a cada interação na linha ele da um espaço dps de ver o valor
				tabuleiro += " ";
			}
			//ao final da linha ele da um \n para quebrar a linha
			tabuleiro += " \n";
		}
		
		return tabuleiro;
	}
}
