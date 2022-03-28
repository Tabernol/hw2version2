package hillel.hw3;

public class ReversString {
    private String str = "ZюукяДZіботZ,ежобZощZяZенZ!ьлаксом";

    public static void main(String[] args) {
        ReversString r = new ReversString();
        r.reverseWordInString();
    }

    public void reverseWordInString() {
        str = str.replace("Z", " ");
        String[] array = str.split(" ");
        String rezult = "";
        for (int i = 0; i < array.length; i++) {
            String s = new StringBuilder(array[i]).reverse().toString();
            rezult = rezult.concat(s).concat(" ");
        }
        System.out.println(rezult);
    }

    public void reverseWordInString2() {
        String[] array = str.split("Z");
        String rezult = "";
        for (int i = 0; i < array.length; i++) {
            int index = 0;
            for (int j = array[i].length() - 1; j >= 0; j--) {
                char[] chararray = new char[array[i].length()];
                chararray[index] = array[i].charAt(j);
                rezult = rezult.concat(String.valueOf(chararray[index]));
                index++;
            }
            rezult = rezult.concat(" ");
        }
        System.out.println(rezult);
    }
}
