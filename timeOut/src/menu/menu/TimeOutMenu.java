package menu.menu;

import utils.RegularUtils;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author 陶敏帆
 * @version 1.0
 */
public class TimeOutMenu extends Menu {
    private static final TimeOutMenu timeOutMenu = new TimeOutMenu();

    private TimeOutMenu() {
        setTitle("定时关机");
        setContext("设置关机时间（小时）", "设置关机时间（分钟）", "确定", "刷新", "返回");
    }

    @Override
    public void show() throws IOException {
        Menu.title(getTitle());
        Menu.context(getContext());
        int expectHour = 0;
        int expectMinute = 0;

        while (true) {
            switch (Integer.parseInt(RegularUtils.input())) {
                case 1:
                    System.out.println("输入要关机的小时：");
                    expectHour = Integer.parseInt(RegularUtils.input());
                    break;
                case 2:
                    System.out.println("输入要关机的分钟：");
                    expectMinute = Integer.parseInt(RegularUtils.input());
                    break;
                case 3:
                    //期待的关机时间
                    int expectTime = 3600 * expectHour + 60 * expectMinute;

                    LocalDateTime localDateTime = LocalDateTime.now();
                    int hour = localDateTime.getHour();
                    int minute = localDateTime.getMinute();
                    int nowTime = 3600 * hour + 60 * minute;

                    //距离关机的时间
                    int resultTime = expectTime - nowTime;

                    Process exec = null;
                    //在cmd中执行指令
                    if (resultTime > 0) {
                        String command = "shutdown -s -t " + resultTime;
                        exec = Runtime.getRuntime().exec("cmd.exe /c " + command);
                    } else
                        System.out.println("请输入未来时间");
                    System.out.println("重新设置定时关机，需要先取消定时关机");
                    break;


                case 4:
                    show();
                case 5:
                    getLastMenu().show();
            }

        }
    }

    public static TimeOutMenu getInstance() {
        return timeOutMenu;
    }
}
