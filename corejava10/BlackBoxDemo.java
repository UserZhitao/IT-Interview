import java.util.*;
/**
 * Created by wuyupku  on 2019年4月21日16:10:00
 */
public class BlackBoxDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = 0;//区间下界值
        int n = 0;//区间上界值
    
        while (true) {
            try {
                System.out.println("请输入待划分区间下界：");
                m = input.nextInt();
                System.out.println("您输入的区间下界为：" + m);
                System.out.println("请输入待划分区间上界：");
                n = input.nextInt();
                System.out.println("您输入的区间上界为：" + n);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;  //如果是整数，则退出while循环                
            } catch (Exception e) {  //这里用Exception来捕获这个异常
                e.printStackTrace();
                System.out.println("您输入的不是整数，请重新输入一个整数！");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
               input.next();  //继续输入  
                System.out.println("您输入的不是整数，请重新输入一个整数！");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                input.next();  //继续输入
            }
        }
    
        /**  1.区间范围判断
         * Created by wuyupku  on 2019年4月21日16:46:04
       */ 
        testOfRange(m, n);


        /**  2.等价类划分
         * Created by wuyupku  on 2019年4月21日16:46:28
       */       
        testOfEqualClass(m, n);

        /**  3.区边界值分析
         * Created by wuyupku  on 2019年4月21日16:46:37
       */ 
        System.out.print("请输入任意数： ");
    	int v = input.nextInt();
        testOfBoundry(m, n, v);

        /**  4.随机数生成器
         * Created by wuyupku  on 2019年4月21日16:46:04
       */ 
        
        System.out.print("请输入测试数量： ");
    	int num = input.nextInt();
        System.out.println("您输入的随机生成的数值为：" + num + "个");

        testOfRandom(m, n, num);
          
    }
  
    
    //1.区间范围判断方法
  static void testOfRange(int m, int n) {
	
	   boolean flag = false;
	   
       if (m <n){
           System.out.println("输入范围符合要求！");
           flag = true;
           System.out.println(flag);
           System.out.println("输入范围为[" + m + "," + n + "]");
       } else if(m>n){
    	   System.out.println("输入范围符合不要求！，因为下区间大于上区间！");
         System.exit(1);
       }
       
   }

		//2.等价类划分方法         
           public static void testOfEqualClass(int m, int n){
        	   if(m>n){
                   System.out.println("左边无效类为：" + "[" + Integer.MIN_VALUE + "," + n + ")");
                   System.out.println("右边无效类为：" + "(" + m + "," + Integer.MAX_VALUE + "]");
            }else if(m<n){   
            	System.out.println("左边无效类为：" + "[" + Integer.MIN_VALUE + "," + m + ")");
               System.out.println("右边无效类为：" + "(" + n + "," + Integer.MAX_VALUE + "]");
         
           }
           }
      

           //3.边界值分析方法 
        public static void testOfBoundry(int m, int n ,int v){
       
        	    
        	if(m<n){
        	if(v>=m && v<=n){	
        		  System.out.println("您输入的任意数"+v+"在：[" + m + ","  +n+"]之间");  }
        	else{
        		  System.out.println("您输入的任意数"+v+"不在：[" + m+ ","  +n+"]之间");  
        	}
            System.out.println("有效类的区间边界值为: 下界--->" + m + ", " + (m + 1) + ", " + (n - 1) + ", " + n+"<---上界");
            System.out.println("无效类的区间边界值(1)为：下界左边界" + (m - 1) + ", 上界右边界"  + (n + 1));
        }else if(m>n){
        	   System.out.println("有效类的区间边界值为: 下界" + n + ", " + (n + 1) + ", 上界" + (m - 1) + ", " + m);
               System.out.println("无效类的区间边界值(1)为：下界左" + (n- 1) + ",上界右"  + (m + 1));  
  
        
        	int a = Integer.MIN_VALUE;
           int b = a - 1;
           int c = Integer.MAX_VALUE;
           int d = c + 1;
        System.out.println("左无效类的边界值(2)为：" + b + "<---下界溢出, " + a + ", " + (a + 1));
        System.out.println("右无效类的边界值(3)为：" + (c - 1) + ", " + c + ", " + "上界溢出--->" + d);
        
        }
}

        //4.随机生成器对每个区间生成特定数量的随机数
        public static void testOfRandom(int m, int n, int num){
            if (num < (n-m)) {
                System.out.println("您输入数值有效！满足区间绝对值！");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else if (num > (n-m+1)) {
                System.out.println("您输入数值无效！越界！");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                return;
            } else if (num == (n-m+1)) {
                System.out.println("您输入数值有效！满足区间绝对值！");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
            }
        	if(n==m){  
        		num = n;
        		System.out.println("区间绝对长度为1，故有效随机数为原值："+num);
        		 Set<Integer> set01 = new HashSet<Integer>();
        	        boolean flag = true;
        	        while (true) {
        	            int z = (int) (Math.random() * (Math.abs(m)+Math.abs(n))%(m-n+1) + n);//[-10,10]先生成[0,20],再取模，再加小
        	            flag = set01.add(z);
        	            if (!flag) {
        	                continue;
        	            }
        	            if (set01.size() >= num) {
        	                break;
        	            }
        	        }
        	        System.out.println("系统随机生成数组"+ new TreeSet(set01));
        	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        	        for (Iterator iter = new TreeSet(set01).iterator(); iter.hasNext(); ) {
        	            Integer value = (Integer) iter.next();
        	            System.out.println("在您输入的有效区间["+n+","+m+"]内,随机生成的"+num+"个数的值分别为：" +value);
        	        }
        	        Set<Integer> set02 = new HashSet<Integer>();
        	            int x = (int) (Math.random() * (Integer.MAX_VALUE)%(Integer.MAX_VALUE-m+1) + m);//[-10,10]先生成[0,20],再取模，再加小
        	            set02.add(x);
        	        
        	        System.out.println("系统随机生成数组"+ new TreeSet(set02));
        	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        	

        	        Set<Integer> set03 = new HashSet<Integer>();
        	  
        	            int y = (int) (Math.random() * (Integer.MAX_VALUE)%(Integer.MAX_VALUE-Math.abs(n)+1) + Math.abs(n));
        	            int v = Math.negateExact(y);
        	            set03.add(v);
        	        
        	        System.out.println("系统随机生成数组"+ new TreeSet(set03));
        	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        	       
        	
        	}
        	else if(n != m){
            //随机生成num个不重复的有效随机数
            Random rand = new Random();
            int[] arr1 = new int[num];
            for (int i = 0; i < num; i++){
                int index = rand.nextInt(n - m + 1);
                arr1[i] = index;
                for (int j = 0; j < i; j++){
                    if (arr1[i] == arr1[j]){
                        i--;
                        break;
                    }
                }
            }
        	
            System.out.println("有效数为：");
            printWithNoRepition(arr1);
        	      		
            //随机生成num个不重复的左边无效成绩
            int[] arr2 = new int[num];
            for (int i = 0; i < num; i++){
                int index = (int)((rand.nextDouble() *(0.1 * m - 0.1 * Integer.MIN_VALUE + 1) * 10) + Integer.MIN_VALUE);
                arr2[i] = index;
                for (int j = 0; j < i; j++){
                    if (arr2[i] == arr2[j]){
                        i--;
                        break;
                    }
                }
            }
            System.out.println("\n左边无效成绩为：");
            printWithNoRepition(arr2);

            //随机生成num个不重复的右边无效成绩
            int[] arr3 = new int[num];
            for (int i = 0; i < num; i++){
                int index = (int)(Math.random() * (Integer.MAX_VALUE - n + 1)) ;
                arr3[i] = index;
                for (int j = 0; j < i; j++){
                    if (arr3[i] == arr3[j]){
                        i--;
                        break;
                    }
                }
            }
            System.out.println("\n右边无效成绩为：");
            printWithNoRepition(arr3);
        }
        }
        public static void printWithNoRepition(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if ((i + 1) % 10 == 0)
                    System.out.println(arr[i]);
                else
                    System.out.print(arr[i] + " ");
            }
        }

    }
