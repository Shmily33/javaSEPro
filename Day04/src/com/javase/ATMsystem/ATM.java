package com.javase.ATMsystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/18:19
 * @Description: atm的业务需求
 */
public class ATM {

    // 账户存储信息
    ArrayList<Account> accountList = new ArrayList<>();
    Scanner sc = new Scanner(System.in); // 只创建一次对象，节约内存
    private Account loginAccount; // 当前登录用户

    // 只有启动页可以暴露
    public void start() {
        while (true) {
            System.out.println("==欢迎进入银行ATM系统==");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.println("3、退出");
            System.out.println("请选择您要操作的命令：");
            //sc
            String choice = sc.next();
            switch (choice) {
                case "1":
                    Login();
                    break;
                case "2":
                    createAccount();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入的命令不存在，请重新输入!");
            }
        }

    }

    private void Login() {
        System.out.println("==登录界面==");
        if (accountList.isEmpty()) {
            System.out.println("您好，当前系统无账户~");
        } else {
            while (true) {
                System.out.println("请输入您的卡号：");
                String accNo = sc.next();
                Account curAccount = isExist(accNo);
                if (curAccount != null) {
                    while (true) {
                        System.out.println("请输入密码：");
                        if (sc.next().equals(curAccount.getPassword())) {
                            System.out.println("欢迎用户：" + curAccount.getAccName() + " 登录ATM系统,您的卡号是：" + curAccount.getAccNo());
                            //show 登录后的界面
                            loginAccount = curAccount; // 以全局变量存储当前登录用户 更合理
                            showUserCommand(); // 也可传入curAccount
                            return; // 跳出并结束login()
                        } else {
                            System.out.println("您输入的密码不正确~");
                        }
                    }

                } else {
                    System.out.println("卡号不存在~");
                }
            }
        }


    }

    // 系统是否存在该卡号
    private Account isExist(String accNo) {
        for (Account account : accountList) {
            if (account.getAccNo().equals(accNo)) {
                return account;
            }
        }
        return null;
    }

    // 用户操作页面
    private void showUserCommand() {
        while (true) {
            System.out.println("==" + loginAccount.getAccName() + ",您可以办理以下业务==");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销账户");
            System.out.println("请选择：");
            // 以下功能无法暴露
            switch (sc.next()) {
                case "1":
                    showLoginAccount();
                    break;
                case "2":
                    saveMoney();
                    break;
                case "3":
                    withdrawMoney();
                    break;
                case "4":
                    transferMoney();
                    break;
                case "5":
                    changePassword();
                    return;
                case "6":
                    System.out.println(loginAccount.getAccName() + "，您退出当前界面成功~");
                    return;
                case "7":
                    if (deleteAccount()) {
                        return;
                    }
                    break;
                default:
                    System.out.println("您输入的命令不存在，请确认~");
            }
        }

    }

    private void showLoginAccount() {
        System.out.println("==您的账户信息如下：==");
        System.out.println("1、卡号：" + loginAccount.getAccNo());
        System.out.println("2、户主：" + loginAccount.getAccName());
        System.out.println("3、性别：" + loginAccount.getSex());
        System.out.println("4、余额：" + loginAccount.getMoney());
        System.out.println("5、每次取现额度：" + loginAccount.getLimit());
    }

    private void saveMoney() {
        System.out.println("==存钱操作==");
        System.out.println("请输入您要存入的金额为：");
        double money = sc.nextDouble();
        loginAccount.setMoney(loginAccount.getMoney() + money);
        System.out.println("您存入的额度为：" + money + " 您的账户现余额：" + loginAccount.getMoney());
    }


    private void withdrawMoney() {
        System.out.println("==取钱操作==");
        if (loginAccount.getMoney() < 100) {
            System.out.println("您的账户余额小于100元，不允许取款~");
            return;
        }
        while (true) {
            System.out.println("请输入您要取出的金额为：");
            double money = sc.nextDouble();
            if (money > loginAccount.getMoney()) {
                System.out.println("您要取的金额大于账户余额,账户余额为：" + loginAccount.getMoney());
            } else {
                if (money > loginAccount.getLimit()) {
                    System.out.println("您要取出的金额超过当前账户每次取现额度，每次最多可取：" + loginAccount.getLimit());
                } else {
                    loginAccount.setMoney(loginAccount.getMoney() - money);
                    System.out.println("您取出的金额为：" + money + " 账户所剩余额：" + loginAccount.getMoney());
                    break;
                }
            }
        }


    }


    private void transferMoney() {
        System.out.println("==转账操作==");
        if (accountList.size() < 2) {
            System.out.println("ATM系统只有一个账户，不允许转账~");
            return;
        }
        if (loginAccount.getMoney() == 0) {
            System.out.println("您的账户没有米呀，不允许转账~");
            return;
        }
        while (true) {
            System.out.println("请输入您要转账的卡号：");
            String tranNo = sc.next();
            Account transAccount = isExist(tranNo);
            if (transAccount != null) {
                // 对方的账户存在，继续让用户认证姓氏。
                String name = "*" + transAccount.getAccName().substring(1); // * + 马刘德华
                System.out.println("您当前要为" + name + "转账");
                System.out.println("请您输入【" + name + "】的姓氏：");
                String preName = sc.next();
                if (transAccount.getAccName().startsWith(preName)) {
                    while (true) {
                        System.out.println("请输入您要转出的金额：");
                        double money = sc.nextDouble();
                        if (money > loginAccount.getMoney()) {
                            System.out.println("您的账号余额为：" + loginAccount.getMoney() + ",无法转出金额：" + money);
                        } else {
                            loginAccount.setMoney(loginAccount.getMoney() - money);
                            transAccount.setMoney(transAccount.getMoney() + money);
                            System.out.println("转账成功，您的账户余额：" + loginAccount.getMoney());
                            return;
                        }
                    }
                } else {
                    System.out.println("您输入的姓氏错误，认证失败~！");
                }

            } else {
                System.out.println("您输入的卡号不存在~");
            }
        }
    }

    private void changePassword() {
        System.out.println("=账户密码修改操作=");
        while (true) {
            System.out.println("请输入原密码");
            String prePassword = sc.next();
            if (prePassword.equals(loginAccount.getPassword())) {
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPassword = sc.next();
                    System.out.println("请输入确认密码：");
                    String checkPassword = sc.next();
                    if (checkPassword.equals(newPassword)) {
                        loginAccount.setPassword(checkPassword);
                        System.out.println("密码修改成功~");
                        return;
                    } else {
                        System.out.println("两次密码输入不一致，请确认！");
                    }
                }
            } else {
                System.out.println("密码错误，请确认！");
            }
        }
    }

    private boolean deleteAccount() {
        System.out.println("==销户操作==");
        System.out.println("您当前要进行销户操作，输入y/n确认：");
        String command = sc.next();
        if (command.equals("y")) {
            if (loginAccount.getMoney() == 0) {
                accountList.remove(loginAccount);
                System.out.println("已销户成功~");
                return true;
            } else {
                System.out.println("账户中仍有余额，不允许销户~！");
                return false;
            }
        }
        System.out.println("仍保留账户~");
        return false;
    }


    // 开户
    private void createAccount() {
        System.out.println("==开户界面==");
        System.out.println("请输入您的账户用户名：");
        Account account = new Account();
        String name = sc.next();
        account.setAccName(name);

        while (true) {
            System.out.println("请输入您的性别："); //'男' '女'
            char sex = sc.next().charAt(0); // 取单个字符
            if (sex == '男' || sex == '女') {
                account.setSex(sex);
                break;
            } else {
                System.out.println("性别只能为男或女~");
            }
        }

        while (true) {
            System.out.println("请输入您的密码：");
            String password = sc.next();
            System.out.println("请输入您的确认密码：");
            String checkPassword = sc.next();
            if (checkPassword.equals(password)) {
                account.setPassword(password);
                break;
            } else {
                System.out.println("两次密码输入不一致，请确认~！");
            }
        }
        System.out.println("请输入您的取现额度：");
        double limit = sc.nextDouble();
        account.setLimit(limit);
        String accNo = createAccNo();
        account.setAccNo(accNo);
        System.out.println("恭喜您：" + account.getAccName() + " 开户成功，您的卡号是：" + account.getAccNo());
        accountList.add(account);
    }

    // 创建卡号
    private String createAccNo() {
        while (true) {
            String accNo = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                accNo += random.nextInt(10); // 0-9
            }
            if (isDiffNo(accNo)) {
                return accNo;
            }
        }

    }

    // 卡号判重
    private boolean isDiffNo(String accNo) {
        for (int i = 0; i < accountList.size(); i++) {
            String curAccNo = accountList.get(i).getAccNo();
            if (curAccNo.equals(accNo)) {
                return false;
            }
        }
        return true;
    }


}
