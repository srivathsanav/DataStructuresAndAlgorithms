package com.interviewbit.assignment.HackerRank;

/**
 * Created by srivathsan on 05/02/16.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

    public class MatchingQuestionsWithAnswers {

        public static List<String> stopwords = Arrays.asList("a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call","called", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "does", "done", "down", "due", "during", "each", "eg", "either", "else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "fill", "find", "fire", "for", "former", "formerly", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "i", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "no", "nobody", "noone", "nor", "nothing", "now", "nowhere", "of", "off", "on", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "so",  "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thick", "thin", "this", "those", "though", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the");

        private static boolean hasVowel(String word){
            String[] vowels = {"a","e","i","o","u","y"};
            for(String c : vowels){
                if(word.contains(c))
                    return true;
            }
            return false;
        }

        public static String stem(String word){
            int k = 0;
            String suffix = "";
            if (word.endsWith("s")){
                if(word.endsWith("sses") || word.endsWith("ies"))
                    k += 2;
                else if(word.length() > 2 && word.charAt(word.length()-2) != 's')
                    k++;
            }
            if ((word.endsWith("ed") || word.endsWith("ing")) && hasVowel(word)){
                k += 2;
                if(word.length() >= (k+2)){
                    String newEnd = word.substring(word.length()-k-2,word.length()-k);
                    if(newEnd.equals("at") || newEnd.equals("bl") || newEnd.equals("iz"))
                        suffix = "e";
                }
            }
            return word.substring(0,word.length()-k) + suffix;
        }

        public static List<String> getKeywords(String text){
            text = text.toLowerCase();
            text = text.trim();
            text = text.replaceAll("[,;:?!'\"]","");
            String[] words = text.split(" ");
            List<String> keywords = new ArrayList<String>();
            for(String w : words){
                if(!stopwords.contains(w))
                    keywords.add(stem(w));
            }
            return keywords;
        }

        public static String getSentence(String text, List<String> qKeys){
            text = text.toLowerCase().replaceAll("etc.","etc").replaceAll("inc.","inc");
            String[] sentences = text.split("[.!?]");

            Map<String,Integer> mapCount = new HashMap<String,Integer>();
            String sentence = "";
            double maxMatch = -1.0;
            int j = 0;
            List<Integer> maxInds = new ArrayList<Integer>();
            List<List<String>> listSKeys = new ArrayList<List<String>>();
            for(String sent : sentences){
                List<String> matchedSentKeys = new ArrayList<String>();
                sent = sent.trim();
                double match = 0;
                for(String key : qKeys){
                    if(sent.contains(key)){
                        match++;
                        matchedSentKeys.add(key);
                        addToMap(mapCount,key);
                    }
                }
                match = match / (double) qKeys.size();
                if(match > maxMatch){
                    maxMatch = match;
                    maxInds = new ArrayList<Integer>();
                    maxInds.add(j);
                }
                else if(match == maxMatch)
                    maxInds.add(j);

                listSKeys.add(matchedSentKeys);
                j++;
            }

            if(maxInds.size() == 1){
                System.err.println("SENTENCE ONLY ONE");
                return sentences[maxInds.get(0)];
            }
            else{
                List<List<String>> maxMatchListSKeys = new ArrayList<List<String>>();
                for(int ind : maxInds){
                    maxMatchListSKeys.add(listSKeys.get(ind));
                }
                int i = 0;
                int minLength = Integer.MAX_VALUE;
                double maxUniquePrct = 0;
                int maxUnique = 0;
                String minLengthAns = "";
                String maxUniqueAns = "";
                for(List<String> aks : maxMatchListSKeys){
                    int unique = 0;
                    for(String k : aks){
                        if(mapCount.get(k) == 1)
                            unique++;
                    }
                    double uniquePrct = (double)unique/(double)aks.size();
                    if(uniquePrct > maxUniquePrct || (uniquePrct == maxUniquePrct && unique > maxUnique)){
                        maxUniquePrct = uniquePrct;
                        maxUnique = unique;
                        maxUniqueAns = sentences[maxInds.get(i)];
                    }
                    if(aks.size() < minLength){
                        minLength = aks.size();
                        minLengthAns = sentences[maxInds.get(i)];
                    }
                    i++;
                }
                if(maxUnique > 0){
                    System.err.println("SENTENCE UNIQUE KEYWORD");
                    return maxUniqueAns;
                }
                else{
                    System.err.println("SENTENCE SMALLER LENGTH");
                    return minLengthAns;
                }
            }
        }

        public static double getMatches(String sentence, List<String> answerKeywords){
            int matches = 0;
            for(String ak : answerKeywords){
                if(sentence.contains(ak)){
                    sentence = sentence.replaceFirst(ak,"");
                    matches++;
                }
            }
            return (double) matches/ (double) answerKeywords.size();
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            String[] questions = new String[5];
            for(int i = 0; i < 5; i++)
                questions[i] = in.nextLine();
            String[] answers = in.nextLine().split(";");

            for(int i = 0; i < 5; i++){
                String question = questions[i];
                List<String> qKeywords = getKeywords(question);
                System.err.println("_____________________");
                System.err.print(questions[i] + " : ");
                for(String qk : qKeywords)
                    System.err.print(qk + " ");
                System.err.println();
                String sentence = getSentence(text,qKeywords);
                System.err.println(sentence);
                System.out.println(bestAnswer(sentence,qKeywords,answers));
            }
        }

        public static String bestAnswer(String sentence, List<String> qKeywords, String[] answers){
            Map<String,Integer> mapCountKeywordsAnswers = new HashMap<String,Integer>();

            double maxMatch = -1.0;
            double matches = -1.0;
            List<Integer> maxAnswerKeys = new ArrayList<Integer>();
            for(int j = 0; j < 5; j++){
                String answer = answers[j];
                List<String> answerKeywords = getKeywords(answer);
                matches = getMatches(sentence,answerKeywords);
                if(matches > maxMatch){
                    maxMatch = matches;
                    maxAnswerKeys = new ArrayList<Integer>();
                    maxAnswerKeys.add(j);
                }
                else if(matches == maxMatch)
                    maxAnswerKeys.add(j);

                String akeysString = "";
                for(String ak : answerKeywords){
                    if(!akeysString.contains(ak))
                        addToMap(mapCountKeywordsAnswers,ak);
                    akeysString += ak + ",";
                }
                System.err.println(answers[j] + " [ " + akeysString + "] " + ". Matches: " + matches);
            }

            if(maxAnswerKeys.size() == 1){
                System.err.println("ONLY ONE");
                return answers[maxAnswerKeys.get(0)];
            }
            else{
                List<List<String>> listAnsKeys = getKeysFromInds(maxAnswerKeys,answers);
                int i = 0;
                int maxLength = -1;
                double maxUniquePrct = 0;
                int maxUnique = 0;
                String maxLengthAns = "";
                String maxUniqueAns = "";
                for(List<String> aks : listAnsKeys){
                    int unique = 0;
                    for(String k : aks){
                        if(mapCountKeywordsAnswers.get(k) == 1)
                            unique++;
                    }
                    double uniquePrct = (double)unique/(double)aks.size();
                    if(uniquePrct > maxUniquePrct || (uniquePrct == maxUniquePrct && unique > maxUnique)){
                        maxUniquePrct = uniquePrct;
                        maxUnique = unique;
                        maxUniqueAns = answers[maxAnswerKeys.get(i)];
                    }
                    else if(uniquePrct == maxUniquePrct && unique == maxUnique){
                        List<String> neighbors1 = getNeighbors(sentence,maxUniqueAns,3);

                        String possAns = answers[maxAnswerKeys.get(i)];
                        List<String> neighbors2 = getNeighbors(sentence,possAns,3);

                        int count1 = numNeighborsPresent(qKeywords,neighbors1);
                        int count2 = numNeighborsPresent(qKeywords,neighbors2);
                        if(count1 < count2)
                            maxUniqueAns = possAns;
                    }
                    if(aks.size() > maxLength){
                        maxLength = aks.size();
                        maxLengthAns = answers[maxAnswerKeys.get(i)];
                    }
                    i++;
                }
                if(maxUnique > 0){
                    System.err.println("UNIQUE KEYWORD");
                    return maxUniqueAns;
                }
                else{
                    System.err.println("GREATER LENGTH");
                    return maxLengthAns;
                }
            }

        }

        public static int numNeighborsPresent(List<String> qKeys, List<String> neighbors){
            int num = 0;
            for(String n : neighbors){
                if(qKeys.contains(n)){
                    num++;
                    qKeys.remove(n);
                }
            }
            return num;
        }

        public static List<String> getNeighbors(String sentence, String answer, int num){
            List<String> akeys = getKeywords(answer);
            List<String> res = new ArrayList<String>();
            String[] sentSplit = sentence.split(" ");
            for(String ak : akeys){
                for(int i = 0; i < sentSplit.length;i++){
                    if(sentSplit[i].contains(ak)){
                        for(int j = 1; j <= num; j++){
                            if(i >= j){
                                res.add(stem(sentSplit[i-j]));
                            }
                            if(i+j < sentSplit.length){
                                res.add(stem(sentSplit[i+j]));
                            }
                        }
                    }
                }
            }
            return res;
        }

        public static List<List<String>> getKeysFromInds(List<Integer> maxInds,String[] texts){
            List<List<String>> res = new ArrayList<List<String>>();
            for(int i : maxInds){
                String t = texts[i].trim();
                List<String> kwords = getKeywords(t);
                res.add(kwords);
            }
            return res;
        }

        public static void addToMap(Map<String,Integer> map, String key){
            Integer count = map.get(key);
            if(count == null)
                count = 1;
            else
                count = count + 1;
            map.put(key,count);
        }


    }

