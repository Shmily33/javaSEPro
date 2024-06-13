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
<a name="RI7Bt"></a>
#### 方式1：Random

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
<a name="Mh3hX"></a>
#### 方式2：使用随机字符串的方式
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718172856215-50e686b6-dc6e-4af4-92e6-c262fa5fe607.png#averageHue=%231f2024&clientId=u5b964048-bcaf-4&from=paste&height=238&id=u922b77b5&originHeight=298&originWidth=1025&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=46399&status=done&style=none&taskId=u04a0beb0-7039-4644-b455-0e80537d9b6&title=&width=820)

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
<a name="uYDSY"></a>
## 3 ObjectOrientedProgramming
<a name="WIWXk"></a>
### 3.1 QuickStart
<a name="wWEcH"></a>
### 3.2 this
<a name="pjbhz"></a>
### 3.3 constructor
<a name="Iixw9"></a>
### 3.4 homework
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717854010351-8d125066-1362-4502-9aa8-5e297aabaa51.png#averageHue=%23ece9e8&clientId=u3393bfb7-aa6a-4&from=paste&height=613&id=ube4f18b2&originHeight=766&originWidth=698&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=68182&status=done&style=none&taskId=uc2b72980-ce83-4e22-bbf2-bb4ae704139&title=&width=558.4)
<a name="AExji"></a>
#### MyAnswer：
Rectangle类：<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717854090931-16a03088-7416-44b2-a47e-8a52adb5a8c4.png#averageHue=%231f2024&clientId=u3393bfb7-aa6a-4&from=paste&height=513&id=u14950bac&originHeight=641&originWidth=709&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=59837&status=done&style=none&taskId=u5fc7cebb-a67c-419f-bdd9-7718ee97b6c&title=&width=567.2)<br />RectangleOperator：<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717854141938-60e3dd0f-c7e7-4d8a-8c7e-535ab9b79a1b.png#averageHue=%231f2024&clientId=u3393bfb7-aa6a-4&from=paste&height=604&id=u6569045c&originHeight=755&originWidth=1083&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=102311&status=done&style=none&taskId=u869df02b-cfbe-4d5c-9bc0-bd7a85da71f&title=&width=866.4)<br />Test：<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1717854057625-fa1edc74-00e7-43df-9470-913c0b800a62.png#averageHue=%23202226&clientId=u3393bfb7-aa6a-4&from=paste&height=466&id=u39e77170&originHeight=582&originWidth=1011&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=80573&status=done&style=none&taskId=u7258a2e5-56e4-41b5-9386-8596c3c59aa&title=&width=808.8)
<a name="bRcoE"></a>
# Day03
<a name="XheAd"></a>
## 1 包的概念及自动导包
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718181809757-b139e131-8dcf-4d88-afaf-29e86ca75348.png#averageHue=%23242629&clientId=u7b60391d-7b42-4&from=paste&height=579&id=u459f454f&originHeight=724&originWidth=1379&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=126503&status=done&style=none&taskId=uab0a7258-75c8-4b25-96ef-69c53ae8988&title=&width=1103.2)
<a name="kRQJN"></a>
## 2 String
<a name="wr94E"></a>
### 2.1 定义一个方法用于判断一个字符串是否是对称的字符串
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718181865187-e321e464-83b8-4213-af35-b1d27e29c567.png#averageHue=%23232529&clientId=u7b60391d-7b42-4&from=paste&height=700&id=ud21f02e7&originHeight=875&originWidth=1904&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=169501&status=done&style=none&taskId=uc3a9d741-d845-4b17-ab2a-bbab82dee9d&title=&width=1523.2)
<a name="AQyit"></a>
### 2.2 一个字符串的大小写英文字母及数字
```java
package com.javase.string;

import java.util.Scanner;

import static java.lang.Character.*;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/16:46
 * @Description:
 */
public class SumStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sumStr(str);
    }

    public static void sumStr(String str) {
        int dig = 0;
        int up = 0;
        int low = 0;
        for (int i = 0; i < str.length(); i++) {
            if(isDigit(str.charAt(i))){
                dig++;
            }else if (isUpperCase(str.charAt(i))){
                up++;
            } else if (isLowerCase(str.charAt(i))) {
                low++;
            }
        }
        System.out.println("大写英文字母："+up+" 小写英文字母："+low+" 数字： "+dig);
    }

}

```
<a name="dc9aI"></a>
## 3 ArrayList
<a name="jYUQW"></a>
### 3.1 模仿商家菜品上架
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718181386747-8d1a6a3e-420e-4003-8407-78016f632fda.png#averageHue=%23f6f2f1&clientId=u7b60391d-7b42-4&from=paste&height=434&id=ub0b73a89&originHeight=543&originWidth=1247&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=157670&status=done&style=none&taskId=u0acafc3f-6655-43ca-a110-2fcd17deef8&title=&width=997.6)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718181412109-86a7ad08-c0f7-494b-844a-f3a7faef7163.png#averageHue=%2324262a&clientId=u7b60391d-7b42-4&from=paste&height=773&id=lAoHR&originHeight=966&originWidth=1892&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=232618&status=done&style=none&taskId=u88eb3453-2f88-46e7-8035-2578b0d8473&title=&width=1513.6)
<a name="qvU88"></a>
# Day04 ATMsystem
<a name="oaPA0"></a>
## 1 单字符的输入接收处理示例
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718189814080-62233669-c30d-4802-99d8-06a30d448460.png#averageHue=%231f2126&clientId=u44ab00dc-0aac-4&from=paste&height=358&id=u85101fc3&originHeight=448&originWidth=662&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=84355&status=done&style=none&taskId=u26dc6e19-3686-4ffb-8b05-173726251ce&title=&width=529.6)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718189827551-025bedfd-36cc-4960-bef2-39525ec37c67.png#averageHue=%23222529&clientId=u44ab00dc-0aac-4&from=paste&height=98&id=uc7c309ba&originHeight=122&originWidth=609&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=22019&status=done&style=none&taskId=u5ec2f161-6453-4d3b-be64-a83bc09c80c&title=&width=487.2)
<a name="UoYrc"></a>
### ps：性别只能为男女，特殊处理
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718190215662-e7cff997-1c7b-4ded-8e42-7bccac6bf8fc.png#averageHue=%23202125&clientId=u848f6c63-0fc5-4&from=paste&height=251&id=TeH8O&originHeight=314&originWidth=633&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=38149&status=done&style=none&taskId=uba19cd9e-dc58-482a-981d-5cd93164e5d&title=&width=506.4)
<a name="Nlack"></a>
# 2 登录账户处理
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718245123971-f05d9c08-43a3-49bc-adea-3fd4ac49cb9f.png#averageHue=%231f2125&clientId=u14ec8d5c-90aa-4&from=paste&height=106&id=ua920b244&originHeight=132&originWidth=863&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=25014&status=done&style=none&taskId=u5f74d1d9-1817-4cb1-9986-9394e01e41c&title=&width=690.4)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718245114706-ee430e22-7853-4a9d-934e-e9113d06b415.png#averageHue=%23202226&clientId=u14ec8d5c-90aa-4&from=paste&height=233&id=u2a888b47&originHeight=291&originWidth=840&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=56965&status=done&style=none&taskId=u00f8a2e8-6da4-4f1a-9c27-d9ce00d954b&title=&width=672)
