package zhanglw.study.algorithm.problem;

/**
 * Created by zhanglw on 2017/1/4.
 */
public class FindTheKthLargestValue {

    private final static int MAX_ARRAY_LENGTH = 1000;

    private static int[] initArr = new int[MAX_ARRAY_LENGTH];


    private final static int k = 101;
    static {
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            initArr[i] = (int) (Math.random() * 1000);
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
//            System.out.println(initArr[i]);
//        }
        System.out.println(initArr[k]);
    }


    // 算法一:

   public  void caseOne(int[] arr,int k){


   }
}
