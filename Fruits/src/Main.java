import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //1問目。2で割って余りを返す関数
        Function<Integer, Integer> f = x -> x % 2;
        System.out.println("5divide" + f.apply(5));

        //2問目。文字列に対して、こんにちは文字列さんを返す関数
        Function<String,String> greet = x -> "こんにちは" + x + "さん";
        System.out.println(greet.apply("human")); // こんにちはarakiさんが返ってくる


        //3問目。文字列の長さが10より長いならtrueを返す関数
        Predicate<String> validate = str -> str.length() < 10;
        System.out.println(validate.test("abcd"));
        System.out.println(validate.test("abcdefghijkl"));

        //10より大きいならtrue,そうでないならfalseを返す関数
        Predicate<Integer> g = x -> x > 10;
        //4問目。
        List<Integer> target = List.of(2,3,11,23);
        List<Integer> filtered = target.stream().filter(g).toList();
        System.out.println(filtered);

        //5問目。
        List<String> stringList = List.of(
                "abcde",
                "abcdefghlj",
                "abcdefghijk",
                "abcdefghijklmn");
        List<String > strFiltered = stringList.stream().filter(validate).toList();
        System.out.println(strFiltered);

        //binaryoperater最初の問題。2項演算を表す関数
        BinaryOperator<Integer> bo = (x,y) -> {
            return x + y * 2;
        };

        //binaryoperater 最後の問題。
        BinaryOperator<List<Integer>> add = (list1, list2) -> {
            List<Integer> l = new ArrayList<>();
            List<Integer> shortList = new ArrayList<>();
            List<Integer> longList = new ArrayList<>();
            if(list1.size() <= list2.size()) {
                shortList = list1;
                longList = list2;
            } else {
                shortList = list2;
                longList = list1;
            }
            for(int i = 0; i < shortList.size(); i++) {
                l.add(shortList.get(i) + longList.get(i));
            }
            for(int i = shortList.size(); i < longList.size(); i++) {
                l.add(longList.get(i));
            }
            return l;
        };

        List<Integer> result =
                add.apply(List.of(111,11,11,2,3), List.of(3,5,9,11));
        System.out.println(result);

        //sort
        List<String> strList = new ArrayList<>(List.of("aaa", "bb", "c"));
        Collections.sort(strList);
        System.out.println(strList);
        Comparator<String> c = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(strList, c);
        System.out.println(strList);

        //関数型ラストの問題
        List<Integer> l = List.of(1,3,5);
        Function<Integer, Integer> h = x -> x * x;

        List<Integer> result3 = Main.map(l, h);
        System.out.println(result3);


    }


    private static List<Integer> map(List<Integer> list, Function<Integer, Integer> f) {
        List<Integer> result = new ArrayList<>();
        for(Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }


}