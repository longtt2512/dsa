package codility.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author long.truong@finos.asia
 */
public class FishTest {

    public int solution(int[] sizes, int[] directions) {
        // Implement your solution here
        int remainingFish = 0;

        Stack<Integer> tempStack = new Stack<Integer>();
        // 0 = up
        // 1 = down
        for (int i = 0; i < sizes.length; i++) {
            int currentFishSize = sizes[i];

            if (directions[i] == 1)
                tempStack.push(currentFishSize);
            else {
                int lastFishSize = 0;
                if (!tempStack.isEmpty()) {
                    lastFishSize = tempStack.pop();
                }
                while (lastFishSize > 0 && lastFishSize < currentFishSize) {
                    // feeded
                    if (tempStack.isEmpty())
                        lastFishSize = 0;
                    else
                        lastFishSize = tempStack.pop();
                }

                if (lastFishSize == 0)
                    remainingFish += 1;
                else
                    tempStack.push(lastFishSize);
            }
        }


        return remainingFish + tempStack.size();
    }
}
