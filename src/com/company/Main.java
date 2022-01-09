package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        ArrayList<Integer> fibs=new ArrayList<Integer>();
        fibs.add(1);
        fibs.add(1);
        for(int i=2;i<=n;i++){
            fibs.add(fibs.get(i-1)+fibs.get(i-2));
        }
        return fibs.get(n);

    }
    public static int removeElement(int[] nums, int val) {
       /* if(nums.length==0){
            return 0;
        }
        if(nums.length==1&nums[0]==val){
            return 0;
        }
        int index=nums.length-1;
        int i=0;
        for (;i < index;) {
            if(nums[i]==val){
               nums[i]=nums[index--];
            }
            else{
                i++;
            }
        }
        return i+1;
        */
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=val){
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size() ; i++) {
            nums[i]= list.get(i);
        }
        return list.size();
    }
    public static int removeDuplicates(int[] nums) {
        Set<Integer> numbers=new HashSet<>();
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(numbers.add(nums[i])){
                nums[index++]=nums[i];
            }
        }
        return numbers.size();
    }
    public static String addBinary(String a, String b) {
        StringBuilder bBuilder = new StringBuilder(b);
        StringBuilder aBuilder = new StringBuilder(a);
        while (aBuilder.length()!= bBuilder.length()){
            if(aBuilder.length()< bBuilder.length()){
                aBuilder.insert(0, '0');
            }
            else{
                bBuilder.insert(0, '0');
            }
        }
        boolean next=false;
        StringBuilder result= new StringBuilder();
        for (int i = aBuilder.length()-1; i >=0 ; i--) {
            if(aBuilder.charAt(i)=='0'&bBuilder.charAt(i)=='0'){
                if(next){
                    result.insert(0, '1');
                }
                else{
                    result.insert(0, '0');
                }
                next=false;
            }
            if(aBuilder.charAt(i)=='0'&bBuilder.charAt(i)=='1'|aBuilder.charAt(i)=='1'&bBuilder.charAt(i)=='0'){
                if(next){
                    result.insert(0, '0');
                    next=true;
                }
                else{
                    result.insert(0, '1');
                    next=false;
                }
            }
            if(aBuilder.charAt(i)=='1'&bBuilder.charAt(i)=='1'){
                if(next){
                    result.insert(0, '1');
                }
                else{
                    result.insert(0, '0');
                }
                next=true;
            }
        }
        if(next){
            result.insert(0, '1');
        }
        return result.toString();
    }
    public static int[] sortArrayByParityII(int[] nums) {
        int []temp=new int[nums.length];
        int p=0,n=1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                temp[p]=nums[i];
                p+=2;
            }else{
                temp[n]=nums[i];
                n+=2;
            }
        }
        return temp;
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while(current!=null){
            ListNode next=current.next;
            if(next!=null){
                if(current.val == next.val){
                    current.next=next.next;
                    continue;
                }
            }
            current=current.next;
        }
        return head;
    }
    public static int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        if(digits[digits.length-1]<10){
            return digits;
        }
        for (int i = digits.length-1; i >=1; i--) {
            if(digits[i]==10){
                digits[i-1]++;
                digits[i]=0;
            }
        }
        if(digits[0]!=10){
            return digits;
        }
        int [] newDigits=new int[digits.length+1];
        System.arraycopy(digits,0 ,newDigits, 1,digits.length);
        newDigits[0]=1;
        newDigits[1]=0;
        return newDigits;

    }
    public static  int searchInsert(int[] nums, int target) {
        int startIndex=Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }

            if(nums[i]>target){
                startIndex=i;
                break;
            }
        }

        if(startIndex==Integer.MIN_VALUE){
            return nums.length;
        }

        if(startIndex<0){
            return 0;
        }

        return startIndex;
    }
    public int mySqrt(int x) {

        for (int i = 1; i <=x; i++) {
            if(i*i<=x&(i+1L)*(i+1L)>x){
                return i;
            }
        }
        return 0;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        boolean zero=false;
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                   if(i==j || i==k || j==k){
                       continue;
                   }

                   if(nums[i]==0&nums[j]==0&nums[k]==0){
                        zero=true;
                        continue;
                   }

                   if(nums[i]+nums[j]+nums[k]==0){
                       boolean insert=true;
                       for(List<Integer> r : result)
                           if (r.containsAll(Arrays.asList(nums[i], nums[j], nums[k]))) {
                               insert = false;
                               break;
                           }

                       if(insert)
                           result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                   }
                }
            }
        }
        result.add(new ArrayList<>(Arrays.asList(0,0,0)));
        return result;
    }
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int cnt=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
               break;
            }
            cnt++;

        }
        return cnt;
    }
    public static int maxSubArray(int[] nums) {
        int sumMax=nums[0];
        int sum=0;
        for(int num : nums ){
            if(sum<0){
                sum=0;
            }
            sum+=num;
            if(sumMax<sum){
                sumMax=sum;
            }

        }
        return sumMax;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class StaticTutorial{
    public static int B;
    public static int H;
    public static boolean flag=false;
    static {
        try {
            B=initialize();
            H = initialize();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int initialize() throws Exception {
        Scanner sc=new Scanner(System.in);
        int value=sc.nextInt();
        if(value>=0){
            return value;
        }
        throw new Exception("java.lang.Exception: Breadth and height must be positive ");
    }
}

