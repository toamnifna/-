package menu.menu;

import utils.RegularUtils;

import java.io.IOException;

/**
 * @author 陶敏帆
 * @version 1.0
 */
public class QuitTimeOutMenu extends Menu{
    private static final QuitTimeOutMenu quitTimeOutMenu = new QuitTimeOutMenu();

    private QuitTimeOutMenu() {
        setTitle("取消定时关机");
        setContext("确定", "刷新", "返回");
    }

    @Override
    public void show() throws IOException {
        Menu.title(getTitle());
        Menu.context(getContext());

        while (true) {
            switch (Integer.parseInt(RegularUtils.input())) {
                case 1:
                    Runtime.getRuntime().exec("cmd.exe /c shutdown -a");
                    break;
                case 2:
                    show();
                case 3:
                    getLastMenu().show();
            }
        }
    }

    public static QuitTimeOutMenu getInstance() {
        return quitTimeOutMenu;
    }
}
