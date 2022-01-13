import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // System.out.println("Say Hello!");

        // int[] score = new int[5];
        // int k = 1;

        // score[0] = 50;
        // score[1] = 60;
        // score[k + 1] = 70; // score[1 + 1] score[2]
        // score[3] = 80;
        // score[4] = 90;

        // for(int i=0; i<5; i++){
        // // System.out.printf("score[%d]:%d%n", i, score[i]);
        // }

        // System.out.println(score[4]);

        // System.out.println(score.length);

        // System.out.println(score[-1]);

        // int[] score = new int[]{50, 60, 70, 80, 90};

        // for(int i=0; i< 5; i++) {
        // System.out.println(score[i]);
        // }

        // char[] chArr = new char[]{'A', 'B', 'C', 'D', 'E'};

        // String[] strArr = new String[]{"A", "B", "C", "D", "E"};

        // // char[] chArr = new char[]{'A', 'B', 'C', 'D', 'E'};
        // String str = "";
        // int total = 0;
        // for(char i:chArr){
        // str += i + "\n";
        // }
        // System.out.println(str);

        // boolean[] boolArr = new boolean[] {true, false, true, true, false};

        // boolean boolArr[] = new boolean[] { true, false, true, true, false };

        // for (int i = 0; i < boolArr.length; i++) {
        // System.out.printf("boolArr[%d] : %s%n", i, boolArr[i]);
        // }

        // boolean [] boolArr = new boolean [5];
        // for(int i=0; i<boolArr.length; i++){
        // if(i==0 || i/2==1){
        // boolArr[i]=true;
        // }
        // System.out.println(boolArr[i]);
        // }

        // boolean [] boolArr = new boolean [] {true,false,true,true,false};
        // for (int i = 0; i < boolArr.length; i++) {
        // System.out.println(boolArr[i]);
        // }

        // boolean[] boolArr = new boolean[] {true, false, true, true, false};

        // for(int i=0; i<5; i++) {
        // System.out.println(boolArr[i]);
        // }

        // boolean[] boolArr = new boolean[]{true, false, true, true, false};
        // for(int i=0;i<5;i++){
        // System.out.println(boolArr[i]);
        // }

        // int[] score = new int[]{50, 60, 70, 80, 90};
        // System.out.printf("%d + %d = %d%n",score[0], score[score.length-1],
        // score[0]+score[score.length-1]);

        // int [] score = new int[5];
        // for(int i = 0; i < score.length; i++) {
        // score[i] = 50 + (i*10);
        // }
        // System.out.println("처음값 + 마지막값 = " + (score[0] + score[score.length-1]));

        // int[] score = new int[]{50, 60, 70, 80, 90};
        // int total = score[0] + score[score.length-1];
        // System.out.println(total);

        // int[] score = new int[] { 50, 60, 70, 80, 90 };
        // System.out.println(score[0] + score[score.length-1]);

        // int[] score = {50, 60, 70, 90, 90};
        // int value = score[0] + score[4];
        // System.out.println(value);
        // int[] score = new int[]{50, 60, 70, 80, 90};
        // System.out.printf("%d",score[0]+score[score.length-1]);

        // int[] score = {79, 88, 91, 33, 10, 55, 95, 3434, 22, 1, 33, 15, -1};

        // int max = score[0]; // 79
        // int min = score[0]; // 79

        // for(int i=1; i < score.length; i++) {
        // if(score[i] > max) {
        // max = score[i];
        // } else if(score[i] < min){
        // min = score[i];
        // }
        // }

        // System.out.println("max:" + max);
        // System.out.println("min:" + min);

        // int a = 10, b = 20, temp = 0;

        // System.out.println("a 는 " + a);
        // System.out.println("b 는 " + b);

        // // a와 b 값을 교환하시오.

        // System.out.println("a 는 " + a);
        // System.out.println("b 는 " + b);

        // int[] intArr = new int[] {75, 100, 85, 60, 95};

        // // 알고리즘

        // int[] arr = new int[]{75, 100, 85, 60, 95};
        // int tmp;
        // for(int i=0; i<arr.length; i++){
        // for(int j=0; j<arr.length-1; j++){
        // if(arr[i] > arr[j]){
        // tmp = arr[i];
        // arr[i] = arr[j];
        // arr[j] = tmp;
        // }
        // }
        // }
        // for(int a=0; a<arr.length; a++){
        // System.out.printf("%d등 %d점\n", a+1, arr[a]);
        // }

        // 결과
        // 75 4
        // 100 1
        // 85 3
        // 60 5
        // 95 2

        // int score [] = {75,100,85,60,95};
        // int rank [] = new int [5];
        // Arrays.fill(rank,1);
        // for(int i=0; i<score.length; i++){
        // for(int j=0; j<score.length; j++){
        // if(score[i]<score[j]){
        // rank[i]++;
        // }
        // }
        // }
        // for(int i=0; i<score.length; i++){
        // System.out.println("점수: " + score[i] + " 등수: " + rank[i]);
        // }

        // int[] arr = new int[]{75,100,85,60,95};
        // int[] arrrank = new int[arr.length];

        // for(int i = 0; i < arr.length; i++){
        // arrrank[i]++;
        // for(int j = 0; j < arr.length; j++){
        // if(arr[i] < arr[j]){
        // arrrank[i]++;
        // }
        // }
        // }
        // for(int i = 0; i < arr.length; i++){
        // System.out.println(arr[i] +" "+ arrrank[i]);
        // }

        // int[] score = new int[] { 75, 100, 85, 60, 95 };
        // int[] rank = new int[score.length];

        // for (int i = 0; i < score.length; i++) {
        // rank[i] = 1;
        // for (int j = 0; j < score.length; j++) {
        // if (score[i] < score[j]) {
        // rank[i] += 1;
        // }
        // }
        // }
        // System.out.println("score rank");
        // for (int i = 0; i < score.length; i++) {
        // System.out.printf("%d\t%d%n", score[i], rank[i]);
        // }

        // int[] score = new int[]{75, 100, 85, 60, 95};

        // int tmp;

        // for(int i=0;i<score.length;i++){
        // for(int j=0;j<score.length;j++){
        // if(score[i]>score[j]){
        // tmp = score[i];
        // score[i] = score[j];
        // score[j] = tmp;
        // }
        // }

        // }

        // System.out.println("score rank");
        // for(int i=0;i<score.length;i++){
        // System.out.printf("%d %d%n", score[i], i+1);
        // }

        // int[] arr = { 75, 100, 85, 60, 95 };
        // System.out.println("score rank");
        // for (int i : arr) {
        // int rank = 1;
        // for (int j : arr) {
        // if (i < j) {
        // rank++;
        // }
        // }
        // System.out.println(i + " " + rank);
        // }

        // int [] score = new int [] {75,100,85,60,95};
        // int [] rank = new int [] {1,1,1,1,1};

        // for (int i = 0; i < score.length; i++) {
        // rank[i] = 1;
        // for(int j = 0; j<score.length; j++){
        // if(score[i] < score[j]) {
        // rank[i] += 1;
        // }
        // }
        // }
        // for(int k = 0; k < score.length; k++) {
        // System.out.println("점수 : "+ score[k]+" 순위 : "+rank[k]);
        // }

        // int[] arr = {75, 100, 85, 60, 95};
        // Arrays.sort(arr);
        // for(int i = 0; i<arr.length; i++){
        // System.out.printf("%d %d \n",arr[i],(arr.length-i));
        // }

        // int[] numArr = new int[10];
        // for (int i = 0; i < numArr.length; i++) {
        // numArr[i] = i;
        // System.out.println(numArr[i]);
        // }

        // for (int i = 0; i < 100; i++) {
        // int n = (int) (Math.random() * 10);
        // int tmp = numArr[0];
        // numArr[0] = numArr[n];
        // numArr[n] = tmp;
        // }

        // for (int i = 0; i < numArr.length; i++)
        // System.out.print(numArr[i] + "\n");

        // int[] arr = new int[6];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = (int) (Math.random() * 36);
        // }

        // System.out.println("이번주 로또 번호입니다.");
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        // int num = 2860;

        // System.out.println("거스름돈 : " + num + "원");
        // System.out.print("500원 : " + num/500 + "개");
        // num %= 500;
        // System.out.print("100원 : " + num/100 + "개");
        // num %= 100;
        // System.out.print("50원 : " + num/50 + "개");
        // num %= 50;
        // System.out.print("10원 : " + num/10 + "개");

        // int money = 2860;
        // int[] chg= new int[]{500, 100, 50, 10};
        // int[] chgCnt = new int[4];

        // for (int i=0; i<chg.length; i++){
        // if(money >= chg[i]){
        // chgCnt[i] = money/chg[i];
        // money = money - chgCnt[i]*chg[i];
        // System.out.printf("%d원 %d개 \n", chg[i], chgCnt[i]);
        // }
        // }

        // Scanner sc = new Scanner(System.in);
        // int money = sc.nextInt();
        // int[] mon = {500, 100, 50, 10};
        // for(int i = 0; i<4; i++){
        // System.out.println("몇개?" + money/mon[i]);
        // money = money%mon[i];
        // System.out.println("얼마남음?" + money);
        // }

        // int money = 2860;
        // int[] coin = new int[] { 500, 100, 50, 10 };

        // int count = 0;

        // for (int i = 0; i < coin.length; i++) {
        // count += money / coin[i]; // 낸돈에서 500원짜리부터 나눈 몫을 count에 더해줌
        // money %= coin[i]; // 낸돈에서 500짜리부터 나눈 나머지를 다시 money에 할당
        // }

        // System.out.println("거슬러줄 동전 개수 : " + count);

        // int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
        // for (int i = 0; i < arr.length; i++) {
        // int minIndex = i;

        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[minIndex] > arr[j]){
        // minIndex = j;
        // }
        // }

        // int tmp = arr[i];
        // arr[i] = arr[minIndex];
        // arr[minIndex] = tmp;
        // System.out.println(Arrays.toString(arr));
        // }
        // System.out.println(Arrays.toString(arr));

        // int [] arr = {7,5,9,0,3,1,6,2,4,8};
        // for(int i = 0; i < arr.length-1; i++){
        // int minIndex = i;
        // for(int j = i + 1; j < arr.length; j++){
        // if(arr[minIndex] > arr[j])
        // minIndex = j;
        // }
        // int tmp = arr[i];
        // arr[i] = arr[minIndex];
        // arr[minIndex] = tmp;
        // }
        // System.out.println("<선택정렬>");
        // System.out.println(Arrays.toString(arr));

        // int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        // int tmp;
        // for(int i = 0; i < arr.length; i++){
        // int minIndex = i;
        // for(int j = i+1; j<arr.length; j++){
        // if(arr[minIndex] > arr[j]){
        // minIndex = j;
        // }
        // }
        // tmp = arr[i];
        // arr[i] = arr[minIndex];
        // arr[minIndex] = tmp;
        // }
        // System.out.println(Arrays.toString(arr));

        // int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

        // for (int i = 1; i < arr.length; i++) {
        // for (int j = i; j >= 1; j--) {
        // if (arr[j] < arr[j - 1]) {
        // int tmp = arr[j];
        // arr[j] = arr[j - 1];
        // arr[j - 1] = tmp;
        // } else
        // break;
        // }
        // System.out.println(Arrays.toString(arr));
        // }

        // System.out.println(Arrays.toString(arr));

        // int array[] = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        // quickSort(array, 0, array.length - 1);

        // for (int i : array) {
        // System.out.printf("%d ", i);
        // }

        // String[] name = new String[3];
        // name[0] = "kim";
        // name[1] = "park";
        // name[2] = "yi";

        // for (String string : name) {
        // System.out.println(string);
        // }

        // 향상된 for 문을 사용해 String 배열 name의 값을 출력하시오.
        // String str = "ABCDE";
        // char ch = str.charAt(3);
        // System.out.println(ch);
        // for (char string : str.toCharArray()) {
        // System.out.println(string);
        // }
        // String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다.
        // name[0] = "kimasldfkjastestkldf";
        // name[1] = "parsadfsadhellosadfk";
        // name[2] = "yasdfsadfsadfsadfi";

        // for (String string : name) {
        // if(string.contains("hello")) {
        // System.out.println(string);
        // System.out.println("안녕하세요.");
        // } else {
        // System.out.println(string);
        // System.out.println("안녕히 가세요.");
        // }
        // }

        // Kim
        // Park
        // Yi

        // for (String string : name) {
        // System.out.println((string.charAt(0) + "").toUpperCase()
        // + string.substring(1));
        // }

        // String text = "one,two,three";
        // String[] textArr = text.split(",");
        // for (String string : textArr) {
        // System.out.println(string);
        // }

        // int[][] arr = new int[2][3];
        // int k = 10;
        // // System.out.println(arr.length * arr[0].length);;
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // arr[i][j] = k; // 인덱스를 이용한 초기화
        // k += 10;
        // }
        // }

        // System.out.println(Arrays.toString(arr[0]));
        // System.out.println(Arrays.toString(arr[1]));

        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }

        // System.out.println();
        // }

        // int[][] arr = {
        //         { 1110, 20, 33 },
        //         { 40, 50, 60 }
        // };

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }

        //     System.out.println();
        // }

        // TV t;
        // t = new TV();

        TV t = new TV();
        t.channel = 7;
        t.channerlDown();
        System.out.println("현재 채널은 " + t.channel + " 입니다.");
    }

    

    // public static void quickSort(int array[], int start, int end) {
    // System.out.println(Arrays.toString(array));

    // if(start>=end)
    // return;

    // int pivot = start;
    // int left = start + 1;
    // int right = end;

    // while(left <= right) {
    // while(left <= end && array[left] <= array[pivot])
    // left += 1;

    // while(right > start && array[right] >= array[pivot])
    // right -= 1;

    // if(left > right) {
    // int tmp = array[right];
    // array[right] = array[pivot];
    // array[pivot] = tmp;
    // } else {
    // int tmp = array[right];
    // array[right] = array[left];
    // array[left] = tmp;
    // }

    // quickSort(array, start, right - 1);
    // quickSort(array, right + 1, end);
    // }
    // }
}

