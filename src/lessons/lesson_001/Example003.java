package lessons.lesson_001;

// Найти шанс выпадения определённой суммы на игральных костях для трёх шестигранных кубиков

public class Example003 {
    public static void main(String[] args) {
        System.out.println(findSum(15));
    }
        public static double findSum (int sum){
            int count = 0;
            int successResult = 0;
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (i + j + k == sum) {
                            successResult++;
                        }
                        count++;
                    }

                }
            }
            return ((double) successResult) / ((double) count);
        }
    }

