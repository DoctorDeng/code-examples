package jdk22;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

/**
 * 练习 {@link java.util.stream.Gatherer} 操作流.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2026/2/10 16:36
 */
public class GathererTest {

    public static <T, R> Gatherer<T, ?, R> scan(
            Supplier<R> initial,
            BiFunction<? super R, ? super T, ? extends R> scanner) {
        class State {
            R current = initial.get();
        }
        return Gatherer.<T, State, R>ofSequential(
                State::new,
                Gatherer.Integrator.ofGreedy((state, element, downstream) -> {
                    state.current = scanner.apply(state.current, element);
                    return downstream.push(state.current);
                })
        );
    }

    static void main() {
        List<String> numberStrings = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(
                        scan(() -> "", (string, number) -> string + number)
                )
                .toList();
        System.out.println(numberStrings);
    }

}
