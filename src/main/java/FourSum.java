package com.interviewbit.assignment;

import java.util.*;

/**
 * Created by srivathsan on 07/11/15.
 */
public class FourSum {



    public ArrayList<ArrayList<Integer>> fourSum1(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }


    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Result>> resultSet = new ArrayList<ArrayList<Result>>();
        ArrayList<Result> resultUnsorted = new ArrayList<Result>();


        HashMap<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
        for (int  i =0 ; i < a.size(); i++)  {
            for (int j = i+1; j < a.size(); j++) {
                int valNeeded = b - a.get(i) - a.get(j);
                if (map.get(valNeeded) == null)   {
                    populateMap(a, map, i, j);
                } else {
                    List<Node> list = map.get(valNeeded);
                    for (Node node : list) {
                        if (i != node.getFirstIndex() && i != node.getSecondIndex() &&
                                j != node.getFirstIndex() && j != node.getSecondIndex()) {
                                int first = a.get(node.getFirstIndex());
                                int second = a.get(node.getSecondIndex());
                                int third = a.get(i);
                                int foruth = a.get(j);

                                if (first <= second && first <= third && first <= foruth && second <= third && second <= foruth && third <= foruth) {
                                     Result r = new Result(first, second, third, foruth);
                                    if (!resultUnsorted.contains(r)) {
                                        resultUnsorted.add(r);
                                    }
                                }
                        }
                    }
                    populateMap(a, map, i, j);
                }
            }

        }
        Collections.sort(resultUnsorted);
        resultSet.add(resultUnsorted);

        for (int i =0; i < resultSet.size(); i++) {
            ArrayList<Result> result = resultSet.get(i);
            for (int j =0; j < result.size(); j++) {
                ArrayList<Integer> values = new ArrayList<Integer>();
                values.add(result.get(j).getFirst());
                values.add(result.get(j).getSecond());
                values.add(result.get(j).getThird());
                values.add(result.get(j).getFourth());
                returnList.add(values);


            }

        }
        return  returnList;
    }

    private void populateMap(ArrayList<Integer> a, HashMap<Integer, List<Node>> map, int i, int j) {
        List<Node> list;
        if (map.get(a.get(i)+a.get(j)) == null) {
             list = new ArrayList<Node>();
        } else {
            list = map.get(a.get(i)+a.get(j));
        }
        list.add(new Node(i, j));
        map.put(a.get(i)+a.get(j), list);
    }


    class Result implements Comparable<Result> {
        int first;
        int second;
        int third;
        int fourth;

        public Result(int first, int second, int third, int fourth) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
        }


        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getThird() {
            return third;
        }

        public int getFourth() {
            return fourth;
        }

        public int compareTo(Result o) {
            if (first < o.first) {
                return -1;
            } else if (first > o.first) {
                return 1;
            } else if (first == o.first) {
                if (second < o.second) {
                    return -1;
                } else if (second > o.second) {
                    return 1;
                } else if (second == o.second) {
                    if (third < o.third) {
                        return -1;
                    } else if (third > o.third) {
                        return 1;
                    } else if (third == o.third) {
                        if (fourth < o.fourth) {
                            return -1;
                        } else if (fourth > o.fourth) {
                            return 1;
                        } else if (fourth == o.fourth) {
                            return 0;
                        }
                    }
                }
            }
            return -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Result result = (Result) o;

            if (first != result.first) return false;
            if (second != result.second) return false;
            if (third != result.third) return false;
            return fourth == result.fourth;

        }

        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            result = 31 * result + third;
            result = 31 * result + fourth;
            return result;
        }
    }
    class Node {
        int firstIndex;
        int secondIndex;

        public Node(int firstIndex, int secondIndex) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public int getSecondIndex() {
            return secondIndex;
        }
    }

    public static void main(String[] args) {
      //  System.out.println(new FourSum().fourSum(new ArrayList<Integer>(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2)), 0));
        System.out.println(new FourSum().fourSum1(new ArrayList<Integer>(Arrays.asList(1, 0, -1, 0, -2, 2)), 0));
    }
}
