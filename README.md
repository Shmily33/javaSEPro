<a name="c32bd6c5"></a>
# javaSE knowledge review and study
<a name="UR4lb"></a>
#### 博客：[https://blog.csdn.net/qq_46143063/article/details/139690322?spm=1001.2014.3001.5501](https://blog.csdn.net/qq_46143063/article/details/139690322?spm=1001.2014.3001.5501)
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
<a name="U91Fh"></a>
## 2 登录账户处理
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718245123971-f05d9c08-43a3-49bc-adea-3fd4ac49cb9f.png#averageHue=%231f2125&clientId=u14ec8d5c-90aa-4&from=paste&height=106&id=ua920b244&originHeight=132&originWidth=863&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=25014&status=done&style=none&taskId=u5f74d1d9-1817-4cb1-9986-9394e01e41c&title=&width=690.4)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718245114706-ee430e22-7853-4a9d-934e-e9113d06b415.png#averageHue=%23202226&clientId=u14ec8d5c-90aa-4&from=paste&height=233&id=u2a888b47&originHeight=291&originWidth=840&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=56965&status=done&style=none&taskId=u00f8a2e8-6da4-4f1a-9c27-d9ce00d954b&title=&width=672)
<a name="eKmUk"></a>
# Day05-06
<a name="sZ30x"></a>
## 1 oop进阶一：static、单例设计模式、继承相关知识
<a name="TNEgb"></a>
### 1.1 homework
（1）<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718355001491-87e28a32-1e01-4f62-a690-50662966065c.png#averageHue=%23eeeded&clientId=u195a97ed-7d0f-4&from=paste&height=404&id=u49a2868f&originHeight=505&originWidth=712&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=37343&status=done&style=none&taskId=ue1d31447-ebc2-4586-835f-9407deb6a8f&title=&width=569.6)<br />（2）<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718355012948-8a9e0f6b-a660-439e-8cfd-b06b35ab49ee.png#averageHue=%23e9e8e7&clientId=u195a97ed-7d0f-4&from=paste&height=506&id=u0f50150b&originHeight=633&originWidth=705&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=89780&status=done&style=none&taskId=u2f251988-8a3c-4c12-a23c-20a6d657435&title=&width=564)
<a name="OF7Fu"></a>
## 2 oop进阶二：多态、final、抽象类、接口相关知识
<a name="G3Y3U"></a>
## 2.1 homework
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718369930799-48836ef4-df93-45d1-8898-f0af01411f22.png#averageHue=%23ececeb&clientId=u2a3a16d3-3a3b-4&from=paste&height=574&id=u6f6edbd5&originHeight=718&originWidth=707&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=48260&status=done&style=none&taskId=u4ecdaa22-db76-4995-8481-7aad51c4283&title=&width=565.6)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718369938839-9155bd4d-71c7-4a7a-92d0-5ddf618fc8d6.png#averageHue=%23f6f4f3&clientId=u2a3a16d3-3a3b-4&from=paste&height=181&id=u8cbf7741&originHeight=226&originWidth=707&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=20484&status=done&style=none&taskId=ud261b348-667e-4508-bb4a-8ed844241ad&title=&width=565.6)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718369957494-6c711c26-ddd2-445c-9a1d-bd83db28f800.png#averageHue=%23242629&clientId=u2a3a16d3-3a3b-4&from=paste&height=578&id=u19ed28e8&originHeight=723&originWidth=1497&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=85359&status=done&style=none&taskId=u4e9fc067-0216-4d04-832b-3f8e00983da&title=&width=1197.6)
<a name="Nu7W9"></a>
# 3 oop进阶三：枚举、泛型、Object类、StringBuilder类等常用API
<a name="QhND0"></a>
## 3.1 homework
(1)
```java
interface Inter {
  void show(); 
}
class Outer { 
  //补齐代码，要求在控制台输出”HelloWorld”

}

class A implements Inter{
  public void show(){
    System.out.println("HelloWorld");
  }
}
public class OuterDemo {
  public static void main(String[] args) {
    Outer.method().show();
  }
}
```
解答：
```java
class Outer {
    public static Inter method() {
        // 静态方法，可通过类名直接调用，不需要创建类的对象实例
        return new A();
    }
}
```

- Inter 接口定义了一个 show() 方法。
- A 类实现了 Inter 接口，并在 show() 方法中输出 "HelloWorld"。
- Outer 类中添加了一个静态方法 method()，该方法返回一个实现了 Inter 接口的对象，这里返回了 A 的实例。
- 在 OuterDemo 的 main 方法中调用 Outer.method().show()，首先通过 Outer.method() 获取到 Inter 接口的实例，然后调用 show() 方法输出 "HelloWorld"。

运行 OuterDemo 类的 main 方法将在控制台输出 "HelloWorld"。
<a name="uy6qN"></a>
# Day06-test 医院挂号系统
<a name="KXuR0"></a>
# Day07
<a name="DwdKF"></a>
## 1 正则表达式
<a name="hTWXA"></a>
## 2 Lambda表达式
<a name="QX3nH"></a>
## 3 异常
<a name="eLLsZ"></a>
## 4 Collection：List、Set
<a name="VDUln"></a>
### 4.1 Set的使用
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718630203072-f2d723af-1434-46bf-93c1-d688d8c0463f.png#averageHue=%23e5e7d3&clientId=uf85d01fe-0c60-4&from=paste&height=541&id=u0c7039a3&originHeight=676&originWidth=702&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=419445&status=done&style=none&taskId=uc9df1286-e785-42d3-a3e2-16c3b2b73f7&title=&width=561.6)
```java
package com.javase.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午9:00
 * @Description:
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("3726221951dg010416");
        set.add("37222219700211041x");
        set.add("37242219680208044x");
        set.add("354221968020850444");
        set.add("37262319800904575x");
        set.add("37222231af303a99673");
        set.add("3711fdg98603040033");
        set.add("373522198511190042");
        set.add("3755sdf1991112998x");
        String regex="([1-9]\\d{17})|([1-9]\\d{16}[xX])";
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            Matcher matcher = Pattern.compile(regex).matcher(it.next());
            if(!matcher.find()){
//                System.out.println(matcher.group());
                it.remove();
            }
        }
        System.out.println(set);
    }

}

```
<a name="kQ0Ym"></a>
# Day08
<a name="bczuL"></a>
## 1 可变参数
<a name="rbXxX"></a>
## 2 Collections类
<a name="U5wti"></a>
## 3 Map
<a name="x2yfc"></a>
## 4 Stream流
<a name="wSj8r"></a>
## 5 homework
<a name="dem0a"></a>
### 5.1 请按照成绩将四名学生从小到大进行排名,并将结果展示出来.
```java
package com.javase.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午7:18
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "小亮", 99));
        students.add(new Student(2, "小强", 88));
        students.add(new Student(3, "小美", 98));
        students.add(new Student(4, "小明", 45));
        students.sort(((o1, o2) -> Double.compare(o2.getScore(), o1.getScore())));
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
        Collections.sort(students, (o1, o2) -> Double.compare(o1.getScore(), o2.getScore()));
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
        students.stream().sorted(((o1, o2) -> Double.compare(o2.getScore(), o1.getScore()))).forEach(System.out::println);
    }
}

```
<a name="dIWXg"></a>
### 5.2 生成双色球
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718624612676-902519c3-14bf-4e82-98d7-3737fe9ae31a.png#averageHue=%23f8efed&clientId=u28d97562-685a-4&from=paste&height=382&id=ubbcccc9d&originHeight=478&originWidth=718&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=119344&status=done&style=none&taskId=u161558b5-c65a-4b96-854a-182d86a75a6&title=&width=574.4)
```java
package com.javase.homework;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午7:29
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        while (hashSet.size() < 6) {
            hashSet.add(random.nextInt(32) + 1);
        }
        System.out.println(hashSet);
        // Collections的sort不能对Set排序：1、赋值转为ArrayList 2、Stream
        List<Integer> collect = hashSet.stream().sorted().collect(Collectors.toList());
        collect.add(random.nextInt(16) + 1);

        System.out.println(collect);
    }
}

```
<a name="WdYt0"></a>
### 5.3 用户注册
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718624748649-6e3ddb59-c612-4897-9303-f904873792bc.png#averageHue=%23fbf9f8&clientId=u28d97562-685a-4&from=paste&height=595&id=u8c2ec660&originHeight=744&originWidth=728&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=68075&status=done&style=none&taskId=u6175c747-90da-4994-b0b9-7a5b63353f5&title=&width=582.4)
```java
package com.javase.homework;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午7:47
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        HashSet<User> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            User user = new User(name, password);
            if (hashSet.contains(user)) { // 需要重写User的hashCode和equals
                System.out.println("用户名重复，请重新输入~");
                System.out.println(hashSet);
            }else {
                hashSet.add(user);
            }
        }
    }
}

```
<a name="a3lyD"></a>
### 5.4 统计
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718626344077-305f760e-bdbe-4c28-a635-bbc700de3408.png#averageHue=%23f9f9f8&clientId=uf85d01fe-0c60-4&from=paste&height=570&id=u323ba94b&originHeight=713&originWidth=745&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=113637&status=done&style=none&taskId=u990d82e5-d737-40ee-826e-6a7158f4cf7&title=&width=596)
```java
package com.javase.homework;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午8:10
 * @Description:
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("end")) break;
            if (hashMap.containsKey(str)) {
                hashMap.put(str, hashMap.get(str) + 1);
            } else {
                hashMap.put(str, 1);
            }
        }
        // 1、Set+Stream直接输出(升序)
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        entrySet.stream().sorted(((o1, o2) -> Double.compare(o1.getValue(), o2.getValue())))
                .forEach(a -> System.out.println(a.getKey() + "售出的数量 " + a.getValue()));
        // 2、new ArrayList<>(hashMap.entrySet()).var (倒序)
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//        hashMap.forEach((k, v) -> System.out.println(k + "售出的数量： " + v));

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) { // 为了按照倒序的格式返回出去需要一个LinkedHashMap
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        linkedHashMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

```
<a name="CAGEO"></a>
### 5.5 HashMap嵌套
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1718628471103-9b8f7834-cccc-4ccf-9fca-eaf80e57b501.png#averageHue=%23eeedec&clientId=uf85d01fe-0c60-4&from=paste&height=230&id=u0f0cdc16&originHeight=287&originWidth=709&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=20114&status=done&style=none&taskId=ubff23773-103d-405f-aa2e-41c292655d8&title=&width=567.2)
```java
package com.javase.homework;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午8:47
 * @Description:
 */
public class Test5 {
    public static void main(String[] args) {
        HashMap<String, String> javaSE = new HashMap<>();
        javaSE.put("001", "wgs1");
        javaSE.put("002", "wgs2");
        HashMap<String, String> javaEE = new HashMap<>();
        javaEE.put("001", "wgs3");
        javaEE.put("002", "wgs4");
        HashMap<String, HashMap<String, String>> map = new HashMap<>();
        map.put("javaSE", javaSE);
        map.put("javaEE", javaEE);
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k2, v2) -> {
                System.out.println("\t" + k2 + "--" + v2);
            });
        });
    }
}

```
<a name="jIKQ0"></a>
# Day08-test
<a name="30a010ca"></a>
## **考试题目**
<a name="9202d38c"></a>
### 第一题（10分）
**需求**<br />目前有100名囚犯，每个囚犯的编号是1-200之间的随机数。现在要求依次随机生成100名囚犯的编号（要求这些囚犯的编号是不能重复的），然后让他们依次站成一排。(注：位置是从1开始计数的)，接下来，国王命令手下先干掉全部奇数位置处的人。剩下的人，又从新按位置1开始，再次干掉全部奇数位置处的人，依此类推，直到最后剩下一个人为止，剩下的这个人为幸存者。<br />**具体功能点的要求如下：**<br />请输出幸存者的编号，以及他第一次所占的位置值是多少。<br />**评分细则**

-  能做出第一步：生产100个随机编号，且占位成功的，给3分。
-  能成功删除奇数位置处的数据的，给5分。
-  能正确获取结果的给2分。

<a name="4abef66e"></a>
### 第二题（14）

-  User 实体类，包含如下属性
    - private Long id;  // 用户id 名
    - private String gender;  //性别
    - private LocalDate birthday;  //生日
    - 注意需要提供 set和get方法，以及toString方法
-  新建测试类，类中 main 方法，在方法中完成如下业务逻辑：
    -  **业务一：**
        -  有如下字符串，里面包含多个用户信息数据，现在需要你解析这个字符串，获取里面的用户数据，并封装到User对象中
        -  多个User对象在添加到List 集合中
```java
String userStrs = "10001:张三:男:1990-01-01#10002:李四:女:1989-01-09#10003:王五:男:1999-09-09#10004:刘备:男:1899-01-01#10005:孙悟空:男:1900-01-01#10006:张三:女:1999-01-01#10007:刘备:女:1999-01-01#10008:张三:女:2003-07-01#10009:猪八戒:男:1900-01-01";
```


      -  注意： 
         - 字符串中的规则如下，多个用户用 # 拼接，用户的信息之间用 : 拼接。
         - 其中用户id和生日是需要进行类型转换的，其中id需要将String转成Long，生日需要将String转成LocalDate
-  **业务二：**
    - 遍历上面获取的List 集合，统计里面每个名字出现的次数。
    - 封装到Map<String,Integer>集合中，集合的key就是名字，value就是名字出现的次数。
    - 最后遍历打印map数据，打印内容如下：
        - 张三：3次
        - 李四：5次

<a name="1d186b0a"></a>
### 第三题（16）
**需求**：<br />某护士小花，作息规律为上二天班，休息一天，经常不确定休息日是否是周末（**注：首次休息日是2022年2月3日**）。<br />**具体功能点的要求如下**<br />1、请你开发一个程序，当小花输入年以及月后，立即显示出该月份的休息日详情。<br />示范（注意：示范信息重点在于参考格式，结果不一定是准确的，请自行确保计算结果正确性）：<br />**请小花输入查询的月份（月份必须是2022年2月之后的月份）： 2023-5 。**<br />**2023-5-1[休息]   2023-5-2   2023-5-3  2023-5-4[休息] ...**<br />2、显示出该月份哪些休息日是周六或周日（请依次列出具体的日期和其星期信息）。<br />3、小花给自己设置了一个高考倒计时。高考的开始时间为：2023年06月07日 上午9：00 。**请利用给的素材代码（在Timer文件夹下）**，补全代码，产生一个如下的倒计时效果，倒计时格式如下图所示：
<a name="Tn1W1"></a>
### 第四题（22分）
**需求：**<br />ArrayList集合是很重要的一种集合，请手工书写一个MyArrayList集合模拟ArrayList集合。<br />**具体功能点的要求如下：**<br />1、MyArrayList需要支持泛型，内部使用数组作为容器。<br />2、在MyArrayList中开发add方法，用于添加数据的，需要遵循ArrayList的扩容机制（自行设计代码，不需要与ArrayList的源代码一样，思想一致即可）<br />3、在MyArrayList中开发根据索引查询数据的get方法。<br />4、在MyArrayList中开发根据索引删除数据的remove方法。<br />5、在MyArrayList中开发一个获取集合大小的size ()方法。<br />6、能够在MyArrayList集合中开发一个forEach方法，这个方法支持使用Lambda进行遍历，至于函数式接口叫什么名称无所谓。<br />7、编写测试用例对自己编写的MyArrayList集合进行功能正确性测试。

<a name="86b8fda3"></a>
### 第五题（16分）
**需求：**<br />给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。<br />如果数组中不存在目标值 `target`，返回 `[-1, -1]`。<br />**注意：必须确保程序的时间复杂度是o(log2n)，否则不给分数**<br />**具体功能点的要求如下：**
```
数组 nums = [5,7,7,8,8,10], target = 8
得到结果是：[3,4]
```

```
数组：nums = [5,7,7,8,8,10], target = 6
得到结果是：[-1,-1]
```

```
数组：nums = [], target = 0
得到结果是：[-1,-1]
```

请设计一个方法完成以上需求，并编写测试代码完成上述测试。
<a name="e3d7727d"></a>
### 第六题（22）
**需求**<br />给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，并返回 反转后的链表 。<br />**示例 1：**
```
比如 head 指向的链表内容大致是 1,2,3,4,5 , left = 2, right = 4
反转后的链表就是 1,4,3,2,5

如果链表只有一个节点：head指向的是 5  ，left = 1, right = 1
反转后的链表就还是 5
```

**具体功能点的要求如下**<br />1、设计一个Node泛型类，用于代表链表的结点。每个结点包含（数据data，和下一个结点的地址值next） 3<br />2、开发一个类叫MyLinkedList，提供一个add方法可以让用户添加链表的结点，直到用户输入exit，则返回链表（返回链表实际上是返回链表的头结点） 5<br />3、提供一个reverse方法，接收头指针 head 和两个整数 left 和 right ，其中 left <= right，按上面的要求进行反转。反转后，返回新的链表 9<br />4、提供一个forEach方法，接收新链表，并对其进行遍历输出。 5
<a name="F4Knt"></a>
# Day09
<a name="URtFC"></a>
## File、IO流
<a name="Qh3ZG"></a>
# Day10
<a name="e41Mm"></a>
## 1 特殊文本文件、日志技术
<a name="yuBT7"></a>
## 2 多线程
<a name="qm6O0"></a>
### 2.1 三种创建方式
<a name="ZmOhZ"></a>
### 2.2 常用方法
<a name="asIav"></a>
### 2.3 线程池
