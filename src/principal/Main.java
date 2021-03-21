package principal;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		JogoDaVelha jogo;
		Jogador jogador1;
		Jogador jogador2;
		String nomeJogador, respostaFinal;
		int dimensaoTabuleiro, jogadaX, jogadaY;
		
		System.out.println("Digite a dimensão do tabuleiro:");
		dimensaoTabuleiro = keyboard.nextInt();
		
		System.out.println("Digite o nome do jogador 1:");
		nomeJogador = keyboard.next();
		jogador1 = new Jogador(nomeJogador);
		
		System.out.println("Digite o nome do jogador 2:");
		nomeJogador = keyboard.next();
		jogador2 = new Jogador(nomeJogador);
		
		jogo = new JogoDaVelha(dimensaoTabuleiro);
		
		//laço para jogar outro jogo
		do {
			//laço para jogar até ser vencedor
			boolean ganhador = false;
			char jogada;
			int numeroMaximoJogadas = 0; //caso não houver vencedor
			do {
				boolean jogadaRealizada = false;
				//verifica jogada se esta ok
				do {
					jogada = 'X';
					
					System.out.println(jogador1.getNome() + " faça sua jogada x:");
					jogadaX = keyboard.nextInt();
					
					System.out.println(jogador1.getNome() + " faça sua jogada y:");
					jogadaY = keyboard.nextInt();
						
				}while(!jogo.realizaJogada(jogadaX, jogadaY, jogada));
				
				System.out.println();
				System.out.println();
				System.out.print(jogo.toString());
				System.out.println();
				System.out.println();
				
				//verifica se o jogador 1
				ganhador = jogo.verificaGanhador();
				if(ganhador) {
					break;
				}
				
				do {
					jogada = '0';
					
					System.out.println(jogador2.getNome() + " faça sua jogada x:");
					jogadaX = keyboard.nextInt();
					
					System.out.println(jogador2.getNome() + " faça sua jogada y:");
					jogadaY = keyboard.nextInt();
					
				}while(!jogo.realizaJogada(jogadaX, jogadaY, jogada));
				
				System.out.println();
				System.out.println();
				System.out.print(jogo.toString());
				System.out.println();
				System.out.println();
				
				//verifica se o jogador 2
				ganhador = jogo.verificaGanhador();
				
				//2 jogadas por laço
				numeroMaximoJogadas +=2;
				
			}while(!ganhador /* || numeroMaximoJogadas < dimensaoTabuleiro*2*/);
			
			switch (jogada) {
				case 'X': {
					System.out.println(jogador1.getNome()+" ganhou a rodada");
					jogador1.setPontos(jogador1.getPontos()+1);
				}
				case 'O': {
					System.out.println(jogador2.getNome()+" ganhou a rodada");
					jogador2.setPontos(jogador2.getPontos()+1);
				}
			}
			
			System.out.println("Deseja jogar novamente (s)?");
			respostaFinal = keyboard.next();
			
			keyboard.nextLine();
			
		}while(respostaFinal.equals("s"));
		
		//mostra ganhador
		if(jogador1.getPontos() > jogador2.getPontos()) {
			System.out.println(jogador1.getNome()+" fez "+jogador1.getPontos()+", parabens voce ganhou!");
		}else if(jogador1.getPontos() < jogador2.getPontos()) {
			System.out.println(jogador2.getNome()+" fez "+jogador2.getPontos()+", parabens voce ganhou!");
		}else {
			System.out.println("Ninguem ganhou");
		}
		
	}

}
