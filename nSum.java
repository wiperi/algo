import java.util.ArrayList;
import java.util.List;

public class nSum {

    class State {
        int[] arr;
        List<Integer> path;
        int target;

        protected State(int target, int[] arr, List<Integer> path) {
            this.target = target;
            this.arr = arr;
            this.path = path;
        }
    }

    public static List<List<Integer>> nsum(int[] arr, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        State state = new nSum().new State(target, arr, new ArrayList<>());
        int choice = 0;
        backtrack(res, state, choice);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, nSum.State state, int choice) {
        if (isSolution(state)) {
            recordSolution(res, state);
        }
        
        for (int i = choice; i < state.arr.length; i++) {
            if (isValid(state, choice)) {
                makeChoice(state, choice);
                backtrack(res, new nSum().new State(state.target, state.arr, state.path), choice + 1);
                undoChoice(state, choice);
            }
        }
    }

    private static void undoChoice(nSum.State state, int choice) {
        List<Integer> path = state.path;
        path.remove(path.size() - 1);
    }

    private static void makeChoice(nSum.State state, int choice) {
        state.path.add(state.arr[choice]);
    }

    private static boolean isValid(nSum.State state, int choice) {
        if (state.arr[choice] == state.arr[choice - 1]) {
            return false;
        }
        return true;
    }

    private static void recordSolution(List<List<Integer>> res, nSum.State state) {
        res.add(state.path);
    }

    private static boolean isSolution(nSum.State state) {
        Integer sum = 0;
        for (Integer integer : state.path) {
            sum += integer;
        }
        if (sum == state.target) {
            return true;
        }
        return false;
    }
}