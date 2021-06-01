package inPractice.chapter15;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.concurrent.atomic.AtomicReference;

public class CasNumberRange {
    @Immutable
    private static class IntPair {
        final int lower;
        final int upper;

        public IntPair(int lower, int upper) {
            if (lower > upper) {
                throw new IllegalArgumentException();
            }
            this.lower = lower;
            this.upper = upper;
        }

        private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

        public int getLower() {
            return values.get().lower;
        }

        public int getUpper() {
            return values.get().upper;
        }

        public void setLower(int i) {
            while (true) {
                IntPair oldV = values.get();
                if (i > oldV.upper) {
                    throw new IllegalArgumentException();
                }
                IntPair newV = new IntPair(i, oldV.upper);
                if (values.compareAndSet(oldV, newV)) {
                    return;
                }
            }
        }

        public void setUpper(int i) {
            while (true) {
                IntPair oldV = values.get();
                if (i < oldV.lower) {
                    throw new IllegalArgumentException();
                }
                IntPair newV = new IntPair(oldV.lower, i);
                if (values.compareAndSet(oldV, newV)) {
                    return;
                }
            }
        }
    }
}
