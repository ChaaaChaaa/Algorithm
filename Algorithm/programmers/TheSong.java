package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class TheSong {
    public String solution(String m, String[] musicinfos) {
        Arrays.sort(musicinfos, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int firstPlayTimeResult = splitMusicInfo(o1);
                int secondPlayTimeResult = splitMusicInfo(o2);
                return secondPlayTimeResult - firstPlayTimeResult;
            }
        });

        m = killSharp(m);

        for(int i=0; i<musicinfos.length; i++){
            System.out.println(musicinfos[i]);
        }


        for (int i = 0; i < musicinfos.length; i++) {
            String musicInfo = musicinfos[i];
            String[] tempInfo = musicInfo.split(",");
            int playTime = splitMusicInfo(musicInfo);

            String music = tempInfo[3];
            music = killSharp(music);

            String tempString = makeMusic(music, playTime);

            if (tempString.contains(m)) {
                return tempInfo[2];
            }
        }
        return "(None)";
    }

    private int splitMusicInfo(String musicInfo) {
        String[] temp = musicInfo.split(",");
        String[] StartArr = temp[0].split(":");
        String[] EndArr = temp[1].split(":");

        int playHour = Integer.parseInt(EndArr[0]) - Integer.parseInt(StartArr[0]);
        int result = Integer.parseInt(EndArr[1]) - Integer.parseInt(StartArr[1]) + (playHour * 60);
        return result;
    }


    private String makeMusic(String wholeSongKey, int t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(wholeSongKey.charAt(i % wholeSongKey.length()));
        }
        return sb.toString();
    }


    private String killSharp(String s) {
        s = s.replaceAll("A#", "a");
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        return s;
    }

    public static void main(String[] args) {
        TheSong theSong = new TheSong();
        //String s = "ABCDEFG";
        String s = "CC#BCC#BCC#BCC#B";
        //String s = "ABC";
        // String[] musicInfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicInfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        //String[] musicInfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(theSong.solution(s, musicInfos));
    }

}
