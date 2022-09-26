import services.BestFirst;
import models.Board;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BestFirst s = new BestFirst();
        Iterator<BestFirst.State> it = s.solve(new Board(sc.next()),
                new Board(sc.next()));
        if (it == null)
            System.out.println("no solution found");
        else {
            while (it.hasNext()) {
                BestFirst.State i = it.next();
                System.out.println(i);
                if (!it.hasNext())
                    System.out.println(i.getG());
            }
        }
        sc.close();
    }
}

/*
 * Best-first state-space search algorithm:
 *
 * Criar estado initial a partir da config initial.
 * Criar a fila com prioridade abertos para estados ainda não testados;
 * Criar lista fechados para estados já testados;
 * Inserir estado inicial em abertos;
 * Repetir até que uma solução seja encontrada (e enquanto houver memória):
 * Se (lista abertos vazia) sair com fracasso
 * estado actual := primeiro de abertos;
 * remover actual de abertos;
 * Se (config do estado actual for igual à config goal)
 * Mostrar sequência desde inicial até goal;
 * Senão
 * sucessores := todos os filhos do estado actual;
 * inserir actual na lista fechados;
 * Para cada sucessor em sucessores
 * Se (sucessor não existir em fechados)
 * inserir sucessor em abertos;
 */
