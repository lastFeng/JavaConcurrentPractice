package chapter8;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

public class ConcurrentPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec;
    private final ConcurrentMap<P, Boolean> seen;
    private ValueLatch<SequentialPuzzleSolver.Node<P, M>> solution
            = new ValueLatch<>();

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
        this.puzzle = puzzle;
        this.exec = exec;
        this.seen = seen;
    }

    public List<M> solve() throws InterruptedException {
        try {
            P p = puzzle.initialPosition();
            exec.execute(newTask(p, null, null));
            SequentialPuzzleSolver.Node<P, M> value = solution.getValue();
            return value == null ? null : value.asMoveList();
        } finally {
            exec.shutdown();
        }
    }

    protected Runnable newTask(P p, M m, SequentialPuzzleSolver.Node<P, M> n) {
        return new SolverTask(p, m, n);
    }

    class SolverTask extends SequentialPuzzleSolver.Node<P, M> implements Runnable {

        public SolverTask(P pos, M move, SequentialPuzzleSolver.Node<P, M> prev) {
            super(pos, move, prev);
        }

        @Override
        public void run() {
            if (solution.isSet() || seen.putIfAbsent(pos, true) != null) {
                return;
            }
            if (puzzle.isGoal(pos)) {
                solution.setValue(this);
            } else {
                for (M move : puzzle.legalMoves(pos)) {
                    exec.execute(newTask(puzzle.move(pos, move), move, this));
                }
            }
        }
    }
}
