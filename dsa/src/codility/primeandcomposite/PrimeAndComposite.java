package codility.primeandcomposite;

/**
 * @author long.truong@finos.asia
 */
public class PrimeAndComposite {

    public static void main(String[] args) {

    }

    public int solution(int input) {
        // Implement your solution here
        int i = 1;
        if(input == 0) return 0;
        int result = 2;
        while(i*i <input){
            if(input%i ==0){
                if(i != 1)
                    result += 2;
            }

            i++;
        }
        if (i*i == input ){
            result++;
        }
        return result;
    }
}
