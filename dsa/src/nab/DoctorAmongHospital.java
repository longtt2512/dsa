package nab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author long.truong@finos.asia
 */
public class DoctorAmongHospital {

    public static void main(String[] args) {
//        int[][] input = {{1,2,3},{3,4,1},{3,5,1}};
//        int[][] input = {{1,2,3},{1,5,6},{1,5,1}};
        int[][] input = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(solution(input));
    }

    public static int solution(int[][] input) {
        int maxDoctor = 0;
        Map<Integer, Integer> hospitalMap = new HashMap<>();
        Set<Integer> duplicatedDoctors = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                int suspectDoctorId = input[i][j];
                if (!hospitalMap.containsKey(suspectDoctorId)) {
                    if (!duplicatedDoctors.contains(suspectDoctorId)) {
                        // Found a suspect doctor in hospital i
                        hospitalMap.put(suspectDoctorId, i);
                    }
                } else if ( hospitalMap.get(suspectDoctorId) != i) {
                        // In different hospital
                        duplicatedDoctors.add(suspectDoctorId);
                        hospitalMap.remove(suspectDoctorId);

                }
            }
        }
        return duplicatedDoctors.size();
    }
}
