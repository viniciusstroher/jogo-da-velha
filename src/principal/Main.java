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
			do {
				
				//verifica jogada se esta ok
				do {
					System.out.println(jogador1.getNome() + " faça sua jogada x:");
					jogadaX = keyboard.nextInt();
					
					System.out.println(jogador1.getNome() + " faça sua jogada y:");
					jogadaY = keyboard.nextInt();
				}while(!jogo.realizaJogada(jogadaX, jogadaY, 'X'));
				
				do {
					System.out.println(jogador2.getNome() + " faça sua jogada x:");
					jogadaX = keyboard.nextInt();
					
					System.out.println(jogador2.getNome() + " faça sua jogada y:");
					jogadaY = keyboard.nextInt();
				}while(!jogo.realizaJogada(jogadaX, jogadaY, 'O'));
				
				System.out.println();
				System.out.print(jogo.toString());
				System.out.println();
				
				//da pontos ao jogador.
				
			}while(!jogo.verificaGanhador());
			
			System.out.println("Deseja jogar novamente?");
			respostaFinal = keyboard.next();
			
			keyboard.nextLine();
			
		}while(respostaFinal.equals("s"));
		
		//mostra ganhador
		if(jogador1.getPontos() > jogador2.getPontos()) {
			System.out.println(jogador1.getNome()+" fez "+jogador1.getPontos()+", parabens voce ganhou!");
		}else {
			System.out.println(jogador2.getNome()+" fez "+jogador2.getPontos()+", parabens voce ganhou!");
		}
		
	}

}
