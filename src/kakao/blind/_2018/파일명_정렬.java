package kakao.blind._2018;

import java.util.Arrays;

public class 파일명_정렬 {

    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String f1Head = f1.split("\\d+")[0];
            int f1Number = Integer.parseInt(f1.split("\\D+")[1]);

            String f2Head = f2.split("\\d+")[0];
            int f2Number = Integer.parseInt(f2.split("\\D+")[1]);

            int headCompare = f1Head.compareToIgnoreCase(f2Head);
            return headCompare != 0 ? headCompare : Integer.compare(f1Number, f2Number);
        });

        return files;
    }
}
