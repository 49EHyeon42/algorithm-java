import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> genreHashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!genreHashMap.containsKey(genres[i])) {
                genreHashMap.put(genres[i], new Genre());
            }
            genreHashMap.get(genres[i]).add(i, plays[i]);
        }

        ArrayList<Entry<String, Genre>> genreList = new ArrayList<>(genreHashMap.entrySet());
        genreList.sort((o1, o2) -> o2.getValue().getTotalPlay() - o1.getValue().getTotalPlay());

        for (Entry<String, Genre> entry : genreList) {
            entry.getValue().getList().sort((o1, o2) -> {
                if (o1.getPlay() == o2.getPlay()) {
                    return Integer.compare(o1.getId(), o2.getId());
                } else {
                    return Integer.compare(o2.getPlay(), o1.getPlay());
                }
            });
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Entry<String, Genre> entry : genreList) {
            ArrayList<Music> musicList = entry.getValue().getList();

            if (entry.getValue().getList().size() > 1) {
                result.add(musicList.get(0).getId());
                result.add(musicList.get(1).getId());
            } else {
                result.add(musicList.get(0).getId());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Genre {

        private int totalPlay;
        private final ArrayList<Music> musicList;

        public Genre() {
            totalPlay = 0;
            musicList = new ArrayList<>();
        }

        public void add(int id, int play) {
            totalPlay += play;
            musicList.add(new Music(id, play));
        }

        public int getTotalPlay() {
            return totalPlay;
        }

        public ArrayList<Music> getList() {
            return musicList;
        }
    }

    static class Music {

        private final int id;
        private final int play;

        public Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        public int getId() {
            return id;
        }

        public int getPlay() {
            return play;
        }
    }
}
