import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        Permutation("", str);
        System.out.println(PermuList("", str));
        System.out.println(PermuCount("", str));
    }

    public static void Permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            Permutation(f + ch + s, up.substring(1));
        }
    }

// Using ArrayList<>

    public static ArrayList<String> PermuList(String p , String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length() ; i++) {

            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ans.addAll(PermuList(f+ch+s, up.substring(1)));
        }
        return ans;
    }
    // To return the count
    public static int PermuCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + PermuCount(f + ch + s, up.substring(1));
        }
        return count;
}
}
