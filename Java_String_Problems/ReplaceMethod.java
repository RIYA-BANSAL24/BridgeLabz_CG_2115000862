public class ReplaceMethod {
    public static void main(String[] args) {
        String sentence = "Java is a programming language.";
        String wordToReplace = "Java";
        String replacementWord = "Python";

        String newSentence = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("New Sentence: " + newSentence);
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        return sentence.replaceAll("\\b" + wordToReplace + "\\b", replacementWord);
    }
}
