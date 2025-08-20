package test01;
import java.util.*;

public class test7291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取操作序列
        String opsStr = sc.nextLine().replaceAll("[\\[\\]\"]", "");
        String[] operations = opsStr.split(",");

        // 读取参数序列
        String paramsStr = sc.nextLine().replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
        String[] paramGroups = paramsStr.split("\\],\\[");

        List<String> output = new ArrayList<>();
        ParkingSystem ps = null;

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i].trim();
            String[] params = paramGroups[i].split(",");

            if (op.equals("ParkingSystem")) {
                ps = new ParkingSystem(
                        Integer.parseInt(params[0].trim()),
                        Integer.parseInt(params[1].trim()),
                        Integer.parseInt(params[2].trim())
                );
                output.add("null");
            } else {
                boolean result = ps.addCar(Integer.parseInt(params[0].trim()));
                output.add(String.valueOf(result));
            }
        }

        System.out.println(output);
        sc.close();
    }

    static class ParkingSystem {
        private int[] slots;

        public ParkingSystem(int big, int medium, int small) {
            slots = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (slots[carType - 1] > 0) {
                slots[carType - 1]--;
                return true;
            }
            return false;
        }
    }
}