<a name="c32bd6c5"></a>
# javaSE knowledge review and study 

<a name="Day01"></a>
# Day01
<a name="8dc397df"></a>
## 1 idea的使用
<a name="458b1727"></a>
## 2 初识java: hello world
<a name="db6cc9b6"></a>
## 3 Scanner review
<a name="ee687580"></a>
## 4 数组 Array review :

**int[] arr = new int[]{10, 120}; int[] arr = new int[3]**

<a name="Day02"></a>
# Day02
<a name="14fb1c28"></a>
## 1 方法Method review：使用和重载
<a name="c4744bed"></a>
## 2 编程训练：复习之前的知识
<a name="e8d2cf92"></a>
### 2.1 买飞机票

![](https://raw.githubusercontent.com/Shmily33/picBed/main/202406081506390.png#id=eiyEj&originHeight=552&originWidth=1174&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

```java
package com.javase.exercise;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/15:08
 * @Description: 买飞机票
 */
public class BuyTickets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double prePrice = sc.nextDouble();
        int preMonth = sc.nextInt();
        String place = sc.next();
//        double currentPrice = ;
        System.out.println("机票原价为：" + prePrice + " 月份为：" + preMonth + " 优惠后票价为：" + buyTickets(prePrice, preMonth, place));

    }

    public static double buyTickets(double price, int month, String place) {
        double discount = 0;
        if (month <= 10 && month >= 5) {
            switch (place) {
                case "头等舱":
                    discount = 0.9;
                    break;
                case "经济舱":
                    discount = 0.85;
                    break;
            }

        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            switch (place) {
                case "头等舱":
                    discount = 0.7;
                    break;
                case "经济舱":
                    discount = 0.65;
                    break;
            }
        } else {
            System.out.println("月份输入有误");
            return 0;
        }
        //保留两位小数输出
        String temp = String.format("%.2f", price * discount);
        return Double.parseDouble(temp);
    }

}
```

<a name="85ba5d11"></a>
### tips：保留两位小数输出

![](https://raw.githubusercontent.com/Shmily33/picBed/main/202406081534560.png#id=VlSEF&originHeight=102&originWidth=528&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

<a name="141ceeda"></a>
### 2.2 开发验证码

![](https://raw.githubusercontent.com/Shmily33/picBed/main/202406081535543.png#id=EaSxN&originHeight=534&originWidth=1235&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

```java
package com.javase.exercise;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/15:37
 * @Description:
 */
public class CheckCode {

    public static void main(String[] args) {
        System.out.println("请输入需要几位验证码：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("验证码为：" + checkCode(num));
    }

    public static String checkCode(int num) {
        String res = "";
        //Random使用前要先创建Random对象
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int x = random.nextInt(3);//随机数：0 1 2
            switch (x) {
                case 0:
                    res +=  random.nextInt(10);
                    break;
                case 1:
                    res += (char) ('a' + random.nextInt(26));
                    break;
                case 2:
                    res += (char) ('A' + random.nextInt(26));
                    break;
            }
        }
        return res;
    }

}
```

<a name="05544d2d"></a>
### tips：Random使用前创建对象

![](https://raw.githubusercontent.com/Shmily33/picBed/main/202406081557782.png#id=amlU9&originHeight=318&originWidth=523&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

<a name="EyYx9"></a>
### 2.3 评委打分

![](https://raw.githubusercontent.com/Shmily33/picBed/main/202406081557059.png#id=rEtYS&originHeight=575&originWidth=1232&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
```java
package com.javase.exercise;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/16:02
 * @Description:
 */
public class JudgeAverageScore {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("评委人数：");
        int num = sc.nextInt();
        judgeAverageScore(num);

    }

    public static void judgeAverageScore(int num) {
        int[] scores = new int[num];
        Random random = new Random();
        //随机分数
        for (int i = 0; i < num; i++) {
            scores[i] = random.nextInt(101);//0-100
        }
        System.out.println("评分分数为：");
        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int s : scores) {
            System.out.print(s + " ");
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }
            sum += s;
        }
        System.out.println("最大值为：" + max + " 最小值为：" + min);
        double avg = (double) (sum - max - min) / (num - 2);
        System.out.println("去除最大最小后平均分为：" + avg);
    }

}

```
<a name="IOs8G"></a>
### 2.4 数字加密
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717834456547-fded1289-e165-4632-8dc1-3c9e237ad215.png#averageHue=%23f0eeed&clientId=u88f79660-fcbf-4&from=paste&height=446&id=u6005095e&originHeight=557&originWidth=1223&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=112666&status=done&style=none&taskId=u715c5bff-d7dd-4acd-b0a9-b76ddf01a88&title=&width=978.4)
```java
package com.javase.exercise;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/16:15
 * @Description:
 */
public class EncryptedPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("加密前：" + number + " 加密后：" + encryptPassword(number));
    }

    public static String encryptPassword(int password) {
        String temp = Integer.toString(password);
        String res = "";
        for (int i = 0; i < temp.length(); i++) {
            int x = temp.charAt(i) - '0';
            res += (x + 5) % 10;

        }
        //翻转字符串 reverse完还是StringBuilder对象，要toString一下
        StringBuilder result = new StringBuilder(res).reverse();
        return result.toString();
    }
}

```
<a name="mPNK5"></a>
### tips1：java字符串获取字符：charAt()
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717835153004-38083dbe-dd87-4464-94fe-ea07d28fb265.png#averageHue=%23d1bb76&clientId=u88f79660-fcbf-4&from=paste&height=281&id=uca5be52c&originHeight=351&originWidth=1400&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=30593&status=done&style=none&taskId=u965c2a1d-9dd4-46d4-8020-ebfd27892cd&title=&width=1120)
<a name="Y73TN"></a>
### tips2：翻转字符串StringBuilder
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717835570544-40c0a624-8a4d-4c30-a4fa-81134aad11d8.png#averageHue=%2323252b&clientId=u88f79660-fcbf-4&from=paste&height=92&id=ua233399f&originHeight=115&originWidth=699&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=20326&status=done&style=none&taskId=u97981bf3-e1aa-434e-89ea-1fd1d1a4f4f&title=&width=559.2)

