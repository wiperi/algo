package Chap3_Search;

import java.util.List;

public class Backtracking {
    abstract class State {
    }

    abstract class Choice {
    }

    private void undoChoice(State state, Choice choice) {
    }

    private void makeChoice(State state, Choice choice) {
    }

    private boolean isValid(State state, Choice choice) {
        return false;
    }

    private void recordSolution(State state, List<State> res) {
    }

    private boolean isSolution(State state) {
        return false;
    }

    /* 回溯算法框架 */
    @SuppressWarnings("unused")
    private void backtrack(State state, List<Choice> choices, List<State> res) {
        if (isSolution(state)) {// 判断是否为解
            recordSolution(state, res);// 记录解
            return;// 停止继续搜索
        }
        for (Choice choice : choices) {// 遍历所有选择
            if (isValid(state, choice)) { // 剪枝：判断选择是否合法
                makeChoice(state, choice); // 尝试：做出选择，更新状态
                backtrack(state, choices, res);
                undoChoice(state, choice); // 回退：撤销选择，恢复到之前的状态
            }
        }
    }
}
