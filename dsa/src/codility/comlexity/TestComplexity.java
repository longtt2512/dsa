package codility.comlexity;

/**
 * @author long.truong@finos.asia
 */
public class TestComplexity {

    public static void main(String[] args) {
        System.out.println(solutionEquilibrium(new int[]{3,1,2,4,3}));
    }

    public static int solutionEquilibrium(int[] inputs) {

        if(inputs.length <=1 ) return 0;
        int leftSum = inputs[0];
        int rightSum = 0;
        for(int item: inputs){
            rightSum += item;
        }
        rightSum -= leftSum;

        int diff = Math.abs(leftSum - rightSum);
        for(int i = 1; i < inputs.length-1; i++){
            rightSum = rightSum - inputs[i];
            leftSum = leftSum + inputs[i];
            int currentDiff = Math.abs(leftSum- rightSum);
            if(currentDiff < diff){
                diff = currentDiff;

            }
        }
        return diff;
    }
}
