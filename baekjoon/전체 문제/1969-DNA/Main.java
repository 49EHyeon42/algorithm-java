import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] dna = new char[N][M];

        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();

        int minimumHammingDistance = 0;

        for (int i = 0; i < dna[0].length; i++) {
            int[] alphabet = new int[26];

            for (char[] nucleotide : dna) {
                alphabet[nucleotide[i] - 'A']++;
            }

            int maxIndex = 0;
            int maxCount = 0;

            for (int j = 0; j < alphabet.length; j++) {
                if (maxCount < alphabet[j]) {
                    maxIndex = j;
                    maxCount = alphabet[j];
                }
            }

            sb.append((char) ('A' + maxIndex));

            minimumHammingDistance += N - maxCount;
        }

        bw.write(sb + "\n" + minimumHammingDistance);
        bw.flush();

        br.close();
        bw.close();
    }
}
